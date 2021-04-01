package ro.ase.acs.factorymethod;

public class MicrosoftOfficeFactory implements DocumentFactory{

	@Override
	public Document getDocument(DocumentType type, String name) {
		if(type==DocumentType.TEXT_EDITOR) {
			return new WordDocument(name);
		}else if(type==DocumentType.SPREADSHEET) {
			return new ExcelDocument(name);
		}
		return null;
	}

}
