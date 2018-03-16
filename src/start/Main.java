package start;

import java.util.Scanner;

import mastermind.fr.main.Mastermind;
import plusOUmoins.fr.main.Plusoumoins;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Plusoumoins party_pom = new Plusoumoins();
		Mastermind party_mm = new Mastermind();
		
		int game = 0;
		
		System.out.println("==============================");
		System.out.println("1 - Plus ou moins");
		System.out.println("2 - Mastermind");
		System.out.println("Sélectionne le jeu auquel tu souhaites jouer : ");
		
		try {
			game = sc.nextInt();
			
			if (game == 1) {
				party_pom.Plusoumoins();
			} else if (game == 2) {
				party_mm.Mastermind();
			} else {
				System.out.println("La valeur que vous avez entré semble incorrecte...");
			}
		} catch (Exception e) {
			System.out.println("La valeur que vous avez entré semble incorrecte...");
		}
		
		sc.close();
	}

}
