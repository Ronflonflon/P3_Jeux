package main.java.plusOUmoins.fr.start;

import java.util.Scanner;

import main.java.Config;
import main.java.plusOUmoins.fr.players.Computerpom;
import main.java.plusOUmoins.fr.players.Personpom;
import main.java.plusOUmoins.fr.utils.Calculspom;
import main.java.plusOUmoins.fr.utils.Comparatorpom;
import main.java.plusOUmoins.fr.utils.Messagespom;

public class Gamepom {
	public int challenger_pom(Config config) {
		Calculspom calcul = new Calculspom();
		Comparatorpom compar = new Comparatorpom();
		Personpom my_person = new Personpom();
		Computerpom my_computer = new Computerpom();
		Scanner sc = new Scanner(System.in);
		Messagespom messages = new Messagespom();
		
		int win = 0;

		try {
			my_computer.nb_to_guess = my_computer.generate_nb_to_guess(config.nb_case);
			my_computer.size = calcul.nb_size(my_computer.nb_to_guess);

			if (config.dev == 1) {
				System.out.println("Le nombre de l'ordinateur est " + my_computer.nb_to_guess);
			}

			while (win == 0 && my_person.shots < config.limit_of_try) {
				System.out.println("Nombre d'essai(s) restant(s) : " + (config.limit_of_try - my_person.shots));
				System.out.print("Choisi un nombre contenant " + config.nb_case + " chiffres : ");
				my_person.nb_try = sc.nextInt();
				if (my_person.nb_try < 0) {
					messages.fail_value();
				} else {
					if (calcul.nb_size(my_computer.nb_to_guess) >= calcul.nb_size(my_person.nb_try)) {
						win = compar.compar_numbers_challenger(my_computer, my_person);
						System.out.println("win = " + win);
						my_person.shots++;
					} else {
						System.out.println(
								"Le nombre doit contenir " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres !");
					}
				}
			}

			if (my_person.shots < config.limit_of_try) {
				System.out.println("Gagné ! Code dévérouillé en " + my_person.shots + " coups, bravo !");
			} else {
				System.out.println("Perdu ! Vous n'avez pas réussi à dévérouiller le code en moins de "
						+ config.limit_of_try + " coups !");
			}
		} catch (Exception e) {
			messages.fail_value();
		}
		return win;
	}

	public int defender_pom(Config config) {
		Personpom my_person = new Personpom();
		Calculspom calcul = new Calculspom();
		Comparatorpom compar = new Comparatorpom();
		Scanner sc = new Scanner(System.in);
		Messagespom messages = new Messagespom();
		int win = 0;

		try {
			messages.choose_nb();
			my_person.nb_to_guess = sc.nextInt();

			if (my_person.nb_to_guess <= 0) {
				System.out.println(
						"Le nombre ne peut pas être " + my_person.nb_to_guess + ", il doit être supérieur à 0");
			} else {
				Computerpom my_computer = new Computerpom();
				my_computer.size = my_person.size = calcul.nb_size(my_person.nb_to_guess);
				my_person.tab_to_guess = calcul.create_tab(my_person, my_person.nb_to_guess);

				my_computer = my_computer.initialize_compute_tabs(my_computer);

				while (win == 0) {
					win = compar.compar_numbers_defender(my_computer, my_person);
					my_computer.shots++;
				}

				if (my_computer.shots < config.limit_of_try) {
					System.out
							.println("Perdu ! L'ordinateur a dévérouillé le code en " + my_computer.shots + " coups !");
				} else {
					System.out.println("Gagné ! L'ordinateur n'a pas réussi a dévérouiller le code en + "
							+ config.limit_of_try + " coups !");
				}

			}
		} catch (Exception e) {
			messages.fail_value();
		}
		return win;
	}

	public int dual_pom(Config config) {
		Calculspom calcul = new Calculspom();
		Comparatorpom compar = new Comparatorpom();
		Personpom my_person = new Personpom();
		Computerpom my_computer = new Computerpom();
		Scanner resp = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		Messagespom messages = new Messagespom();
		int win_person = 0;
		int win_computer = 0;

		try {
			messages.choose_nb();
			my_person.nb_to_guess = sc.nextInt();
			if (my_person.nb_to_guess <= 0) {
				System.out.println(
						"Le nombre ne peut pas être " + my_person.nb_to_guess + ", il doit être supérieur à 0");
			} else {
				my_computer.size = my_person.size = calcul.nb_size(my_person.nb_to_guess);
				my_person.tab_to_guess = calcul.create_tab(my_person, my_person.nb_to_guess);
				my_computer = my_computer.initialize_compute_tabs(my_computer);

				my_computer.nb_to_guess = my_computer.generate_nb_to_guess(my_person.size);

				if (config.dev == 1) {
					System.out.println("Le nombre de l'ordinateur est " + my_computer.nb_to_guess);
				}

				while (win_person == 0 && win_computer == 0) {
					System.out.println("Nombre d'essai(s) restant(s) : " + (config.limit_of_try - my_person.shots));
					System.out.print(
							"Choisi un nombre contenant " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres : ");
					my_person.nb_try = resp.nextInt();
					if (my_person.nb_try < 0) {
						messages.fail_value();
					} else {
						if (my_person.nb_try <= 0) {
							System.out.println(
									"Le nombre ne peut pas être " + my_person.nb_try + ", il doit être supérieur à 0");
						} else {
							if (calcul.nb_size(my_computer.nb_to_guess) >= calcul.nb_size(my_person.nb_try)) {
								System.out.print("Resultat joueur : ");
								win_person = compar.compar_numbers_challenger(my_computer, my_person);
								my_person.shots++;
							} else {
								System.out.println("Le nombre doit contenir " + calcul.nb_size(my_computer.nb_to_guess)
										+ " chiffres !");
							}
							System.out.print("Résultat ordinateur : ");
							win_computer = compar.compar_numbers_defender(my_computer, my_person);
							my_computer.shots++;
						}
					}
				}

				if (win_person == 1 && win_computer == 1) {
					System.out.println("Egalité !");
				} else if (win_computer == 1) {
					System.out.println("L'ordinateur a gagné cette partie en " + my_computer.shots + " coups !");
					System.out.println("Le nombre de l'ordinateur était " + my_computer.nb_to_guess);
				} else if (win_person == 1) {
					System.out.println("Tu as a gagné cette partie en " + my_computer.shots + " coups !");
				}
			}
		} catch (Exception e) {
			messages.fail_value();
		}
		return 0;
	}
}
