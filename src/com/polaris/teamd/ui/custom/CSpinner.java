package com.polaris.teamd.ui.custom;

import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * 
 * @author Manochitra
 * @version Java 1.6
 */
public class CSpinner extends JSpinner implements CSingleValueInput {

	private SpinnerModel spinnerModel;

	/**
	 * <b>This is no argument constructor for CSpinner class</b>
	 */

	public CSpinner() {
		super();
	}

	/**
	 * <b>This constructor is parameterized constructor</b>
	 * 
	 * @param SpinnerModel
	 *            -initializes the SpinnerModel member variable
	 */

	public CSpinner(SpinnerModel model) {
		super(model);
	}

	/**
	 * <b>this function returns the integer value</b>
	 * 
	 * @return <b>the integer value</b>
	 */
	@Override
	public int cGetIntValue() {
		Integer value = (Integer) super.getValue();
		return value;
	}

	/**
	 * <b>this function returns the float value</b>
	 * 
	 * @return <b>the float value</b>
	 */

	@Override
	public float cGetFloatValue() {
		Float value = (Float) super.getValue();
		return value;
	}

	/**
	 * <b>this function returns the double value</b>
	 * 
	 * @return <b>the double value</b>
	 */

	@Override
	public double cGetDoubleValue() {
		Double value = (Double) super.getValue();
		return value;

	}

	/**
	 * <b>this function returns the character value</b>
	 * 
	 * @return <b>the character value</b>
	 */

	@Override
	public char cGetCharValue() {
		char value = (Character) super.getValue();
		return value;
	}

	/**
	 * <b>this function returns the character value</b>
	 * 
	 * @return <b>the character value</b>
	 */
	@Override
	public byte cGetByteValue() {
		Byte value = (Byte) super.getValue();
		return value;
	}

	/**
	 * <b>this function returns the long value</b>
	 * 
	 * @return <b>the long value</b>
	 */
	@Override
	public long cGetLongValue() {
		Long value = (Long) super.getValue();
		return value;
	}

	/**
	 * <b>this function returns the short value</b>
	 * 
	 * @return <b>the short value</b>
	 */
	@Override
	public short cGetShortValue() {
		short value = (Short) super.getValue();
		return value;
	}

	/**
	 * <b>this function returns the spinnerModel</b>
	 * 
	 * @return <b>the spinnerModel value</b> * @param value -initializes the
	 *         integer member variable
	 */

	public SpinnerModel cSetIntValue(int value) {
		spinnerModel = new SpinnerNumberModel();
		spinnerModel.setValue(value);
		return spinnerModel;

	}

	/**
	 * <b>this function returns the spinnerModel</b>
	 * 
	 * @return <b>the spinnerModel value</b> * @param value -initializes the
	 *         float member variable
	 */

	public SpinnerModel cSetFloatValue(float value) {
		spinnerModel = new SpinnerNumberModel();
		spinnerModel.setValue(value);
		return spinnerModel;
	}

	/**
	 * <b>this function returns the spinnerModel</b>
	 * 
	 * @return <b>the spinnerModel value</b> * @param value -initializes the
	 *         byte member variable
	 */
	public SpinnerModel cSetByteValue(Byte value) {
		spinnerModel = new SpinnerNumberModel();
		spinnerModel.setValue(value);
		return spinnerModel;

	}

	/**
	 * <b>this function returns the spinnerModel</b>
	 * 
	 * @return <b>the spinnerModel value</b> * @param value -initializes the
	 *         double member variable
	 */

	public SpinnerModel cSetDoubleValue(double value) {
		spinnerModel = new SpinnerNumberModel();
		spinnerModel.setValue(value);
		return spinnerModel;

	}

	/**
	 * <b>this function returns the spinnerModel</b>
	 * 
	 * @return <b>the spinnerModel value</b> * @param value -initializes the
	 *         character member variable
	 */

	public SpinnerModel cSetCharValue(char value) {
		int intValue = value;
		spinnerModel = new SpinnerNumberModel();
		spinnerModel.setValue(intValue);
		return spinnerModel;

	}

	/**
	 * <b>this function returns the spinnerModel</b>
	 * 
	 * @return <b>the spinnerModel value</b> * @param value -initializes the
	 *         long member variable
	 */

	public SpinnerModel cSetLongValue(long value) {
		spinnerModel = new SpinnerNumberModel();
		spinnerModel.setValue(value);
		return spinnerModel;

	}

	/**
	 * <b>this function returns the spinnerModel</b>
	 * 
	 * @return <b>the spinnerModel value</b> * @param value -initializes the
	 *         short member variable
	 */

	public SpinnerModel cSetShortValue(short value) {
		spinnerModel = new SpinnerNumberModel();
		spinnerModel.setValue(value);
		return spinnerModel;

	}

	/**
	 * <b>this function returns the spinnerModel</b>
	 * 
	 * @return <b>the spinnerModel value</b> * @param value -initializes the
	 *         Date member variable
	 */

	public SpinnerModel cSetDateValue(Date value) {
		spinnerModel = new SpinnerDateModel();
		spinnerModel.setValue(value);
		return spinnerModel;

	}

	/**
	 * <b>this function returns the date</b>
	 * 
	 * @return <b>the date value</b>
	 */

	@Override
	public Date cGetDateValue() {
		Date date = (Date) super.getValue();
		return date;
	}

	/**
	 * <b>this function returns the String value</b>
	 * 
	 * @return <b>the string value</b>
	 */

	@Override
	public String cGetStringValue() {
		String value = (String) super.getValue();
		return value;
	}

	/**
	 * <b>this function returns the String value</b>
	 * 
	 * @return <b>the string value</b> * * @param value -initializes the string
	 *         member variable
	 */

	public SpinnerModel cSetStringValue(String value) {
		int intValue = Integer.parseInt(value);
		spinnerModel = new SpinnerNumberModel();
		spinnerModel.setValue(value);
		return spinnerModel;

	}
	
	
}
