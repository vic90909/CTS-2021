import ro.ase.cts.before.classes.CommandLine;
import ro.ase.cts.before.classes.GUI;

public class Main {
	public static void main(String[] args) {
		
		Runnable r= ()->{
			GUI gui = new GUI();
		};
		new Thread(r).start();
		CommandLine commandLine = new CommandLine();
	}
	
	
}
