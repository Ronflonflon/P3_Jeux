package fr.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.utils.Game;

public class Main {

	public static void main(String[] args) {
		int start = 1;
		int mode;
		Game manager = new Game();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============ Plus ou moins ============");
		while (start == 1) {
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
				System.out.println("La valeur que vous avez entré semble incorrect ! :o");
			}
			System.out.println("Voulez-vous rejouer (1 = Oui, 2 = Non) : ");
			start = sc.nextInt();
		}
		
		System.out.println("Au revoir !");
		sc.close();
	}
}
