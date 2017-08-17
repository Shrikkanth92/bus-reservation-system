package com.polaris.teamd.db;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import com.polaris.teamd.common.PropertyFileProcessing;
import com.polaris.teamd.common.utils.IOUtil;
import com.polaris.teamd.common.utils.ReflectionUtil;

public class CQueryGenerator {
	private CQuery cQuery;
	String finalQuery;
	private String queryType;
	private int rowNum;
	private String statementKey;
	PreparedStatement preparedStatement;
	PropertyFileProcessing dbProcessing, ormProcessing, ormProcessing1;
	int j = 0;

	{
		ormProcessing = new PropertyFileProcessing();
		ormProcessing1 = new PropertyFileProcessing();

		dbProcessing = new PropertyFileProcessing();
		dbProcessing.setPropertyFile(new File("resources/db/db.properties"));
	}

	public CQueryGenerator() {
		super();
	}

	public CQueryGenerator(CQuery query) {
		super();
		this.cQuery = query;
	}

	public void setQuery(CQuery query) {
		this.cQuery = query;
	}

	public CQuery generateQuery(String queryType, Object object,
			Connection connection) {

		Class c = object.getClass();
		setORMPropertyFile(c);
		cQuery.setQueryType(queryType);
		this.queryType = queryType;

		statementKey = c.getSimpleName() + "-" + queryType;
		if (!(JDBCStatementCache.statementCache.containsKey(statementKey))
				|| (queryType.equalsIgnoreCase("select"))) {

			String queryTemplate = (generateBaseQuery(queryType));

			StringBuffer query = new StringBuffer();
			if (queryType.equalsIgnoreCase("insert"))
				query.append(insertCommand(queryTemplate));
			if (queryType.equalsIgnoreCase("delete"))
				query.append(deleteCommand(queryTemplate));
			if (queryType.equalsIgnoreCase("select"))
				query.append(selectCommand(queryTemplate));
			if (queryType.equalsIgnoreCase("update"))
				query.append(updateCommand(queryTemplate));
			if (queryType.equalsIgnoreCase("softDelete"))
				query.append(softDeleteCommand(queryTemplate));

			if (!queryType.equalsIgnoreCase("insert")) {
				query.append(" ");
				query.append(getCondition());
			}
			if (queryType.equalsIgnoreCase("select")) {
				query.append(" ");
				query.append(getSortOrder());
			}

			finalQuery = new String(query).toUpperCase();
			cQuery.setQuery(finalQuery);

			System.out.println(finalQuery);

			try {

				preparedStatement = connection.prepareStatement(finalQuery);
				JDBCStatementCache.put(statementKey, preparedStatement);
				cQuery.setStatementKey(statementKey);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		preparedStatement = JDBCStatementCache.statementCache.get(statementKey);

		prepareStatement(object);
		JDBCStatementCache.put(statementKey, preparedStatement);
		cQuery.setStatementKey(statementKey);

		return cQuery;
	}

	private void prepareStatement(Object object) {
		if (queryType.equalsIgnoreCase("insert")
				|| queryType.equalsIgnoreCase("update"))
			fillQuery(object);
		else
			setCondition();
	}

	private void setCondition() {
		String methodName;
		Method method;
		j = 0;
		try {
			Collection<CCondition> conditions = cQuery.getCriteria();
			if (conditions.size() != 0)
				for (CCondition cCondition : conditions) {
					Object condition = quoteData(cCondition.getPropertyValue());
					Class type = condition.getClass();
					if (type == Integer.class)
						type = int.class;
					methodName = ReflectionUtil.formMethodName(
							type.getSimpleName(), "set");
					method = ReflectionUtil.findMethod(PreparedStatement.class,
							methodName, int.class, type);
					method.invoke(preparedStatement, ++j, condition);
				}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	private String getDBProperty(String propertyName) {
		return dbProcessing.getStringProperty(propertyName);
	}

	private String getORMProperty(String propertyName) {
		String tableName = ormProcessing.getStringProperty("orm.beanTable");
		return ormProcessing.getStringProperty(propertyName);
	}

	private void setORMPropertyFile(Class c) {
		String ormFileName = "resources/orm/" + c.getSimpleName()
				+ "-orm.properties";
		ormProcessing.setPropertyFile(IOUtil.getFile(ormFileName));
	}

	public String generateBaseQuery(String queryType) {
		if (queryType.equalsIgnoreCase("insert"))
			return getDBProperty("db.insertCommand");
		if (queryType.equalsIgnoreCase("update"))
			return getDBProperty("db.updateCommand");
		if (queryType.equalsIgnoreCase("delete"))
			return getDBProperty("db.deleteCommand");
		if (queryType.equalsIgnoreCase("select"))
			return getDBProperty("db.selectCommand");
		if (queryType.equalsIgnoreCase("softDelete"))
			return getDBProperty("db.softDeleteCommand");
		return null;
	}

	private String insertCommand(String query) {
		String tableName = ormProcessing.getStringProperty("orm.beantable");
		String columnList = ormProcessing
				.getIndexedPropertyValuesAsList(".column");
		int columnCount = ormProcessing.getIndexedPropertyCount(".column");
		StringBuffer valueList = new StringBuffer();

		for (int i = 0; i < columnCount; i++) {
			if (i == 0)
				valueList.append(" ?");
			else
				valueList.append(", ?");
		}

		String tableTemplate = "<tableName>";
		query = query.replace(tableTemplate, tableName);

		String columnTemplate = "<columnList>";
		query = query.replace(columnTemplate, columnList);

		String valueTemplate = "<valueList>";
		query = query.replace(valueTemplate, valueList);

		return query;
	}

	private String deleteCommand(String query) {
		String tableName = ormProcessing.getStringProperty("orm.beantable");

		String tableTemplate = "<tableName>";
		query = query.replace(tableTemplate, tableName);

		return query;
	}

	private String softDeleteCommand(String query) {
		String tableName = ormProcessing.getStringProperty("orm.beantable");
		String tableTemplate = "<tableName>";
		query = query.replace(tableTemplate, tableName);
		return query;
	}

	private String selectCommand(String query) {
		String tableName = ormProcessing.getStringProperty("orm.beantable");
		String columnList = ormProcessing
				.getIndexedPropertyValuesAsList(".column");
		int columnCount = ormProcessing.getIndexedPropertyCount(".column");

		StringBuffer valueList = new StringBuffer();

		for (int i = 0; i < columnCount; i++) {
			if (i == 0)
				valueList.append(" ?");
			else
				valueList.append(", ?");
		}

		String tableTemplate = "<tableName>";
		query = query.replace(tableTemplate, tableName);

		String columnTemplate = "<columnList>";
		query = query.replace(columnTemplate, columnList);

		return query;
	}

	private String updateCommand(String query) {
		String tableName = ormProcessing.getStringProperty("orm.beantable");
		String[] columnList = ormProcessing.getIndexedPropertyValues(".column");
		int columnCount = ormProcessing.getIndexedPropertyCount(".column");
		int i = 0;
		for (String column : columnList) {
			if (++i < columnCount)
				columnList[i - 1] = (column + "= ?, ");
			else
				columnList[i - 1] = (column + "= ?");
		}
		String tableTemplate = "<tableName>";
		query = query.replace(tableTemplate, tableName);
		String columnTemplate = "<columnName=value>";
		query = query.replace(columnTemplate, "");
		StringBuffer queryTemplate = new StringBuffer(query);
		for (String column : columnList) {
			queryTemplate.append(column);
		}
		return new String(queryTemplate);
	}

	private String getCondition() {
		StringBuffer condition = new StringBuffer();
		ArrayList<CCondition> conditions = cQuery.getCriteria();
		Object conditionName;
		for (CCondition cCondition : conditions) {
			condition.append(getCriteriaPrefix(cCondition.getCriteriaPrefix()));
			condition.append(" ");
			conditionName = cCondition.getPropertyName();
			if (conditionName.toString().equalsIgnoreCase("softDelete")) {
				condition.append(getFlag(conditionName));
			} else
				condition.append(getColumnName(conditionName));
			condition.append(cCondition.getOperator());
			condition.append(" ?");

			// condition.append("'");
			// condition.append(cCondition.getPropertyValue());
			// condition.append("'");
			if (conditions.indexOf(cCondition) < (conditions.size() - 1))
				condition.append(" ");
		}
		return new String(condition);
	}

	private StringBuffer getFlag(Object flagName) {
		String[] nameList = ormProcessing.getIndexedPropertyValues(".flag");
		String[] columnList = ormProcessing.getIndexedPropertyValues(".value");
		int i = 0, index = 0;
		for (String name : nameList) {
			if (flagName.toString().equalsIgnoreCase(name))
				index = i;
			i++;
		}
		return new StringBuffer(columnList[index]);
	}

	private String getCriteriaPrefix(int criterion) {
		String[] criteriaPrefix = dbProcessing
				.getIndexedPropertyValues("criteriaPrefix");
		return criteriaPrefix[criterion - 1];
	}

	private String getSortOrder() {
		StringBuffer sort = new StringBuffer();
		for (CSortDetails cSortDetails : cQuery.getOrderBy()) {
			if (cQuery.getOrderBy().indexOf(cSortDetails) == 0) {
				sort.append(getSortPrefix(cSortDetails.getSortPrefix()));
				sort.append(" ");
			}

			sort.append(getColumnName(cSortDetails.getPropertyName()));
			sort.append(" ");
			sort.append(getSortType(cSortDetails.getSortType()));

			// sort.append(" ?");
			if (cQuery.getOrderBy().indexOf(cSortDetails) < (cQuery
					.getOrderBy().size() - 1))
				sort.append(", ");
		}
		return new String(sort);
	}

	private String getSortPrefix(int prefix) {
		String[] sortPrefix = dbProcessing
				.getIndexedPropertyValues("sortPrefix");
		return sortPrefix[prefix];
	}

	private String getSortType(int type) {
		String[] sortType = dbProcessing.getIndexedPropertyValues("sortType");
		return sortType[type];
	}

	private StringBuffer getColumnName(Object propertyName) {
		String[] nameList = ormProcessing.getIndexedPropertyValues(".name");
		String[] columnList = ormProcessing.getIndexedPropertyValues(".column");
		int i = 0, index = 0;
		for (String name : nameList) {
			if (propertyName.toString().equalsIgnoreCase(name))
				index = i;
			i++;
		}
		return new StringBuffer(columnList[index]);
	}

	public void fillQuery(Object object) {
		setORMPropertyFile(object.getClass());
		Object[] results;
		try {
			results = getResults(object);
			getFilledQuery(results);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object[] getResults(Object object) throws Exception {
		Class class1 = object.getClass();
		String[] nameList = ormProcessing.getIndexedPropertyValues(".name");
		Field[] fields = new Field[nameList.length];
		String[] methodNames = new String[nameList.length];
		Object[] results = new Object[nameList.length];

		for (int i = 0; i < fields.length; i++) {
			if (nameList[i].contains(".")) {
				results[i] = getAggregatedResults(nameList[i], object);
			} else {
				fields[i] = class1.getDeclaredField(nameList[i]);
				methodNames[i] = verifyMethodName(nameList[i],
						fields[i].getType());

				results[i] = ReflectionUtil.invokeGetterMethod(object,
						methodNames[i]);
			}
		}
		return results;
	}

	private Object getAggregatedResults(String name, Object object)
			throws Exception {

		Class class1 = object.getClass();
		String[] nameList;
		String[] splitNames = name.split("\\.");
		Field field;
		String methodName = null;
		Object result = null;
		ormProcessing1.setPropertyFile(new File("resources/orm/"
				+ class1.getSimpleName() + "-orm.properties"));

		for (int i = 0; i < splitNames.length; i++) {

			nameList = ormProcessing1.getIndexedPropertyValues(".name");
			field = class1.getDeclaredField(splitNames[i]);
			methodName = verifyMethodName(splitNames[i], field.getType());

			object = ReflectionUtil.invokeGetterMethod(object, methodName);
			result = (object);
			if (i < splitNames.length - 1) {
				ormProcessing1.setPropertyFile(new File("resources/orm/"
						+ field.getType().getSimpleName() + "-orm.properties"));

				class1 = object.getClass();
			}
		}
		return result;
	}

	private String verifyMethodName(String name, Class class2) {
		if (class2.equals(boolean.class))
			if (name.substring(0, 2).equals("is"))
				return name;
			else
				return ReflectionUtil.formMethodName(name, "is");
		else
			return ReflectionUtil.formMethodName(name, "get");
	}

	private Object quoteData(Object object) {
		if (object.getClass() == Boolean.class)
			if (object.toString() == "true")
				return "Y";
			else
				return "N";
		else if (object.getClass() == java.util.Date.class) {
			return new Timestamp(((java.util.Date) object).getTime());
		}
		return object;

	}

	private void getFilledQuery(Object[] results)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		String methodName;
		Method method;

		for (int i = 0; i < results.length; i++) {
			results[i] = quoteData(results[i]);
			Class type = results[i].getClass();
			if (type == Integer.class)
				type = int.class;
			methodName = ReflectionUtil.formMethodName(type.getSimpleName(),
					"set");
			method = ReflectionUtil.findMethod(PreparedStatement.class,
					methodName, int.class, type);
			method.invoke(preparedStatement, i + 1, results[i]);
			j = results.length;
		}
		System.out.println(j);
		if (queryType.equalsIgnoreCase("update"))
			for (CCondition cCondition : cQuery.getCriteria()) {
				Object condition = quoteData(cCondition.getPropertyValue());
				Class type = condition.getClass();
				if (type == Integer.class)
					type = int.class;
				methodName = ReflectionUtil.formMethodName(
						type.getSimpleName(), "set");
				method = ReflectionUtil.findMethod(PreparedStatement.class,
						methodName, int.class, type);
				System.out.println(methodName + j + condition);
				method.invoke(preparedStatement, ++j, condition);
			}

	}

}
