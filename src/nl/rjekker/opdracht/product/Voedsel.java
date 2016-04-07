package nl.rjekker.opdracht.product;

public class Voedsel extends DefaultProduct {
	
	@Override
	public int getBTWPercentage() {
		return 6;
	}

	public Voedsel(String naam, int prijs, int voorraad, int eenheid) {
		super(naam, prijs, voorraad, eenheid);
	}

}
