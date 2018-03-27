package mastermind.fr.utils;

import java.util.Scanner;

import mastermind.fr.players.Computermm;
import mastermind.fr.players.Personmm;

public class Gamemm {
	public int challenger_mm(int dev) {
		Messagesmm messages = new Messagesmm();
		Personmm my_person = new Personmm();
		Computermm my_computer = new Computermm();
		Calculsmm calculs = new Calculsmm();
		Comparatormm compar = new Comparatormm();
		Scanner sc = new Scanner(System.in);
		int size;
		int win = 0;
		my_person.shots = 0;

		try {
			System.out.print("Choisissez le nombre de couleurs à deviner : ");
			size = sc.nextInt();
			//my_computer.nb_to_guess = my_computer.generate_nb_to_guess(size);
			my_computer.nb_to_guess = 1526;
			my_computer.size_to_guess = calculs.nb_size(my_computer.nb_to_guess);
			my_computer.tab_to_guess = calculs.create_tab(my_computer.nb_to_guess, my_computer.size_to_guess);

			if (dev == 1) {
				System.out.println("Nombre de l'ordinateur : " + my_computer.nb_to_guess);
			}

			while (win != 1) {
				System.out.print("Tentez de trouver la combinaison : ");
				my_person.nb_try = sc.nextInt();
				my_person.size_try = calculs.nb_size(my_person.nb_try);
				my_person.tab_try = calculs.create_tab(my_person.nb_try, my_person.size_try);

				if (my_person.size_try == my_computer.size_to_guess) {
					win = compar.challenger_tab_compar(my_person.tab_try, my_computer.tab_to_guess);
					my_person.shots++;
				} else {
					System.out.println("eee");
					messages.fail_value();
				}
			}
		} catch (Exception e) {
			System.out.println("Vroum");
			messages.fail_value();
		}
		
		System.out.println("Bravo ! Vous avez gagné en " + my_person.shots + " coups !");

		return 0;
	}

	public int defender_mm(int mode) {
		Computermm my_computer = new Computermm();
		Personmm my_person = new Personmm();
		Scanner sc = new Scanner(System.in);
		Comparatormm compar = new Comparatormm();
		Messagesmm messages = new Messagesmm();
		Calculsmm calculs = new Calculsmm();
		int win = 0;
		int limit = 10;
		
		try {
		System.out.println("Choisissez le nombre à faire deviner : ");
		my_person.nb_to_guess = sc.nextInt();
		my_person.tab_to_guess = calculs.create_tab(my_person.nb_to_guess, calculs.nb_size(my_person.nb_to_guess));
		my_computer.tab_try = my_computer.initialize_result(my_person.tab_to_guess.length);
		my_computer.proba_result = my_computer.initialize_proba(my_person.tab_to_guess.length, limit);
		my_computer.last_try = my_computer.tab_try;
		my_computer.last_placed = 0;
		my_computer.last_present = 0;
		my_computer.position = (my_computer.tab_try.length - 1);
		my_computer.shots = 0;
		
		while (win != 1) {
			my_computer.last_try = my_computer.tab_try;
			my_computer = compar.defender_tab_compar(my_computer, my_person);
			my_computer.shots++;
			if (my_computer.count_placed == my_person.tab_to_guess.length) {
				win = 1;
			}
		}
		System.out.println("L'ordinateur a trouvé la combinaison en " + my_computer.shots + " coups !");
		} catch (ClassCastException e) {
			messages.fail_value();
		}
		return 0;
	}

	public int dual_mm(int mode) {
		
		return 0;
	}
}
