package com.polaris.teamd.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class UIUtil {
	public static Font getFont(String fontName) {
		Font font = new Font(fontName, Font.BOLD, 12);
		return font;
	}

	public static Font getFont(String fontName, int size) {
		Font font = new Font(fontName, Font.BOLD, size);
		return font;
	}

	public static Font getFont(String fontName, String style, int size) {
		if (style.equalsIgnoreCase("BOLD"))
			return new Font(fontName, Font.BOLD, size);
		if (style.equalsIgnoreCase("ITALIC"))
			return new Font(fontName, Font.ITALIC, size);
		if (style.equalsIgnoreCase("PLAIN"))
			return new Font(fontName, Font.PLAIN, size);

		return null;
	}

	public static Border createSimpleBorder() {
		Border border = BorderFactory.createLineBorder(Color.RED, 1);
		return border;
	}

	public static Image getScaledImage(String filename, int width,
			int height) {
		Image image=null;
		try {
			image = ImageIO.read(new File(filename));
			image = image.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			return image;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;

	}
}
