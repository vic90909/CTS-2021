import ro.ase.cts.after.classes.CommandLine;
import ro.ase.cts.after.classes.GUI;
import ro.ase.cts.after.logger.LoggerV2;
import ro.ase.cts.after.logger.LoggerV3;

public class NewMain {
	public static void main(String[] args) {
		
		Runnable r= ()->{
			GUI gui = new GUI();
		};
		new Thread(r).start();
		CommandLine commandLine = new CommandLine();
		
		
		LoggerV2.INSTANCE.log("message from newMain");
		
		LoggerV3.instance.log("Annother message from newMain V3");
	}
	
	
}
