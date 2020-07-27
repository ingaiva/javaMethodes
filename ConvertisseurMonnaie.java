package javaMethodes;

import java.util.Scanner;

public class ConvertisseurMonnaie {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		float[] euro = { (float) 1.12, (float) 0.00012 };
		float[] dollar = { (float) 0.89, (float) 0.00011 };
		float[] btc = { (float) 8249.07, (float) 9264.17 };

		String deviseInitiale = "", deviseCible = "";
		float montantToConvert = 0;
		System.out.println("Donnez moi un montant à convertir :");
		montantToConvert = sc.nextFloat();
		
		do {
			System.out.println("Quelle devise de ce montant  (€, $, BTC) ?");
			deviseInitiale = sc.next();
			deviseInitiale = deviseInitiale.toUpperCase();
		} while (!checkUser(deviseInitiale));
				
		do {
			System.out.println("Vers quelle devise voulez vous convertir ce montant  (€, $, BTC) ?");
			deviseCible = sc.next();
			deviseCible = deviseCible.toUpperCase();
		} while (!checkUser(deviseCible));	
		
		
		if (deviseInitiale.equals(deviseCible))
			System.out.println("C'est le même monant");
		else {
			System.out.print(montantToConvert + deviseInitiale + " = ");
			
			switch (deviseInitiale) {
			case "€":
				if (deviseCible.equalsIgnoreCase("$"))
					System.out.print(montantToConvert * euro[0] + deviseCible);
				else if (deviseCible.equalsIgnoreCase("BTC"))
					System.out.print(montantToConvert * euro[1] + deviseCible);
				break;
			case "$":
				if (deviseCible.equalsIgnoreCase("€"))
					System.out.print(montantToConvert * dollar[0] + deviseCible);
				else if (deviseCible.equalsIgnoreCase("BTC"))
					System.out.print(montantToConvert * dollar[1] + deviseCible);
				break;
			case "BTC":
				if (deviseCible.equalsIgnoreCase("€"))
					System.out.print(montantToConvert * btc[0] + deviseCible);
				else if (deviseCible.equalsIgnoreCase("$"))
					System.out.print(montantToConvert * btc[1] + deviseCible);
				break;
			default:
				System.out.println("Inconnue");
				return;
			}
		}
	}

	public static boolean checkUser(String rep) {
		if (!(rep.equalsIgnoreCase("€") || rep.equalsIgnoreCase("$") || rep.equalsIgnoreCase("BTC"))) {
			System.out.println("Devise inconnue");
			return false;
		}
		return true;
	}
}
