package nl.rjekker.opdracht.bestelling;

import java.util.ArrayList;

import nl.rjekker.opdracht.btw.BTWCalculator;
import nl.rjekker.opdracht.product.Product;

public class Winkelwagen {
	private ArrayList<ProductBestelling> data = new ArrayList<ProductBestelling>();
	
	public boolean isLeeg(){
		return data.isEmpty();
	}
	
	public int getTotaalPrijs(){
		int sum = 0;
		for(ProductBestelling pb: this.data){
			sum += pb.getPrijs(false);
		}
		return sum;
	}
	
	public int getTotaalBTW(){
		int sum = 0;
		for(ProductBestelling pb: this.data){
			sum += BTWCalculator.berekenBTW(pb.getPrijs(false), pb.getBTWPercentage());
		}
		return sum;
	}
	
	public void bestel(Product product, int hoeveelheid){
		product.haalUitVoorraad(hoeveelheid);
		this.data.add(new ProductBestelling(product, hoeveelheid));
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Product                Aantal            Prijs\n")
			.append("==============================================\n");
			for(ProductBestelling pb: data){
				s.append(
						String.format("%-25s%4d %16d\n", 
								pb.getProductNaam(), 
								pb.getHoeveelheid(),
								pb.getPrijs(false)));
			}
			s.append("==============================================\n");
			int totaalprijs = this.getTotaalPrijs();
			int totaalBTW = this.getTotaalBTW();
			s.append(String.format("%-35s %10d\n", "Totaal excl.", totaalprijs));
			s.append(String.format("%-35s %10d\n", "BTW", totaalBTW));
			s.append(String.format("%-35s %10d\n", "Totaal incl: ", totaalprijs + totaalBTW));
			return s.toString();
		}	
}
