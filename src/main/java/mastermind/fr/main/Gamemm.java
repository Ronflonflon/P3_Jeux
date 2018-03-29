package main.java.mastermind.fr.main;

import java.util.Scanner;

import lib.main.Config;
import lib.mastermind.fr.players.Computermm;
import lib.mastermind.fr.players.Personmm;
import lib.mastermind.fr.utils.Calculsmm;
import lib.mastermind.fr.utils.Comparatormm;
import lib.mastermind.fr.utils.Messagesmm;

public class Gamemm {
	public int challenger_mm(Config config) {
		Messagesmm messages = new Messagesmm();
		Personmm my_person = new Personmm();
		Computermm my_computer = new Computermm();
		Calculsmm calculs = new Calculsmm();
		Comparatormm compar = new Comparatormm();
		Scanner sc = new Scanner(System.in);
		int size = 0;
		my_person.win = false;
		my_person.shots = 0;

		try {
			my_computer.tab_to_guess = calculs.create_tab_computer(config.nb_case, config.limit_color);
			if (config.dev == 1) {
				System.out.print("Nombre de l'ordinteur ");
				for (int i = 0; i < my_computer.tab_to_guess.length; i++) {
					System.out.print(my_computer.tab_to_guess[i]);
				}
				System.out.println();
			}
			
			System.out.println("Il y a " + config.limit_color + " couleurs possibles de 0 � " + (config.limit_color - 1));
			
			while (my_person.win == false && my_person.shots < config.limit_of_try) {
				System.out.println("Nombre d'essaie(s) restant(s) : " + (config.limit_of_try - my_person.shots));
				System.out.print("Tentez de trouver la combinaison : ");
				my_person.nb_try = sc.nextInt();
				if (my_person.nb_try >= 0 && calculs.verify_tab_try(my_person.nb_try, config.limit_color)) {
					my_person.size_try = calculs.nb_size(my_person.nb_try);
					my_person.tab_try = calculs.create_tab(my_person.nb_try, config.nb_case);
					
					if (my_person.tab_try.length == my_computer.tab_to_guess.length) {
						my_person = compar.challenger_tab_compar(my_person, my_computer);
						my_person.shots++;
					} else {
						messages.fail_value();
					}
				} else {
					System.out.println("Seuls des chiffres compris entre 0 et " + (config.limit_color - 1) + " sont autoris�s !");
				}
			}
			if (my_person.shots < config.limit_of_try) {
				System.out.println("Gagn� ! Vous avez gagn� en " + my_person.shots + " coups !");
			} else {
				System.out.println("Perdu ! Vous avez d�pass� les " + config.limit_of_try + " coups autoris�s !");
			}
		} catch (Exception e) {
			messages.fail_value();
		}

		return 0;
	}

	public int defender_mm(Config config) {
		Computermm my_computer = new Computermm();
		Personmm my_person = new Personmm();
		Scanner sc = new Scanner(System.in);
		Comparatormm compar = new Comparatormm();
		Messagesmm messages = new Messagesmm();
		Calculsmm calculs = new Calculsmm();
		my_computer.win = false;
		int limit = 10;
		my_person.nb_to_guess = -1;

		try {
			while (my_person.nb_to_guess <= 0) {
				System.out.println("Choisissez le nombre � faire deviner : ");
				my_person.nb_to_guess = sc.nextInt();
				if (my_person.nb_to_guess <= 0) {
					System.out.println("Le nombre indiqu� est trop petit !");
				}
			}
			my_person.tab_to_guess = calculs.create_tab(my_person.nb_to_guess, calculs.nb_size(my_person.nb_to_guess));
			my_computer.tab_try = my_computer.initialize_result(my_person.tab_to_guess.length);
			my_computer.proba_result = my_computer.initialize_proba(my_person.tab_to_guess.length, limit);
			my_computer.last_try = my_computer.tab_try;
			my_computer.last_placed = 0;
			my_computer.last_present = 0;
			my_computer.position = (my_computer.tab_try.length - 1);
			my_computer.shots = 0;

			while (my_computer.win == false && my_computer.shots < config.limit_of_try) {
				my_computer.last_try = my_computer.tab_try;
				my_computer = compar.defender_tab_compar(my_computer, my_person);
				my_computer.shots++;
				if (my_computer.count_placed == my_person.tab_to_guess.length) {
					my_computer.win = true;
				}
			}

			if (my_computer.shots < config.limit_of_try) {
				System.out.println("Perdu ! L'ordinateur a trouv� la combinaison en " + my_computer.shots + " coups !");
			} else {
				System.out.println("Gagn� ! L'ordinateur n'a pas r�ussi � trouv� la combinaison en moins de "
						+ config.limit_of_try + " coups !");
			}

		} catch (ClassCastException e) {
			messages.fail_value();
		}
		return 0;
	}

