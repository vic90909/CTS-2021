package ro.ase.acs.prototype;

public class Texture implements Cloneable {
	private String name;

	public Texture(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Texture copy=(Texture) super.clone();
		copy.name=name;
		return copy;
	}
	
}
