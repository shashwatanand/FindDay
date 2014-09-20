package org.shashwat;

public class Helper {
	public static String[] parseDateString(String pDateString, String pDelimiter) throws Exception {
		String[] lArrDate = new String[3];
		lArrDate = pDateString.split(pDelimiter);
		return lArrDate;
	}
}
