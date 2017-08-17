package com.polaris.teamd.ui.custom;

import java.text.ParseException;
import java.util.Date;

/**
 * 
 * @author
 * 
 */
public interface CSingleValueInput {

	int cGetIntValue();

	float cGetFloatValue();

	double cGetDoubleValue();

	char cGetCharValue();

	byte cGetByteValue();

	short cGetShortValue();

	long cGetLongValue();

	String cGetStringValue();

	Date cGetDateValue() throws ParseException;
}
