package ro.ase.acs.simplefactory;

public class DocumentFactory {

	public Document getDocument(DocumentType type, String name) {

		switch (type) {
		case WORD:
			return new WordDocument(name);
		case EXCEL:
			return new ExcelDocument(name);

		case OPENOFFICEWORD:
			return new OpenOfficeWord(name);

		case OPENOFFICESPREADSHEET:
			return new OpenOfficeSpreadsheet(name);

		default:
			return null;
		}

	}
}
