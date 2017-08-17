package com.polaris.teamd.db;

import java.util.HashMap;

public class SQLDataTypeMapper {

	static HashMap<Class, String> TypeMap;
	static{
		TypeMap.put(int.class, "NUMBER");
		TypeMap.put(float.class, "NUMBER");
		TypeMap.put(short.class, "NUMBER");
		TypeMap.put(double.class, "NUMBER");
		TypeMap.put(long.class, "NUMBER");
		TypeMap.put(String.class, "VARCHAR2");
		TypeMap.put(char.class, "CHAR");
		TypeMap.put(java.util.Date.class, "TIMESTAMP");
		TypeMap.put(boolean.class, "CHAR");
		
	}
}
