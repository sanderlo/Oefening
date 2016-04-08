package nl.rjekker.opdracht.product;

import nl.rjekker.opdracht.btw.BTWCalculator;

public abstract class Products {
	public static final int STUKS = 1;
	public static final int KILO = 2;
	public static final int LITER = 3;
	public static final int PAK = 4;

	public static class NegatieveVoorraadException extends RuntimeException {}
	public static String getEenheidNaam(int eenheid){
		switch(eenheid){
		case 1:
			return "st.";
		case 2:
			return "kg";
		case 3:
			return "l.";
		case 4:
			return "pak";
		default:
			throw new IllegalStateException("Ongedefinieerde waarde voor eenheid");
		}
	}
	
	/* Abstract, public: getters */
	abstract public String getNaam();
	abstract public int getPrijsPerEenheid();
	abstract public int getBTWPercentage();
	abstract public int getEenheid();
	abstract public int getVoorraad();
	
	/* Abstract, protected: setters */
	abstract protected void setNaam(String naam);
	abstract protected void setPrijsPerEenheid(int prijs);
	abstract protected void setEenheid(int eenheid);
	
	/* setVoorraad checkt non-negatieve waarde */
	protected void setVoorraad(int voorraad){
		if(voorraad < 0){
			throw new NegatieveVoorraadException();
		}
		// hoe nu verder? geen instance var op deze class!
		_setVoorraad(voorraad);
	}
	// workaround
	abstract protected void _setVoorraad(int voorraad);
	
	public void haalUitVoorraad(int aantal){
		this.setVoorraad(this.getVoorraad() - aantal);
	}

	/* getPrijs overloaded methode 
	 * Let op: BTW-berekening hebben we elders ook nodig 
	 * en staat dus in andere class */	
	public int getPrijs(int hoeveelheid, boolean inclusief){
		int prijs_excl = hoeveelheid * this.getPrijsPerEenheid();
		return BTWCalculator.berekenPrijs(prijs_excl, this.getBTWPercentage(), inclusief);
	}
	public int getPrijs(int hoeveelheid){ return this.getPrijs(hoeveelheid, true); }
	public int getPrijs(){ return this.getPrijsPerEenheid(); }

	
	@Override
	public String toString() {
		return "<br><img " + this.getNaam() + "<br></p>";
	}
	
	public String ImageURL(){
		return "<img src=\"../Serv2/" + this.getNaam() + ".jpg\"><br>";
	}
	
	
	/* Constructors */
	public Products(String naam, int prijs, int voorraad, int eenheid){
		this.setNaam(naam);
		this.setEenheid(eenheid);
		this.setVoorraad(voorraad);
		this.setPrijsPerEenheid(prijs);
	}
	public Products(String naam, int prijs, int voorraad){
		this(naam, prijs, voorraad, STUKS);
	}
}
