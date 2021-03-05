package ro.ase.acs.writers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWriter implements Writeable {

	@Override
	public void write(String message) {
		OutputStreamWriter outputStreamWriter = null;
		try {
			FileOutputStream fileOutoutStream = new FileOutputStream("output.txt");
			outputStreamWriter = new OutputStreamWriter(fileOutoutStream);
			outputStreamWriter.write(message);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if(outputStreamWriter !=null) {
				try {
					outputStreamWriter.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
