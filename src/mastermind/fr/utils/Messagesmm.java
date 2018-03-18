package mastermind.fr.utils;

public class Messagesmm {
	public void choose_mod() {
		System.out.println("A quel mode de jeu souhaites-tu jouer ?");
		System.out.println("- 1 pour le Mode Challenger");
		System.out.println("- 2 pour le Mode Défenseur");
		System.out.println("- 3 pour le Mode Duel");
		System.out.print("Choisi le mode de jeu : ");
	}

	public void fail_value() {
		System.out.println("La valeur que vous avez entré semble incorrecte");
	}

	public void restart_game() {
		System.out.println("Voulez-vous rejouer (1 = Oui, 2 = Non) : ");
	}

	public void choose_size() {
		System.out.print("Choisi la taille du nombre à deviner : ");
	}

	public void choose_nb() {
		System.out.print("Choisi le nombre à faire deviner : ");
	}

	public void end_game() {
		System.out.println("Au revoir !");
	}
}
