package cartes;

public abstract class Carte {
	public static final int FEU_ROUGE = 1;
    public static final int PANNE_ESSENCE = 2;
    public static final int CREVAISON = 3;
    public static final int ACCIDENT = 4;
    public static final int VEHICULE_PRIORITAIRE = 5;
    public static final int AS_DU_VOLANT = 6;
    public static final int ESSENCE = 7;
    public static final int FEU_VERT = 8;
	private int nombre;
	
	protected Carte(int nombre) {
		this.nombre = nombre;
	}
	
	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public boolean equals(Object carte) {
		return  this.getClass()==carte.getClass();
	}
}
