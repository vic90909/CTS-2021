package ro.ase.cts.after.logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

public enum LoggerV2 {
	INSTANCE;

	public void log(String message) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("log.txt", true);
			Thread.sleep(3000);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			bufferedWriter.write(String.valueOf(new Date()));
			bufferedWriter.write(" ");
			bufferedWriter.write(message);
			bufferedWriter.write(System.lineSeparator());

			bufferedWriter.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
