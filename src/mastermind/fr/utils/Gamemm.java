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
		int size = 0;
		my_person.win = false;
		my_person.shots = 0;

		try {
			while (size <= 0) {
				System.out.print("Choisissez le nombre de couleurs à deviner : ");
				size = sc.nextInt();
				if (size <= 0) {
					System.out.println("Le nombre indiqué est trop petit !");
				}
			}
			my_computer.nb_to_guess = my_computer.generate_nb_to_guess(size);
			my_computer.size_to_guess = calculs.nb_size(my_computer.nb_to_guess);
			my_computer.tab_to_guess = calculs.create_tab(my_computer.nb_to_guess, size);

			if (dev == 1) {
				System.out.println("Nombre de l'ordinateur : " + my_computer.nb_to_guess);
			}

			while (my_person.win == false) {
				while (my_person.nb_try < 0 ) {
					System.out.print("Tentez de trouver la combinaison : ");
					my_person.nb_try = sc.nextInt();
					if (my_person.nb_try < 0) {
						System.out.println("Le nombre indiqué est trop petit !");
					}
				}
				my_person.size_try = calculs.nb_size(my_person.nb_try);
				my_person.tab_try = calculs.create_tab(my_person.nb_try, size);

				if (my_person.tab_try.length == my_computer.tab_to_guess.length) {
					my_person = compar.challenger_tab_compar(my_person, my_computer);
					my_person.shots++;
				} else {
					messages.fail_value();
				}
			}
		} catch (Exception e) {
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
		my_computer.win = false;
		int limit = 10;
		my_person.nb_to_guess = -1;

		try {
			while (my_person.nb_to_guess <= 0) {
				System.out.println("Choisissez le nombre à faire deviner : ");
				my_person.nb_to_guess = sc.nextInt();
				if (my_person.nb_to_guess <= 0) {
					System.out.println("Le nombre indiqué est trop petit !");
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

			while (my_computer.win == false) {
				my_computer.last_try = my_computer.tab_try;
				my_computer = compar.defender_tab_compar(my_computer, my_person);
				my_computer.shots++;
				if (my_computer.count_placed == my_person.tab_to_guess.length) {
					my_computer.win = true;
				}
			}
			System.out.println("L'ordinateur a trouvé la combinaison en " + my_computer.shots + " coups !");
		} catch (ClassCastException e) {
			messages.fail_value();
		}
		return 0;
	}

	public int dual_mm(int dev) {
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
				System.out.println("Choisissez le nombre à faire deviner : ");
				my_person.nb_to_guess = sc.nextInt();
				if (my_person.nb_to_guess <= 0) {
					System.out.println("Le nombre indiqué est trop petit !");
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

			if (dev == 1) {
				System.out.println("Nombre de l'ordinateur : " + my_computer.nb_to_guess);
			}

			while (my_person.win == false && my_computer.win == false) {
				while (my_person.nb_try < 0) {
					System.out.print("Tentez de trouver la combinaison : ");
					my_person.nb_try = sc.nextInt();
					if (my_person.nb_try < 0) {
						System.out.println("Le nombre indiqué est trop petit !");
					}
				}
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
			}

			if (my_person.win == true && my_computer.win == false) {
				System.out.println("Le joueur a gagné en " + my_person.shots + " coups !");
			} else if (my_person.win == false && my_computer.win == true) {
				System.out.println("L'ordinateur a gagné en " + my_person.shots + " coups !");
			} else {
				System.out.println("Egalité !");
			}

		} catch (ClassCastException e) {
			messages.fail_value();
		}

		return 0;
	}
}
