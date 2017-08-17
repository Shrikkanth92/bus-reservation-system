package com.polaris.teamd.ui.custom;

import java.util.Date;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

public class CPassword extends JPasswordField implements CSingleValueInput {

	/**
	 * 
	 */
	public CPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param doc
	 * @param txt
	 * @param columns
	 */
	public CPassword(Document doc, String txt, int columns) {
		super(doc, txt, columns);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param columns
	 */
	public CPassword(int columns) {
		super(columns);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param columns
	 */
	public CPassword(String text, int columns) {
		super(text, columns);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 */
	public CPassword(String text) {
		super(text);

	}

	public void cSetIntValue(int value) {
		setText(String.valueOf(value));
	}

	public void cSetFloatValue(float value) {
		setText(String.valueOf(value));
	}

	public void cSetDoubleValue(double value) {
		setText(String.valueOf(value));
	}

	public void cSetColumnLength(int columnInput) {
		setColumns(columnInput);
	}

	@Override
	public int cGetIntValue() {
		String str = new String(super.getPassword());
		return Integer.parseInt(str);
	}

	@Override
	public float cGetFloatValue() {
		String str = new String(super.getPassword());
		return Float.parseFloat(str);
	}

	@Override
	public double cGetDoubleValue() {
		String str = new String(super.getPassword());
		return Double.parseDouble(str);
	}

	@Override
	public char cGetCharValue() {
		String str = new String(super.getPassword());
		if (str.length() == 1)
			return str.charAt(0);
		return '0';

	}

	@Override
	public byte cGetByteValue() {
		String str = new String(super.getPassword());
		return Byte.parseByte(str);
	}

	@Override
	public long cGetLongValue() {
		String str = new String(super.getPassword());
		return Long.parseLong(str);
	}

	@Override
	public short cGetShortValue() {
		String str = new String(super.getPassword());
		return Short.parseShort(str);

	}

	@Override
	public Date cGetDateValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cGetStringValue() {
		String str = new String(super.getPassword());
		return str;
	}

}
