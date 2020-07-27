package javaMethodes;

import java.util.Scanner;

public class jeuxVolley {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String usrInput;
		System.out.println("Entrez la chaine composée de A et B :");
		usrInput = sc.next();
		usrInput = usrInput.toUpperCase();

		int scoreA = 0, scoreB = 0;
		int i = 0;
		do {
			if (usrInput.charAt(i) == 'A')
				scoreA++;
			else if (usrInput.charAt(i) == 'B')
				scoreB++;
			i++;
			if (scoreA == 3 || scoreB == 3)
				break;
		} while (scoreA < 3 && scoreB < 3 && i < usrInput.length());

		if (scoreA > scoreB && scoreA == 3)
			System.out.println("Joueur A gagne !");
		else if (scoreB > scoreA && scoreB == 3)
			System.out.println("Joueur B gagne !");
		else
			System.out.println("Pas assez d'information");
	}

	public static void volleyAvecFor() {
		Scanner sc = new Scanner(System.in);
		String usrInput;
		System.out.println("Entrez la chaine composée de A et B :");
		usrInput = sc.next();
		usrInput = usrInput.toUpperCase();

		int scoreA = 0, scoreB = 0;
		boolean gagnerVrament = false;
		for (int i = 0; i < usrInput.length(); i++) {
			if (usrInput.charAt(i) == 'A')
				scoreA++;
			else if (usrInput.charAt(i) == 'B')
				scoreB++;		
			if (scoreA == 3 || scoreB == 3) {
				gagnerVrament = true;
				break;
			}
		}
		
		if (gagnerVrament) {
			if (scoreA > scoreB)
				System.out.println("Joueur A gagne !");
			else if (scoreB > scoreA)
				System.out.println("Joueur B gagne !");
		} else
			System.out.println("Pas encore de gagnant...");
	}
}
