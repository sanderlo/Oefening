package nl.rjekker.opdracht.product;

public class Beperkt extends DefaultProduct {
	private int maxBestelling;
	
	public class HoeveelheidBeperktException extends RuntimeException {
		public HoeveelheidBeperktException(String msg) {
			super(msg);
		}
	}
	
	@Override
	public void haalUitVoorraad(int aantal) {
		if(aantal > this.maxBestelling){
			throw new HoeveelheidBeperktException("zoveel mag je niet bestellen; maximaal " + this.maxBestelling );
		}
		super.haalUitVoorraad(aantal);
	};
	
	public Beperkt(String naam, int prijs, int voorraad, int maxbestelling) {
		super(naam, prijs, voorraad);
		this.maxBestelling = maxbestelling;
	}
	public Beperkt(String naam, int prijs, int voorraad, int eenheid, int maxbestelling) {
		super(naam, prijs, voorraad);
		this.maxBestelling = maxbestelling;
	}

}
