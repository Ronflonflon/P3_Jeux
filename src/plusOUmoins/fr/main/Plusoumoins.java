package plusOUmoins.fr.main;

import java.util.Scanner;

import plusOUmoins.fr.utils.Game;

public class Plusoumoins {
	public void Plusoumoins() {
		int start = 1;
		int mode;
		Scanner sc = new Scanner(System.in);
		Game manager = new Game();
		
		System.out.println("============ Plus ou moins ============");
			while (start == 1) {
				try {
					System.out.println("A quel mode de jeu souhaites-tu jouer ?");
					System.out.println("- 1 pour le Mode Challenger");
					System.out.println("- 2 pour le Mode Défenseur");
					System.out.println("- 3 pour le Mode Duel");
					System.out.print("Choisi le mode de jeu : ");
					mode = sc.nextInt();
					if (mode == 1) {
						manager.challenger(mode);
					} else if (mode == 2) {
						manager.defender(mode);
					} else if (mode == 3) {
						manager.dual(mode);
					} else {
						System.out.println("La valeur que vous avez entré semble incorrecte");
						mode = 0;
					}
				} catch (Exception e) {
					System.out.println("La valeur que vous avez entré semble incorrecte...");
				}
				try {
					System.out.println("Voulez-vous rejouer (1 = Oui, 2 = Non) : ");
					start = sc.nextInt();
					System.out.println("Valeur de start : " + start);
				} catch (Exception e) {
					System.out.println("La valeur que vous avez entré semble incorrecte...");
					start = 0;
				}
			}
			sc.close();
			System.out.println("Au revoir !");
	}
}
