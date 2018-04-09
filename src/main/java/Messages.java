package main.java;

public class Messages {
	public void choose_game() {
		System.out.println("==============================");
		System.out.println("1 - Plus ou moins");
		System.out.println("2 - Mastermind");
		System.out.print("Sélectionne le jeu auquel tu souhaites jouer : ");
	}

	public void fail_value() {
		System.out.println("Un erreur c'est produite (avez-vous entré une valeur incorrecte ?)");
	}

	public void choose_mod() {
		System.out.println("A quel mode de jeu souhaites-tu jouer ?");
		System.out.println("- 1 pour le Mode Challenger");
		System.out.println("- 2 pour le Mode Défenseur");
		System.out.println("- 3 pour le Mode Duel");
		System.out.print("Choisi le mode de jeu : ");
	}
}
