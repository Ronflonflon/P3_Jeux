package start;

import java.util.Scanner;

import mastermind.fr.main.Mastermind;
import plusOUmoins.fr.main.Plusoumoins;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Plusoumoins party_pom = new Plusoumoins();
		Mastermind party_mm = new Mastermind();
		int dev = 0;
		
		int game = 0;
		
		System.out.println("==============================");
		System.out.println("1 - Plus ou moins");
		System.out.println("2 - Mastermind");
		System.out.println("Sélectionne le jeu auquel tu souhaites jouer : ");
		
		try {
			game = sc.nextInt();
			
			System.out.println("Voulez-vous être en mode développeur ? (1 = Oui, 2 = Non) : "); 
			dev = sc.nextInt();
			
			if (game == 1) {
				party_pom.Plusoumoins(dev);
			} else if (game == 2) {
				party_mm.Mastermind(dev);
			} else {
				System.out.println("La valeur que vous avez entré semble incorrecte...");
			}
			//TODO Remplacer toutes les exceptions par Exception e
		} catch (ClassCastException e) {
			//OK
			System.out.println("La valeur que vous avez entré semble incorrecte...");
		}
		
		sc.close();
	}

}
