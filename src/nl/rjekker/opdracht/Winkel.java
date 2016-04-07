package nl.rjekker.opdracht;

import java.util.Scanner;
import java.util.function.Predicate;

import nl.rjekker.opdracht.bestelling.Winkelwagen;
import nl.rjekker.opdracht.product.Beperkt;
import nl.rjekker.opdracht.product.DefaultProduct;
import nl.rjekker.opdracht.product.KwantumKorting;
import nl.rjekker.opdracht.product.Product;
import nl.rjekker.opdracht.product.Voedsel;

public class Winkel {

	public static void printVoorraad(Product[] voorraad){
		System.out.println("Product                Prijs         Voorraad");
		System.out.println("==============================================");
		int idx = 1;
		for(Product p: voorraad){
			System.out.println(
					String.format("%d %-23s%3s per %3s %9s", 
							idx++,
							p.getNaam(), 
							p.getPrijsPerEenheid(),
							Product.getEenheidNaam(p.getEenheid()),
							p.getVoorraad()));
		}
		System.out.println("==============================================");
	}
	
	public static int vraagGetal(String vraag, Scanner s, Predicate<Integer> test){
		while(true){
			System.out.print(vraag);
			String answer = s.next();
			int i;
			try{
				i = Integer.valueOf(answer);
			} catch(NumberFormatException e) {
				continue;
			}
			
			if(test.test(i)){
				return i;
			}
		}
	}
	
	public static Product vraagProduct(Scanner s, Product[] voorraad){
		return voorraad[vraagGetal("Selecteer product: ", s, 
				i -> (i <= voorraad.length && i > 0))-1];
	}

	public static int vraagHoeveelheid(Scanner s){
		return vraagGetal("Geef hoeveelheid: ", s, i -> i > 0);
	}
	
	public static boolean doorgaan(Scanner s){
		while(true){
			System.out.print("doorgaan (y/n)? ");
			String answer = s.next().trim().toLowerCase();
			System.out.println();
			if(answer.equals("y")){
				return true;
			}
			if(answer.equals("n")){
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		Product[] voorraad = {
				new DefaultProduct("Boek: OCA Exam Guide", 50, 100),
				new KwantumKorting("OCA mock exam", 10, 10000),
				new Beperkt("OCA Examen", 100, 10, Product.STUKS, 3),
				new Voedsel("Koffie", 1, 100000, Product.LITER)
		};
		Winkelwagen w = new Winkelwagen();
		
		Scanner s = new Scanner(System.in);
		while(true){
			printVoorraad(voorraad);
			
			Product p = vraagProduct(s, voorraad);
			int hoeveelheid = vraagHoeveelheid(s);
			
			try {
				w.bestel(p, hoeveelheid);
			} catch(Beperkt.HoeveelheidBeperktException e){
				System.out.println("Helaas, van dit product mag u niet zoveel bestellen");
			} catch(Product.NegatieveVoorraadException e){
				System.out.println("Helaas, zoveel is er niet op voorraad");
			}
			
			if(!w.isLeeg()){
				System.out.println("\n\nUw huidige bestelling:\n");
				System.out.println(w);
			}
			
			if(!doorgaan(s)){
				break;
			}
			
			System.out.println("\n\n...................................................\n\n");
		}
		System.out.println("Dank u wel en tot ziens!");
	}

}