	public int dual_mm(Config config) {
		Computermm my_computer = new Computermm();
		Personmm my_person = new Personmm();
		Scanner sc = new Scanner(System.in);
		Comparatormm compar = new Comparatormm();
		Messagesmm messages = new Messagesmm();
		Calculsmm calculs = new Calculsmm();
		int win = 0;
		int limit = 10;
		int size;
		my_person.win = my_computer.win = false;
		my_person.shots = 0;
		my_person.nb_try = -1;
		my_person.nb_to_guess = -1;

		try {
			while (my_person.nb_to_guess <= 0) {
				System.out.println("Choisissez le nombre � faire deviner : ");
				my_person.nb_to_guess = sc.nextInt();
				if (my_person.nb_to_guess <= 0) {
					System.out.println("Le nombre indiqu� est trop petit !");
				}
			}
			size = calculs.nb_size(my_person.nb_to_guess);
			my_person.tab_to_guess = calculs.create_tab(my_person.nb_to_guess, size);
			my_computer.nb_to_guess = my_computer.generate_nb_to_guess(size);
			my_computer.size_to_guess = calculs.nb_size(my_computer.nb_to_guess);
			my_computer.tab_to_guess = calculs.create_tab(my_computer.nb_to_guess, size);
			my_computer.tab_try = my_computer.initialize_result(size);
			my_computer.proba_result = my_computer.initialize_proba(size, limit);
			my_computer.last_try = my_computer.tab_try;
			my_computer.last_placed = 0;
			my_computer.last_present = 0;
			my_computer.position = (my_computer.tab_try.length - 1);
			my_computer.shots = 0;

			if (config.dev == 1) {
				System.out.println("Nombre de l'ordinateur : " + my_computer.nb_to_guess);
			}

			while (my_person.win == false && my_computer.win == false && my_person.shots < config.limit_of_try
					&& my_computer.shots < config.limit_of_try) {
				System.out.print("Tentez de trouver la combinaison : ");
				my_person.nb_try = sc.nextInt();
				if (my_person.nb_try >= 0) {
					my_person.size_try = calculs.nb_size(my_person.nb_try);
					my_person.tab_try = calculs.create_tab(my_person.nb_try, size);

					if (my_person.tab_try.length == my_computer.tab_to_guess.length) {
						my_person = compar.challenger_tab_compar(my_person, my_computer);
						my_person.shots++;
					} else {
						messages.fail_value();
					}

					my_computer.last_try = my_computer.tab_try;
					my_computer = compar.defender_tab_compar(my_computer, my_person);
					my_computer.shots++;
					if (my_computer.count_placed == my_person.tab_to_guess.length) {
						my_computer.win = true;
					}
				} else {
					System.out.println("Le nombre indiqu� est trop petit !");
				}
			}

			if (my_person.win == true && my_computer.win == false) {
				System.out.println("Gagn� ! Vous avez gagn� en " + my_person.shots + " coups !");
			} else if (my_person.win == false && my_computer.win == true) {
				System.out.println("Perdu ! L'ordinateur a gagn� en " + my_person.shots + " coups !");
			} else if (my_person.win == true && my_computer.win == true) {
				System.out.println("Egalit� ! Vous avez tous les deux trouv� la combinaison de l'autre en "
						+ my_person.shots + " coups !");
			} else {
				System.out.println(
						"Tout le monde a perdu ! Personne n'a r�ussi � trouv� la combinaison de l'autre en moins de "
								+ config.limit_of_try + " coups !");
			}

		} catch (ClassCastException e) {
			messages.fail_value();
		}

		return 0;
	}
}
