package ro.ase.acs.writers;

public class ConsoleWriter implements Writeable {
	public void write(String message) {
		System.out.println(message);
	}
	
}
