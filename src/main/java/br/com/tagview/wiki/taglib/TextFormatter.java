package br.com.tagview.wiki.taglib;

public final class TextFormatter {
	public static String format(String string) {
		return string.replace("\n", "<br/>");
	}
}
