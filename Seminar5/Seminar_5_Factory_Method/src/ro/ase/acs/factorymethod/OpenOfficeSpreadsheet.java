package ro.ase.acs.factorymethod;

public class OpenOfficeSpreadsheet implements Document {
private String name;
	
	
	
	public OpenOfficeSpreadsheet(String name) {
		
		this.name = name;
	}



	@Override
	public void open() {
		
		System.out.println(String.format("The document %s.ss is opening...", name));
	}
}
