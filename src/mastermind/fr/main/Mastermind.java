package mastermind.fr.main;

import java.util.Scanner;

import mastermind.fr.utils.Gamemm;

public class Mastermind {
	public void Mastermind(int admin) {
		Scanner sc = new Scanner(System.in);
		Gamemm manager = new Gamemm();
		int mode;
		int start = 1;
		
		System.out.println("============ Plus ou moins ============");
		System.out.println("============= Mastermind =============");
		
		while (start == 1) {
			try {
				System.out.println("A quel mode de jeu souhaites-tu jouer ?");
				System.out.println("- 1 pour le Mode Challenger");
				System.out.println("- 2 pour le Mode Défenseur");
				System.out.println("- 3 pour le Mode Duel");
				System.out.print("Choisi le mode de jeu : ");
				mode = sc.nextInt();
				if (mode == 1) {
					manager.challenger_mm(mode);
				} else if (mode == 2) {
					manager.defender_mm(mode);
				} else if (mode == 3) {
					manager.dual_mm(mode);
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
			} catch (Exception e) {
				System.out.println("La valeur que vous avez entré semble incorrecte...");
				start = 0;
			}
		}
	}
}
