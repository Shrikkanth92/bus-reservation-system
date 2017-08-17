package com.polaris.teamd.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

public class PropertyFileProcessing {

	private File propertyFile;
	private Properties properties;

	public PropertyFileProcessing() {
		super();
	}

	public PropertyFileProcessing(File propertyFile) {
		super();
		setPropertyFile(propertyFile);
	}

	public void setPropertyFile(File propertyFile) {
		this.propertyFile = propertyFile;
		cLoadProperty();
	}

	private void cLoadProperty() {
		try {
			properties = new Properties();
			InputStream inputStream = new FileInputStream(this.propertyFile);
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getStringProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}

	public int getIntProperty(String propertyKey) {
		String property = getStringProperty(propertyKey);
		return Integer.parseInt(property);
	}

	public double getDoubleProperty(String propertyKey) {
		String property = getStringProperty(propertyKey);
		return Double.parseDouble(property);
	}

	public long getLongProperty(String propertyKey) {
		String property = getStringProperty(propertyKey);
		return Long.parseLong(property);
	}

	public boolean getBooleanProperty(String propertyKey) {
		String property = getStringProperty(propertyKey);
		return Boolean.parseBoolean(property);
	}

	public int getIndexedPropertyCount(String propertySuffix) {
		int count = 0;
		Set<String> propertyNames = properties.stringPropertyNames();
		for (String suffix : propertyNames) {
			if (suffix.endsWith(propertySuffix))
				count++;
		}
		return count;
	}

	public String[] getIndexedPropertyValues(String propertySuffix) {

		String[] propertyNames, propertyValues;

		propertyNames = new String[getIndexedPropertyCount(propertySuffix)];
		propertyValues = new String[getIndexedPropertyCount(propertySuffix)];

		Set<String> propertyNameSet = properties.stringPropertyNames();

		int i = 0;
		for (String suffix : propertyNameSet) {
			if (suffix.endsWith(propertySuffix)) {
				propertyNames[i++] = suffix;
			}

		}

		Arrays.sort(propertyNames);

		for (int j = 0; j < i; j++) {
			propertyValues[j] = properties.getProperty(propertyNames[j]);
		}

		return propertyValues;
	}

	public String getIndexedPropertyValuesAsList(String propertySuffix,
			char seperator) {
		String[] propertyValues = getIndexedPropertyValues(propertySuffix);
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < getIndexedPropertyCount(propertySuffix); i++) {
			if (i == 0)
				buffer.append(propertyValues[i]);
			else
				buffer.append(seperator + propertyValues[i]);
		}
		String propertyConcatValues = new String(buffer);

		return propertyConcatValues;
	}

	public String getIndexedPropertyValuesAsList(String propertySuffix) {
		return getIndexedPropertyValuesAsList(propertySuffix, ',');

	}

}
