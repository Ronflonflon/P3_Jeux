package plusOUmoins.fr.main;

import java.util.Scanner;

import plusOUmoins.fr.utils.Gamepom;

public class Plusoumoins {
	public void Plusoumoins(int dev) {
		int start = 1;
		int mode;
		Scanner sc = new Scanner(System.in);
		Gamepom manager = new Gamepom();
		
		System.out.println("============ Plus ou moins ============");
			while (start == 1) {
				try {
					System.out.println("A quel mode de jeu souhaites-tu jouer ?");
					System.out.println("- 1 pour le Mode Challenger");
					System.out.println("- 2 pour le Mode D�fenseur");
					System.out.println("- 3 pour le Mode Duel");
					System.out.print("Choisi le mode de jeu : ");
					mode = sc.nextInt();
					if (mode == 1) {
						manager.challenger_pom(dev);
					} else if (mode == 2) {
						manager.defender_pom(dev);
					} else if (mode == 3) {
						manager.dual_pom(dev);
					} else {
						System.out.println("La valeur que vous avez entr� semble incorrecte");
						mode = 0;
					}
				} catch (Exception e) {
					System.out.println("La valeur que vous avez entr� semble incorrecte...");
				}
				try {
					System.out.println("Voulez-vous rejouer (1 = Oui, 2 = Non) : ");
					start = sc.nextInt();
				} catch (Exception e) {
					System.out.println("La valeur que vous avez entr� semble incorrecte...");
					start = 0;
				}
			}
			sc.close();
			System.out.println("Au revoir !");
	}
}
