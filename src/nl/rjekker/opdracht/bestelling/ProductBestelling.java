package nl.rjekker.opdracht.bestelling;

import nl.rjekker.opdracht.product.Product;

/* Dit is een immutable class, dat houdt de dingen simpel */
public class ProductBestelling {
	private Product product;
	private int hoeveelheid;
	
	public int getHoeveelheid() {
		return hoeveelheid;
	}

	// we geven niet het product zelf terug want we willen niet dat anderen daar aan kunnen zitten
	// we geven dus alleen toegang tot properties van het product
	public String getProductNaam(){
		return this.product.getNaam();
	}
	
	public int getPrijs(boolean inclusief){
		return this.product.getPrijs(hoeveelheid, inclusief);
	}
	
	public int getBTWPercentage(){
		return this.product.getBTWPercentage();
	}

	// protected getter voor product: winkelwagen mag hier wel bij
	protected Product getProduct(){
		return this.product;
	}
	
	// let op: protected constructor!
	// alternatieve oplossing is deze class als private inner class van Winkelwagen
	protected ProductBestelling(Product p, int hoeveelheid) {
		this.product = p;
		this.hoeveelheid = hoeveelheid;
	}
	
	@Override
	public String toString() {
		return this.product.toString() + ": " + this.hoeveelheid;
	}

}
