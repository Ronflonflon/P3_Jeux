package main.java.mastermind.fr.start;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.Config;
import main.java.Main;
import main.java.mastermind.fr.players.Computermm;
import main.java.mastermind.fr.players.Personmm;
import main.java.mastermind.fr.utils.Calculsmm;
import main.java.mastermind.fr.utils.Comparatormm;
import main.java.mastermind.fr.utils.Messagesmm;

public class Gamemm {
	private static final Logger logger = LogManager.getLogger(Main.class.getName());

	/**
	 * Mastermind - Mode challenger
	 * 
	 * @param config
	 *            Contient les infos sur le dossier de config et le mode dev (ou
	 *            non) de l'utilisateur
	 * @return void
	 */
	public void challenger_mm(Config config) {
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

			System.out
					.println("Il y a " + config.limit_color + " couleurs possibles de 0 � " + (config.limit_color - 1));

			while (my_person.win == false && my_person.shots < config.limit_of_try) {
				System.out.println("Nombre d'essai(s) restant(s) : " + (config.limit_of_try - my_person.shots));
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
					System.out.println(
							"Seuls des chiffres compris entre 0 et " + (config.limit_color - 1) + " sont autoris�s !");
				}
			}
			if (my_person.shots < config.limit_of_try) {
				System.out.println("Gagn� ! Vous avez gagn� en " + my_person.shots + " coups !");
				logger.trace("Gagn� en " + my_person.shots + " coups !");
			} else {
				System.out.println("Perdu ! Vous avez d�pass� les " + config.limit_of_try + " coups autoris�s !");
				logger.trace("Perdu, nombre de coups max : " + config.limit_of_try);
				System.out.print("La combinaison de l'orginateur �tait : ");
				for (int a = 0; a < my_computer.tab_to_guess.length; a++) {
					System.out.print(my_computer.tab_to_guess[a]);
				}
				System.out.println();
			}
		} catch (Exception e) {
			messages.fail_value();
		}
	}

	/**
	 * Mastermind - Mode defender
	 * 
	 * @param config
	 *            Contient les infos sur le dossier de config et le mode dev (ou
	 *            non) de l'utilisateur
	 * @return void
	 */
	public void defender_mm(Config config) {
		Computermm my_computer = new Computermm();
		Personmm my_person = new Personmm();
		Scanner sc = new Scanner(System.in);
		Comparatormm compar = new Comparatormm();
		Messagesmm messages = new Messagesmm();
		Calculsmm calculs = new Calculsmm();
		my_computer.win = false;
		int enter_valid = 0;
		my_person.nb_to_guess = -1;

		try {
			while (my_person.nb_to_guess <= 0 || enter_valid == 0) {
				System.out.println("Choisissez le nombre � faire deviner : ");
				my_person.nb_to_guess = sc.nextInt();
				if (my_person.nb_to_guess <= 0) {
					System.out.println("Le nombre indiqu� est trop petit !");
				}
				if (calculs.verify_tab_try(my_person.nb_to_guess, config.limit_color) == true) {
					enter_valid = 1;
				} else {
					System.out.println(
							"Seuls des chiffres compris entre 0 et " + (config.limit_color - 1) + " sont autoris�s !");
				}
			}
			my_person.tab_to_guess = calculs.create_tab(my_person.nb_to_guess, config.nb_case);
			my_computer.tab_try = my_computer.initialize_result(config.nb_case);
			my_computer.proba_result = my_computer.initialize_proba(config.nb_case, config.limit_color);
			my_computer.last_placed = 0;
			my_computer.last_present = 0;
			my_computer.position = (config.nb_case - 1);
			my_computer.shots = 0;
			my_computer.first_start = true;
			my_computer.last_try = my_computer.tab_try;
			
			System.out.println();
			
			/*
			System.out.print("Chiffre : ");
			for (int a = 0; a < my_computer.tab_try.length; a++) {
				System.out.print(my_computer.tab_try[a]);
			}
			System.out.println();
			*/
			
			while (my_computer.win == false && my_computer.shots < config.limit_of_try) {
				my_computer = compar.defender_tab_compar(my_computer, my_person);
				my_computer.last_try = my_computer.tab_try;
				my_computer.shots++;
				if (my_computer.count_placed == my_person.tab_to_guess.length) {
					my_computer.win = true;
				}
			}
			
			if (my_computer.shots < config.limit_of_try) {
				logger.trace("Perdu ! L'ordinateur a trouv� la combinaison en " + my_computer.shots + " coups !");
				System.out.println("Perdu ! L'ordinateur a trouv� la combinaison en " + my_computer.shots + " coups !");
			} else {
				logger.trace("Gagn� ! L'ordinateur n'a pas r�ussi � trouv� la combinaison en moins de "
						+ config.limit_of_try + " coups !");
				System.out.println("Gagn� ! L'ordinateur n'a pas r�ussi � trouv� la combinaison en moins de "
						+ config.limit_of_try + " coups !");
			}

		} catch (Exception e) {
			messages.fail_value();
		}
	}

	/**
	 * Mastermind - Mode dual
	 * 
	 * @param config
	 *            Contient les infos sur le dossier de config et le mode dev (ou
	 *            non) de l'utilisateur
	 * @return void
	 */
	public void dual_mm(Config config) {
		Computermm my_computer = new Computermm();
		Personmm my_person = new Personmm();
		Scanner sc = new Scanner(System.in);
		Comparatormm compar = new Comparatormm();
		Messagesmm messages = new Messagesmm();
		Calculsmm calculs = new Calculsmm();
		int win = 0;
		int limit = 10;
		int size;
		int enter_valid = 0;
		my_person.win = my_computer.win = false;
		my_person.shots = 0;
		my_person.nb_try = -1;
		my_person.nb_to_guess = -1;

		System.out.println("Il y a " + config.limit_color + " couleurs possibles de 0 � " + (config.limit_color - 1));

		try {
			while (my_person.nb_to_guess <= 0 || enter_valid == 0) {
				System.out.println("Choisissez le nombre � faire deviner : ");
				my_person.nb_to_guess = sc.nextInt();
				if (my_person.nb_to_guess <= 0) {
					System.out.println("Le nombre indiqu� est trop petit !");
				}
				if (calculs.verify_tab_try(my_person.nb_to_guess, config.limit_color) == true) {
					enter_valid = 1;
				} else {
					System.out.println(
							"Seuls des chiffres compris entre 0 et " + (config.limit_color - 1) + " sont autoris�s !");
				}
			}
			my_computer.size_to_guess = calculs.nb_size(my_computer.nb_to_guess);
			my_computer.tab_to_guess = calculs.create_tab_computer(config.nb_case, config.limit_color);
			my_person.tab_to_guess = calculs.create_tab(my_person.nb_to_guess, config.nb_case);
			my_computer.tab_try = my_computer.initialize_result(config.nb_case);
			my_computer.proba_result = my_computer.initialize_proba(config.nb_case, config.limit_color);
			my_computer.last_placed = 0;
			my_computer.last_present = 0;
			my_computer.position = (config.nb_case - 1);
			my_computer.shots = 0;
			my_computer.first_start = true;
			my_computer.last_try = my_computer.tab_try;
			
			if (config.dev == 1) {
				System.out.print("Nombre de l'ordinteur ");
				for (int i = 0; i < my_computer.tab_to_guess.length; i++) {
					System.out.print(my_computer.tab_to_guess[i]);
				}
				System.out.println();
			}

			while (my_person.win == false && my_computer.win == false && my_person.shots < config.limit_of_try
					&& my_computer.shots < config.limit_of_try) {
				System.out.println("Nombre d'essai(s) restant(s) : " + (config.limit_of_try - my_person.shots));
				System.out.print("Tentez de trouver la combinaison : ");
				my_person.nb_try = sc.nextInt();
				if (my_person.nb_try >= 0
						&& calculs.verify_tab_try(my_person.nb_try, config.limit_color) == true) {
					my_person.size_try = calculs.nb_size(my_person.nb_try);
					my_person.tab_try = calculs.create_tab(my_person.nb_try, config.nb_case);

					if (my_person.tab_try.length == my_computer.tab_to_guess.length) {
						my_person = compar.challenger_tab_compar(my_person, my_computer);
						my_person.shots++;
					} else {
						messages.fail_value();
					}

					my_computer = compar.defender_tab_compar(my_computer, my_person);
					my_computer.last_try = my_computer.tab_try;
					my_computer.shots++;
					if (my_computer.count_placed == my_person.tab_to_guess.length) {
						my_computer.win = true;
					}
				} else {
					System.out.println(
							"Seuls des chiffres compris entre 0 et " + (config.limit_color - 1) + " sont autoris�s !");
				}
			}

			if (my_person.win == true && my_computer.win == false) {
				logger.trace("Joueur a gagn� en " + my_person.shots + " coups");
				System.out.println("Gagn� ! Vous avez gagn� en " + my_person.shots + " coups");
			} else if (my_person.win == false && my_computer.win == true) {
				logger.trace("Ordinateur a gagn� en " + my_computer.shots + " coups");
				System.out.println("Perdu ! L'ordinateur a gagn� en " + my_person.shots + " coups");
			} else if (my_person.win == true && my_computer.win == true) {
				logger.trace("Egalit� en " + my_person.shots + " coups");
				System.out.println("Egalit� ! Vous avez tous les deux trouv� la combinaison de l'autre en "
						+ my_person.shots + " coups !");
			} else {
				logger.trace(
						"Tout le monde a perdu, personne n'a trouv� en moins de " + config.limit_of_try + " coups");
				System.out.println(
						"Tout le monde a perdu ! Personne n'a r�ussi � trouv� la combinaison de l'autre en moins de "
								+ config.limit_of_try + " coups !");
			}

		} catch (Exception e) {
			messages.fail_value();
		}
	}
}
