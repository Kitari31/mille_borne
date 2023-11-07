package cartes;

public abstract class Probleme extends Carte {
	public enum Type {FEU,ESSENCE,CREVAISON,ACCIDENT}
	private Type type;
	
	protected Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals(Object carte) {
		if(super.equals(carte)) {
			return this.toString()==carte.toString();
		}
		return false;
	}
}
