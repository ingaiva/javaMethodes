package javaMethodes;

import java.util.HashMap;
import java.util.Scanner;

public class SondageCouleurs {

	public static void main(String[] args) {
		methodeHashMap();
	}
	static void methodeHashMap() {		
		int nbPersonnes = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien de participants à l'enquête?");
		nbPersonnes = sc.nextInt();

		System.out.println("Tapez votre couleur preferée et appuyez sur 'Entrée'");
		HashMap<String, Integer> sondage = new HashMap<String, Integer>();
		String line;
		for (int j = 0; j < nbPersonnes; j++) {
			line = sc.next();// entrée de l'utilisateur
			if (line.length() > 10)
				line = line.substring(0, 10).toLowerCase();
			else
				line = line.toLowerCase();

			if (sondage.containsKey(line))
				sondage.put(line, sondage.get(line) + 1);
			else
				sondage.put(line, 1);
		} // fin boucle 'for'
		// ------------------------
		// Analyse des resultats:
		int maxCouleur1 = 0, maxCouleur2 = 0;
		String couleur1 = "", couleur2 = "";
		for (String key : sondage.keySet()) {
			if (sondage.get(key) > maxCouleur1) {
				maxCouleur1 = sondage.get(key);
				couleur1 = key;
			}
		}
		for (String key : sondage.keySet()) {
			if (key != couleur1 && sondage.get(key) > maxCouleur2) {
				maxCouleur2 = sondage.get(key);
				couleur2 = key;
			}
		}

		System.out.println("Resultats du sondage :");
		if (maxCouleur1 > 0 && maxCouleur2 > 0) {
			System.out.println(couleur1 + "  " + couleur2);
		} else
			System.out.println("Pas assez de données");

		System.out.println(" Sondage : ");
//		System.out.println(sondage);
		for (String key : sondage.keySet())
			System.out.println(key + " a obtenu " + sondage.get(key) + " vote(s)");
	}// fin void

	static void methode2() {
		String line;
		int nbPersonnes = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien de participants à l'enquête?");
		nbPersonnes = sc.nextInt();

		System.out.println("Tapez votre couleur preferée et appuyez sur 'Entrée'");

		String[] couleurs = new String[0];
		int[] sondage = new int[0];

		for (int j = 0; j < nbPersonnes; j++) {
			line = sc.next();// entrée de l'utilisateur
			if (line.length() > 10)
				line = line.substring(0, 10).toLowerCase();
			else
				line = line.toLowerCase();

			// data d'un utilisateur analysée
			boolean isExist = false;
			for (int i = 0; i < couleurs.length; i++) {
				if (couleurs[i].equalsIgnoreCase(line)) {
					sondage[i] = sondage[i] + 1;
					isExist = true;
					break;
				}
			}

			if (!isExist) {
				String[] newCouleurs = new String[couleurs.length + 1];
				int[] newSondage = new int[sondage.length + 1];

				for (int i = 0; i < couleurs.length; i++) {
					newCouleurs[i] = couleurs[i];
					newSondage[i] = sondage[i];
				}
				newCouleurs[couleurs.length] = line;
				newSondage[couleurs.length] = 1;
				couleurs = newCouleurs;
				sondage = newSondage;
			}
			// fin de data d'une personne

		} // fin boucle 'for'
			// ------------------------
			// Analyse des resultats:
		int maxCouleur1 = 0, maxCouleur2 = 0;
		int indiceCouleur1 = -1, indiceCouleur2 = -1;

		for (int i = 0; i < sondage.length; i++) {
			if (sondage[i] > maxCouleur1) {
				maxCouleur1 = sondage[i];
				indiceCouleur1 = i;
			}
		}
		for (int i = 0; i < sondage.length; i++) {
			if (sondage[i] > maxCouleur2 && i != indiceCouleur1) {
				maxCouleur2 = sondage[i];
				indiceCouleur2 = i;
			}
		}

		System.out.println("Resultats du sondage :");
		if (indiceCouleur1 > -1 && indiceCouleur2 > -1) {
			System.out.println(couleurs[indiceCouleur1] + "  " + couleurs[indiceCouleur2]);
		} else
			System.out.println("Pas assez de données");

		System.out.println(" Sondage : ");
		for (int i = 0; i < sondage.length; i++)
			System.out.println(couleurs[i] + " a obtenu " + sondage[i] + " votes");

	}// fin void

	// Methode 2 qui traite une liste des couleurs jusqu'a la fin,
	// il faut taper 2 fois 'entrée' pour terminer l'enquette et afficher les
	// resultats

	static void methode1() {
		String line;
		String nbPersonnes = "";
		Scanner sc = new Scanner(System.in);

		String[] couleurs = new String[0];
		int[] sondage = new int[0];

		while (sc.hasNextLine()) {
			line = sc.nextLine();

			if (line.isEmpty()) {
				break;
			}
			if (nbPersonnes.equals(""))
				nbPersonnes = line;
			else {
				if (line.length() > 10)
					line = line.substring(0, 10).toLowerCase();
				else
					line = line.toLowerCase();

				boolean isExist = false;
				for (int i = 0; i < couleurs.length; i++) {
					if (couleurs[i].equalsIgnoreCase(line)) {
						sondage[i] = sondage[i] + 1;
						isExist = true;
						break;
					}
				}

				if (!isExist) {
					String[] newCouleurs = new String[couleurs.length + 1];
					int[] newSondage = new int[sondage.length + 1];

					for (int i = 0; i < couleurs.length; i++) {
						newCouleurs[i] = couleurs[i];
						newSondage[i] = sondage[i];
					}
					newCouleurs[couleurs.length] = line;
					newSondage[couleurs.length] = 1;
					couleurs = newCouleurs;
					sondage = newSondage;
				}
			}
		}

//		System.out.println("Couleurs : " + couleurs.length);
		int maxCouleur1 = 0;
		int maxCouleur2 = 0;
		int indiceCouleur1 = -1;
		int indiceCouleur2 = -1;

		for (int i = 0; i < sondage.length; i++) {
			if (sondage[i] > maxCouleur1) {
				maxCouleur1 = sondage[i];
				indiceCouleur1 = i;
			}
		}
		for (int i = 0; i < sondage.length; i++) {
			if (sondage[i] > maxCouleur2 && i != indiceCouleur1) {
				maxCouleur2 = sondage[i];
				indiceCouleur2 = i;
			}
		}

		System.out.println("Resultats du sondage :");
		if (indiceCouleur1 > -1 && indiceCouleur2 > -1) {
			System.out.println(couleurs[indiceCouleur1] + "  " + couleurs[indiceCouleur2]);
		} else
			System.out.println("Pas assez de données");

		System.out.println(" Sondage : ");
		for (int i = 0; i < sondage.length; i++)
			System.out.println(couleurs[i] + " a obtenu " + sondage[i] + " votes");

	}
	// End class

}
