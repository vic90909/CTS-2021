package ro.ase.acs.factorymethod;


public interface DocumentFactory {
	public Document getDocument(DocumentType type, String name);
}
