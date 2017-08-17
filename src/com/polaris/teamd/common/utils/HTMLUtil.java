package com.polaris.teamd.common.utils;

public class HTMLUtil {

	public static String startHTML() {
		return "<html>";
	}

	public static String endHTML() {
		return "</html>";
	}

	public static String startTitle(String title) {
		return "<title>" + title;
	}

	public static String endTitle() {
		return "</title>";
	}

	public static String startHead() {
		return "<head>";
	}

	public static String endHead() {
		return "</head>";
	}

	public static String createHeading(int headLevel, String data) {
		return "<h" + headLevel + ">" + data;
	}

	public static String horizontalLine() {
		return "<hr>";
	}

	public static String newLine() {
		return "<br>";
	}

	public static String startTable(int sizePercentage, int borderWidth) {
		return "<table border=" + borderWidth + " size=" + sizePercentage + ">";
	}

	public static String endTable() {
		return "</table>";
	}

	public static String startRow(String backGroundcolor, String foregroundColor) {
		return "<tr bgcolor=" + backGroundcolor + " color=" + foregroundColor
				+ ">";
	}

	public static String endRow() {
		return "</tr>";
	}

	public static String createCell(String data) {
		return "<td>" + data;
	}

	public static String endCell() {
		return "</td>";
	}

	public static String createMergedCell(int mergeColumns) {
		return "<td colspan=" + mergeColumns + ">";
	}

	public static String setFont(String fontName, int fontSize, String fontColor,
			String innerHTML) {
		return "<font style=" + fontName + " size=" + fontSize + " color="
				+ fontColor + ">" + innerHTML;
	}

	public static String startList() {
		return "<li>";
	}

	public static String endList() {
		return "</li>";
	}

	public static String startOrderedList() {
		return "<ol>";
	}

	public static String endOrderedList() {
		return "</ol>";
	}

	public static String startUnorderedList() {
		return "<ul>";
	}

	public static String endUnorderedList() {
		return "</ul>";
	}

	public static String startBODY() {
		return "<body>";
	}
	
	public static String endBODY() {
		return "</body>";
	}
}
