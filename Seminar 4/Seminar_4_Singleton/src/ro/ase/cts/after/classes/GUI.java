package ro.ase.cts.after.classes;

import ro.ase.cts.after.logger.Logger;

public class GUI {
	
	
	public GUI() {
		Logger logger= Logger.getInstance("log.txt");
		logger.log("GUI created");
	}
}
