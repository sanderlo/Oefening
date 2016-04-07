package nl.rjekker.opdracht.product;

/* Deze class gebruik ik als superclass voor andere product classes */
public class DefaultProduct extends Product {
	// BTW hoeft hier niet :)
	private String naam;
	private int prijsPerEenheid;
	private int eenheid;
	private int voorraad;
	
	@Override
	public String getNaam() {
		return this.naam;
	}

	@Override
	protected void setNaam(String naam) {
		this.naam = naam;
	}

	@Override
	public int getPrijsPerEenheid() {
		return this.prijsPerEenheid;
	}

	@Override
	public int getBTWPercentage() {
		return 21;
	}

	@Override
	public int getEenheid() {
		return this.eenheid;
	}

	@Override
	public int getVoorraad() {
		return this.voorraad;
	}

	@Override
	protected void setPrijsPerEenheid(int prijs) {
		this.prijsPerEenheid = prijs;
	}

	@Override
	protected void setEenheid(int eenheid) {
		this.eenheid = eenheid;
	}

	@Override
	protected void _setVoorraad(int voorraad) {
		this.voorraad = voorraad;
	}

	public DefaultProduct(String naam, int prijs, int voorraad) {
		super(naam, prijs, voorraad);
	}

	public DefaultProduct(String naam, int prijs, int voorraad, int eenheid) {
		super(naam, prijs, voorraad, eenheid);
	}
}
