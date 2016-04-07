package nl.rjekker.opdracht.btw;

public class BTWCalculator {

	public static int berekenPrijs(int prijs, int percentage, boolean inclusief){
		if(inclusief){
			return (int) Math.round((prijs * (100.0 + percentage))/100);
		}
		return prijs;
	}
	
	public static int berekenBTW(int prijs, int percentage){
		return (int) Math.round((prijs * percentage)/100.0);
	}
}
