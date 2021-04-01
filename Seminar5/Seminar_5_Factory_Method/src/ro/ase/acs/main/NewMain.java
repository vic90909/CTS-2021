package ro.ase.acs.main;

import ro.ase.acs.factorymethod.Document;
import ro.ase.acs.factorymethod.DocumentFactory;
import ro.ase.acs.factorymethod.DocumentType;
import ro.ase.acs.factorymethod.OpenOfficeFactory;

public class NewMain {

	public static void main(String[] args) {
		DocumentFactory  documentFactory=new OpenOfficeFactory();
		try {
			Document document = documentFactory.getDocument(DocumentType.SPREADSHEET, "studenti2");
			document.open();
			Document document2= documentFactory.getDocument(DocumentType.TEXT_EDITOR, "proiect2");
			document2.open();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
