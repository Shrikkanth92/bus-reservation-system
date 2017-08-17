package com.polaris.teamd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.common.PropertyFileProcessing;

import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.common.utils.IOUtil;
import com.polaris.teamd.db.exception.CDBConnectionException;

/**
 * @author shrikkanth.ramesh
 * @version Java 1.6
 */
public class DBConnectionManager {
	private static Connection connection;
	private static PropertyFileProcessing processor;
	/**
	 * <b> The static block sets the property file and calls the private
	 * functions loadDriver() and initialiseConnection()</b>
	 * 
	 * @exception Customised exception generated in setPropertyFile() function of
	 *                PropertyFileProcessor
	 * @see PropertyFileProcessor
	 */
	static {
		processor = new PropertyFileProcessing();
		try {
			processor.setPropertyFile(IOUtil
					.getFile("resources/db/db.properties"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		loadDriver();
		initialiseConnection();
	}

	/**
	 * <b>This function loads the driver</b>
	 * 
	 * @exception ClassNotFoundException
	 */

	private static void loadDriver() {
		try {
			Class.forName(processor.getStringProperty("db.driverClass"));
			System.out.println("Driver Loaded Successfully");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * <b>This function initializes the connection</b> It uses getURL()
	 * 
	 * @exception SQLException
	 */

	private static void initialiseConnection() {
		try {
			connection = DriverManager.getConnection(getURL(),
					processor.getStringProperty("db.username"),
					processor.getStringProperty("db.password"));
			System.out.println("Connection Initialised");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * <b>This function concatenates the values from the property and sends the
	 * URl formed.</b>
	 * 
	 * @return URL as a String
	 */
	private static String getURL() {
		StringBuffer url = new StringBuffer();
		url.append("jdbc:oracle:thin:@");
		url.append(processor.getStringProperty("db.hostName"));
		url.append(":");
		url.append(processor.getStringProperty("db.portNumber"));
		url.append(":");
		url.append(processor.getStringProperty("db.dbName"));
		return url.toString();
	}

	/**
	 * <b>This function returns the connection which is initiated</b>
	 * 
	 * @return Connection initiated
	 */
	public static Connection getConnection() {
		System.out.println("Connected");
		return connection;
	}

	/**
	 * <b>This function is used to close the connection formed</b> *
	 */
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			CException cException = new CDBConnectionException(CExceptionTypes.SEVERE,
					new Date(), DBConnectionManager.class, e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
	}
}
