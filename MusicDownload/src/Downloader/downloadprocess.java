package Downloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class downloadprocess {

	public static void Downloadlink(String link, String outputfile)
			throws IOException, IllegalArgumentException, MalformedURLException {

		if (fileChecker.checkinputhttp(link) == false) {
			throw new MalformedURLException();
		}
		URL conn = new URL(link);

		String userHomeDir = System.getProperty("user.home");
		InputStream input = conn.openStream();
		OutputStream output = new FileOutputStream(new File(userHomeDir + "/downloads/" + outputfile + ".mp3"));
		while (input.read() != -1) {
			input.transferTo(output);
		}
		System.out.println("Downloaded!");
		input.close();
		output.close();
	}
}
