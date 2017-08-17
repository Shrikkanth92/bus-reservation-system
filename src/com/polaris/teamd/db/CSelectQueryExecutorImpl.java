package com.polaris.teamd.db;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import com.polaris.teamd.common.PropertyFileProcessing;
import com.polaris.teamd.common.utils.DBDateUtil;
import com.polaris.teamd.common.utils.UIDateUtil;
import com.polaris.teamd.common.utils.IOUtil;

public class CSelectQueryExecutorImpl<E> implements CSelectQueryExecutor<E> {
	private PropertyFileProcessing ormProcessing, ormProcessing1;
	private Connection connection;
	private String[] beanPropertyNames;
	private ResultSet resultSet;
	private Class class1;
	private Object beanObject;
	private Field[] fields;
	private Statement statement;

	{
		ormProcessing = new PropertyFileProcessing();
		ormProcessing1 = new PropertyFileProcessing();
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void releaseConnection() {
	}

	@Override
	public E executeSingleResult(CQuery cQuery, Class class1) throws Exception {
		this.class1 = class1;
		setOrmPropertyFile();
		String statementKey = cQuery.getStatementKey();
		PreparedStatement statement = JDBCStatementCache.statementCache
				.get(statementKey);
		resultSet = statement.executeQuery();
		resultSet.next();
		if (resultSet.getRow() == 0)
			return (E) class1.newInstance();
		else
			executeResult(cQuery, class1);
		return (E) beanObject;
	}

	@Override
	public Collection<E> executeMultipleResults(CQuery cQuery, Class class1)
			throws Exception {
		this.class1 = class1;
		Collection<E> results = new ArrayList<E>();
		setOrmPropertyFile();
		String statementKey = cQuery.getStatementKey();
		PreparedStatement statement = JDBCStatementCache.statementCache
				.get(statementKey);
		resultSet = statement.executeQuery();
		resultSet.next();
		if (resultSet.getRow() == 0) {
			results.add((E) class1.newInstance());
		} else
			do {
				results.add(executeResult(cQuery, class1));
			} while (resultSet.next());
		return results;
	}

	public Collection<E> executeMultipleResults(CQuery cQuery, Class class1,
			int startIndex, int endIndex) throws Exception {
		this.class1 = class1;
		Collection<E> results = new ArrayList<E>();
		setOrmPropertyFile();
		String statementKey = cQuery.getStatementKey();
		PreparedStatement statement = JDBCStatementCache.statementCache
				.get(statementKey);
		resultSet = statement.executeQuery();
		for (int i = 0; i < startIndex; i++) {
			resultSet.next();
		}
		do {
			results.add(executeResult(cQuery, class1));
		} while (resultSet.next() && (startIndex++ < endIndex));
		return results;
	}

	private E executeResult(CQuery cQuery, Class class1) throws SQLException,
			Exception, InstantiationException, IllegalAccessException,
			NoSuchFieldException, NoSuchMethodException,
			InvocationTargetException {
		String[] columnValues = getColumnValuesAsArray(resultSet);
		beanObject = class1.newInstance();
		int count = ormProcessing.getIndexedPropertyCount(".name");
		beanPropertyNames = new String[count];
		fields = new Field[count];
		Method[] beanSetterMethods = new Method[count];
		Object[] results = new Object[count];
		beanPropertyNames = ormProcessing.getIndexedPropertyValues(".name");

		for (int i = 0; i < beanPropertyNames.length; i++) {
			if (beanPropertyNames[i].contains(".")) {
				Class class2 = beanObject.getClass();
				String[] splitNames = beanPropertyNames[i].split("\\.");
				Field field;
				Method method = null;
				String methodName = null;
				Object result = null;
				Object object = beanObject;
				ormProcessing1.setPropertyFile(new File("resources/orm/"
						+ class2.getSimpleName() + "-orm.properties"));

				for (int j = 0; j < splitNames.length; j++) {

					if (j == splitNames.length - 1) {
						field = class2.getDeclaredField(splitNames[j]);
						methodName = verifySetMethod(splitNames[j],
								field.getType());
						method = class2.getMethod(methodName, field.getType());

						results[i] = typeConverter(columnValues[i].toString(),
								field.getType());
						object = method.invoke(result, results[i]);

					} else {
						field = class2.getDeclaredField(splitNames[j]);
						methodName = verifyGetMethod(splitNames[j],
								field.getType());
						method = class2.getMethod(methodName);

						Object object1 = method.invoke(object);
						if (object1 == null) {
							methodName = verifySetMethod(splitNames[j],
									field.getType());
							method = class2.getMethod(methodName,
									field.getType());

							Object newObject = field.getType().newInstance();
							method.invoke(object, newObject);

							methodName = verifyGetMethod(splitNames[j],
									field.getType());
							method = class2.getMethod(methodName);
							object1 = method.invoke(object);

							object1 = newObject;
						}
						result = object1;

						ormProcessing1.setPropertyFile(new File(
								"resources/orm/"
										+ field.getType().getSimpleName()
										+ "-orm.properties"));
						class2 = object1.getClass();
					}
				}
			} else {

				fields[i] = class1.getDeclaredField(beanPropertyNames[i]);
				results[i] = typeConverter(columnValues[i].toString(),
						fields[i].getType());

				beanSetterMethods[i] = getSetterMethod(beanPropertyNames[i],
						fields[i]);
				beanSetterMethods[i].invoke(beanObject, results[i]);
			}
		}
		return (E) beanObject;

	}

	private String verifyGetMethod(String name, Class class2) {
		char first = Character.toUpperCase(name.charAt(0));
		if (class2.equals(boolean.class))
			if (name.substring(0, 2).equals("is"))
				return name;
			else
				return "is" + first + name.substring(1);
		else
			return "get" + first + name.substring(1);
	}

	private String verifySetMethod(String name, Class class2) {
		char first = Character.toUpperCase(name.charAt(0));
		if (class2.equals(boolean.class))
			if (name.substring(0, 2).equals("is")) {
				first = Character.toUpperCase(name.charAt(2));
				return "set" + first + name.substring(3);
			}
		return "set" + first + name.substring(1);
	}

	private String[] getColumnValuesAsArray(ResultSet resultSet)
			throws Exception {
		int columnCount = resultSet.getMetaData().getColumnCount();
		String[] columnValues = new String[columnCount];
		for (int i = 0; i < columnCount; i++) {
			columnValues[i] = (String) resultSet.getString(i + 1);
		}
		return columnValues;
	}

	public void setOrmPropertyFile() {
		StringBuffer ormFileName = new StringBuffer("resources/orm/").append(
				class1.getSimpleName().toLowerCase()).append("-orm.properties");
		try {
			ormProcessing
					.setPropertyFile(IOUtil.getFile(ormFileName.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Method getSetterMethod(String beanPropertyName, Field field)
			throws SecurityException, NoSuchMethodException {
		StringBuffer methodName = new StringBuffer(beanPropertyName);
		String firstLetter = beanPropertyName.substring(0, 1).toUpperCase();
		if (field.getType().equals(boolean.class)) {
			if (methodName.toString().startsWith("is"))
				methodName.delete(0, 2);
			firstLetter = beanPropertyName.substring(0, 1).toUpperCase();
		}
		methodName.insert(0, firstLetter);
		methodName.deleteCharAt(1);
		methodName.insert(0, "set");
		return class1.getMethod(methodName.toString(), field.getType());
	}

	private Object typeConverter(String value, Class class1) {
		if (class1 == boolean.class) {
			if (value.equals("Y"))
				return true;
			else if (value.equals("N"))
				return false;
		} else if (class1 == int.class)
			return Integer.parseInt(value);
		else if (class1 == double.class)
			return Double.parseDouble(value);
		else if (class1 == long.class)
			return Long.parseLong(value);
		else if (class1 == java.util.Date.class)
			return UIDateUtil.convertStringToDate(value, "dd/MM/yyyy HH:mm:s");
		return value;
	}
}
