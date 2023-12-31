package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}
	
	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	@Override
	public boolean equals(Object carte) {
		if(carte instanceof Borne borne) {
			return this.km == borne.km;
		}
		return false;
	}
}