package ro.ase.acs.factorymethod;

public class OpenOfficeFactory implements DocumentFactory{

	@Override
	public Document getDocument(DocumentType type, String name) {
		if(type==DocumentType.TEXT_EDITOR) {
			return new OpenOfficeWord(name);
		}else if(type==DocumentType.SPREADSHEET) {
			return new OpenOfficeSpreadsheet(name);
		}
		return null;
	}

}
