package com.polaris.teamd.ui.custom;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.polaris.teamd.ui.CUILayoutType;

public class CMultiText<E> extends JPanel {
	private ArrayList<CText> cTexts;
	private int numberOfTexts;
	private int orientation;
	private int columnLength;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints constraints;
	private int verticalWrap, horizontalWrap;
	private JPanel jPanel;
	// private boolean isInitialised;
	{
		cTexts = new ArrayList<CText>();
		numberOfTexts = 5;
		orientation = CUILayoutType.VERTICAL;
		columnLength = 10;
		verticalWrap = 50;
		horizontalWrap = 10;
		gridBagLayout = new GridBagLayout();
		constraints = new GridBagConstraints();
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.anchor = GridBagConstraints.WEST;
		jPanel = new JPanel();
		// isInitialised=false;

	}

	public CMultiText() {
		super();

	}

	public CMultiText(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public CMultiText(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public CMultiText(LayoutManager layout) {
		super(layout);
	}

	public CMultiText(int numberOfTexts) {
		super();
		setNumberOfTexts(numberOfTexts);
		initialise();

	}

	public CMultiText(int numberOfTexts, int orientation) {
		super();
		setNumberOfTexts(numberOfTexts);
		setOrientation(orientation);
		initialise();
	}

	public CMultiText(int numberOfTexts, int orientation, int columnLength) {
		super();
		setNumberOfTexts(numberOfTexts);
		setOrientation(orientation);
		setColumnLength(columnLength);
		initialise();
	}

	public CMultiText(int numberOfTexts, int orientation, int columnLength,
			int verticalWrap, int horizontalWrap) {
		super();
		setNumberOfTexts(numberOfTexts);
		setOrientation(orientation);
		setColumnLength(columnLength);
		setVerticalWrap(verticalWrap);
		setHorizontalWrap(horizontalWrap);
		initialise();
	}

	public void setNumberOfTexts(int numberOfTexts) {
		this.numberOfTexts = numberOfTexts;
	}

	public int getNumberOfTexts() {
		return numberOfTexts;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public void setColumnLength(int columnLength) {
		this.columnLength = columnLength;
	}

	public void setColumnLength(int columnLength, int index) {
		cTexts.get(index).setColumns(columnLength);
	}

	public void setColumnLength(int columnLength, int startIndex, int endIndex) {
		for (int i = startIndex; i < endIndex; i++)
			cTexts.get(i).setColumns(columnLength);
	}

	public void setVerticalWrap(int verticalWrap) {
		this.verticalWrap = verticalWrap - 1;
	}

	public void setHorizontalWrap(int horizontalWrap) {
		this.horizontalWrap = horizontalWrap - 1;
	}

	public void setAllWithIntValue(int value) {
		for (int i = 0; i < this.numberOfTexts; i++)
			cTexts.get(i).setText(value + "");
	}

	public void setIntValueAt(int value, int index) {
		if (index <= cTexts.size() - 1)
			cTexts.get(index).setText(value + "");
	}

	public void setAllWithLongValue(long value) {
		for (int i = 0; i < this.numberOfTexts; i++)
			cTexts.get(i).setText(value + "");
	}

	public void setLongValueAt(long value, int index) {
		if (index <= cTexts.size() - 1)
			cTexts.get(index).setText(value + "");
	}

	public void setAllWithFloatValue(float value) {
		for (int i = 0; i < this.numberOfTexts; i++)
			cTexts.get(i).setText(value + "");
	}

	public void setFloatValueAt(float value, int index) {
		if (index <= cTexts.size() - 1)
			cTexts.get(index).setText(value + "");
	}

	public void setAllWithDoubleValue(double value) {
		for (int i = 0; i < this.numberOfTexts; i++)
			cTexts.get(i).setText(value + "");
	}

	public void setDoubleValueAt(double value, int index) {
		if (index <= cTexts.size() - 1)
			cTexts.get(index).setText(value + "");
	}

	public void setAllWithStringValue(String value) {
		for (int i = 0; i < this.numberOfTexts; i++)
			cTexts.get(i).setText(value);
	}

	public void setStringValueAt(String value, int index) {
		if (index <= cTexts.size() - 1)
			cTexts.get(index).setText(value);
	}

	public void setWithStrings(String... values) {
		addTexts(values.length - this.numberOfTexts);
		for (int i = 0; i < values.length; i++)
			cTexts.get(i).setText(values[i]);
	}

	public void setWithConcatenatedString(String concatenatedString) {
		String[] array = concatenatedString.split(",");
		addTexts(array.length - this.numberOfTexts);
		setWithStrings(array);
	}

	public void setWithArrayList(ArrayList<String> strings) {
		addTexts(strings.size() - this.numberOfTexts);
		for (int i = 0; i < strings.size(); i++)
			cTexts.get(i).setText(strings.get(i));
	}

	public int getIntValueAt(int index) {
		return Integer.parseInt(cTexts.get(index).getText());
	}

	public double getDoubleValueAt(int index) {
		return Double.parseDouble(cTexts.get(index).getText());
	}

	public long getLongValueAt(int index) {
		return Long.parseLong(cTexts.get(index).getText());
	}

	public float getFloatValueAt(int index) {
		return Float.parseFloat(cTexts.get(index).getText());
	}

	public String getStringValueAt(int index) {
		return cTexts.get(index).getText();
	}

	public String getConcatenatedString() {
		StringBuffer valueList = new StringBuffer();
		for (CText text : cTexts) {
			if (!text.getText().isEmpty()) {
				valueList.append(text.getText());
				valueList.append(",");
			}
		}
		valueList.deleteCharAt(valueList.length() - 1);
		return valueList.toString();
	}

	public void initialise() {
		for (int i = 0; i < this.numberOfTexts; i++)
			cTexts.add(new CText(this.columnLength));
	}

	public void addTexts(int addAmount) {
		for (int i = 1; i <= addAmount; i++) {
			cTexts.add(new CText(this.columnLength));
			this.numberOfTexts++;
		}
	}

	public void removeTextAt(int index) {
		if (index <= cTexts.size() - 1) {
			cTexts.remove(index);
			this.numberOfTexts--;
		}
	}

	public void removeTexts(int startIndex, int endIndex) {
		if (startIndex < cTexts.size() - 1 && endIndex <= cTexts.size() - 1) {
			for (int i = startIndex; i <= endIndex; i++) {
				cTexts.remove(i);
				this.numberOfTexts--;
			}
		}
	}

	public void render() {
		// initialise();
		if (this.orientation == CUILayoutType.VERTICAL) {
			int count = 0;
			jPanel.setLayout(gridBagLayout);
			for (int i = 0; i <= horizontalWrap; i++) {
				for (int j = 0; j <= verticalWrap; j++) {
					constraints.gridy = j;
					constraints.gridx = i;
					gridBagLayout
							.setConstraints(cTexts.get(count), constraints);
					jPanel.add(cTexts.get(count++));
					if (count == this.numberOfTexts)
						break;
				}
				if (count == this.numberOfTexts)
					break;
			}
			this.add(jPanel);
		}
		if (this.orientation == CUILayoutType.HORIZONTAL) {
			jPanel.setLayout(new FlowLayout());
			for (int i = 0; i < cTexts.size(); i++)
				jPanel.add(cTexts.get(i));
			this.add(jPanel);
		}
	}

	public void addActionListener(ActionListener actionListener) {

	}

	public void cSetSize(int width, int height, int startIndex, int endIndex) {
		for (int i = startIndex; i < endIndex; i++) {
			Dimension dimension = new Dimension(width, height);
			cTexts.get(i).setPreferredSize(dimension);
			cTexts.get(i).setMaximumSize(dimension);
			cTexts.get(i).setMinimumSize(dimension);
			cTexts.get(i).setSize(width, height);
		}
	}

}
