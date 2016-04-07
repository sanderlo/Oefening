package nl.rjekker.opdracht.product;

import nl.rjekker.opdracht.btw.BTWCalculator;

public class KwantumKorting extends DefaultProduct {

	@Override
	public int getPrijs() {
		throw new UnsupportedOperationException();
	}
	@Override
	public int getPrijs(int hoeveelheid) {
		int p = super.getPrijs();
		if(hoeveelheid > 100){
			p *= .8;
		} else if(hoeveelheid > 200){
			p *= .6;
		} else if(hoeveelheid > 500){
			p *= .5;
		}
		return hoeveelheid * p;
	}
	public int getPrijs(int hoeveelheid, boolean inclusief) {
		return BTWCalculator.berekenPrijs(this.getPrijs(hoeveelheid), this.getBTWPercentage(), inclusief);
	};
	
	public KwantumKorting(String naam, int prijs, int voorraad) {
		super(naam, prijs, voorraad);
	}
	public KwantumKorting(String naam, int prijs, int voorraad, int eenheid) {
		super(naam, prijs, voorraad, eenheid);
	}
}
