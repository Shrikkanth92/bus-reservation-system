package com.polaris.teamd.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.polaris.teamd.common.utils.IOUtil;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.DBConnectionManager;
import com.polaris.teamd.common.PropertyFileProcessing;

public class SequenceNumberRetriever {

	public static int getNextID(Class class1) {
		CQuery impl = new CQueryImpl();
		PropertyFileProcessing ormProcessor = new PropertyFileProcessing();
		StringBuffer ormFileName = new StringBuffer("resources/orm/").append(
				class1.getSimpleName()).append("-orm.properties");
		try {
			ormProcessor
					.setPropertyFile(IOUtil.getFile(ormFileName.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuffer query = new StringBuffer("Select ").append(
				ormProcessor
						.getStringProperty("orm.beantable.sequenceGenerator"))
				.append(".nextval from dual");
		System.out.println(query);
		Connection connection = DBConnectionManager.getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query.toString());
			while (resultSet.next())
				return resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
