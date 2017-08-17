package com.polaris.teamd.ui.custom;

import java.util.Date;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class CText extends JTextField implements CSingleValueInput {

	public CText() {
		super();

	}

	public CText(Document doc, String text, int columns) {
		super(doc, text, columns);

	}

	public CText(int columns) {
		super(columns);

	}

	public CText(String text, int columns) {
		super(text, columns);

	}

	public CText(String text) {
		super(text);

	}

	@Override
	public int cGetIntValue() {

		return Integer.parseInt(super.getText());
	}

	@Override
	public float cGetFloatValue() {

		return Float.parseFloat(super.getText());
	}

	@Override
	public double cGetDoubleValue() {

		return Double.parseDouble(super.getText());
	}

	@Override
	public char cGetCharValue() {
		if (super.getText().length() == 1)
			return super.getText().charAt(0);
		return '0';

	}

	@Override
	public byte cGetByteValue() {
		return Byte.parseByte(super.getText());
	}

	@Override
	public long cGetLongValue() {
		return Long.parseLong(super.getText());
	}

	@Override
	public short cGetShortValue() {
		return Short.parseShort(super.getText());
	}

	@Override
	public Date cGetDateValue() {

		return null;
	}

	@Override
	public String cGetStringValue() {

		return null;
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
}
