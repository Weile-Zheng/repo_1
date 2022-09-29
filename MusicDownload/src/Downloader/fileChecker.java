package Downloader;

import java.util.regex.Pattern;

public class fileChecker {

	public static boolean checkinputhttp(String link) {
		boolean checkhttp = Pattern.matches("(https?:\\/\\/)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#()?&//=]*)", link);
		return checkhttp;
	}

}
