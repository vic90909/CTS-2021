package ro.ase.acs.main;

import ro.ase.acs.simplefactory.Document;
import ro.ase.acs.simplefactory.DocumentFactory;
import ro.ase.acs.simplefactory.DocumentType;

public class Main {

	public static void main(String[] args) {
		DocumentFactory  documentFactory=new DocumentFactory();
		try {
			Document document = documentFactory.getDocument(DocumentType.EXCEL, "studenti");
			document.open();
			Document document2= documentFactory.getDocument(DocumentType.OPENOFFICEWORD, "proiect");
			document2.open();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
