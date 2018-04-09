package main.java.mastermind.fr.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.Main;
import main.java.mastermind.fr.players.Computermm;
import main.java.mastermind.fr.players.Personmm;

public class Comparatormm {
	private static final Logger logger = LogManager.getLogger(Main.class.getName());

	/**
	 * Systeme de comparaison des réponses du Mastermind - Mode challenger
	 * 
	 * @param my_person
	 * @param my_computer
	 *            Les deux informations à comparer (en l'occurence ce seront les
	 *            my_person.tab_try et my_computer.tab_to_guess qui le seront)
	 * @return Personmm Les valeurs de la personne évoluent pour récolter plus
	 *         d'informations
	 */
	public Personmm challenger_tab_compar(Personmm my_person, Computermm my_computer) {
		int count_placed = 0;
		int count_present = 0;
		int j = 0;
		int k = 0;
		int forbid_placed[] = new int[my_person.tab_try.length];
		int forbid_present[] = new int[my_person.tab_try.length];
		int found = 0;

		for (int i = 0; i < my_person.tab_try.length; i++) {
			if (my_person.tab_try[i] == my_computer.tab_to_guess[i]) {
				forbid_placed[i] = 1;
				count_placed++;
			} else {
				forbid_placed[i] = 0;
			}
		}

		while (j < my_person.tab_try.length) {
			while (k < my_computer.tab_to_guess.length && found == 0) {
				if (my_person.tab_try[j] == my_computer.tab_to_guess[k] && forbid_present[k] == 0) {
					if (forbid_placed[k] == 0) {
						forbid_present[k] = 1;
						count_present++;
						found = 1;
					} else {
						forbid_present[k] = 0;
					}
				}

				k++;
			}
			found = 0;
			k = 0;
			j++;
		}
		j = 0;
		System.out.print("Joueur : ");
		while (j < my_person.tab_try.length) {
			System.out.print(my_person.tab_try[j]);
			j++;
		}
		System.out.print(" ");
		if (count_placed == 0 && count_present == 0) {
			System.out.println("-> Aucune couleur n'est présente");
		} else if (count_placed == 0 && count_present > 0) {
			if (count_present > 1) {
				System.out.println("-> " + count_present + " couleurs présentes");
			} else {
				System.out.println("-> " + count_present + " couleur présente");

			}
		} else if (count_placed > 0 && count_present == 0) {
			if (count_placed > 1) {
				System.out.println("-> " + count_placed + " couleurs bien placées");
			} else {
				System.out.println("-> " + count_placed + " couleur bien placée");
			}
		} else if (count_placed > 0 && count_present > 0) {
			System.out.print("-> " + count_placed);
			if (count_placed > 1) {
				System.out.print(" bien placées et ");
			} else {
				System.out.print(" bien placée et ");
			}
			System.out.print(count_present);
			if (count_present > 1) {
				System.out.println(" présentes");
			} else {
				System.out.println(" présente");
			}
		}
		if (count_placed == my_computer.tab_to_guess.length) {
			my_person.win = true;
		} else {
			my_person.win = false;
		}

		logger.trace("Nombre de chiffres bien placés : " + count_placed + " et nombre de chiffres présents "
				+ count_present);

		return my_person;
	}

	/**
	 * Systeme de comparaison des réponses du Mastermind - Mode defender
	 * 
	 * @param my_computer
	 * @param my_person
	 *            Les deux informations à comparer (en l'occurence ce seront les
	 *            my_person.tab_to_guess et my_computer.tab_try qui le seront)
	 * @return Computermm Les informations de l'ordinateur évoluent pour trouver au
	 *         plus vite la combinaison
	 */
	public Computermm defender_tab_compar(Computermm my_computer, Personmm my_person) {
		my_computer.count_placed = 0;
		my_computer.count_present = 0;
		int j = 0;
		int k = 0;
		int forbid_placed[] = new int[my_person.tab_to_guess.length];
		int forbid_present[] = new int[my_person.tab_to_guess.length];
		int found = 0;

		for (int i = 0; i < my_computer.tab_try.length; i++) {
			if (my_computer.tab_try[i] == my_person.tab_to_guess[i]) {
				forbid_placed[i] = 1;
				my_computer.count_placed++;
			} else {
				forbid_placed[i] = 0;
			}
		}

		while (j < my_computer.tab_try.length) {
			while (k < my_person.tab_to_guess.length && found == 0) {
				if (my_computer.tab_try[j] == my_person.tab_to_guess[k] && forbid_present[k] == 0) {
					if (forbid_placed[k] == 0) {
						forbid_present[k] = 1;
						my_computer.count_present++;
						found = 1;
					} else {
						forbid_present[k] = 0;
					}
				}

				k++;
			}
			found = 0;
			k = 0;
			j++;
		}
		j = 0;
		System.out.print("Ordinateur : ");
		while (j < my_computer.tab_try.length) {
			System.out.print(my_computer.tab_try[j]);
			j++;
		}

		System.out.print(" ");
		if (my_computer.count_placed == 0 && my_computer.count_present == 0) {
			System.out.println("-> Aucune couleur n'est présente");
		} else if (my_computer.count_placed == 0 && my_computer.count_present > 0) {
			if (my_computer.count_present > 1) {
				System.out.println("-> " + my_computer.count_present + " couleurs présentes");
			} else {
				System.out.println("-> " + my_computer.count_present + " couleur présente");

			}
		} else if (my_computer.count_placed > 0 && my_computer.count_present == 0) {
			if (my_computer.count_placed > 1) {
				System.out.println("-> " + my_computer.count_placed + " couleurs bien placées");
			} else {
				System.out.println("-> " + my_computer.count_placed + " couleur bien placée");
			}
		} else if (my_computer.count_placed > 0 && my_computer.count_present > 0) {
			System.out.print("-> " + my_computer.count_placed);
			if (my_computer.count_placed > 1) {
				System.out.print(" bien placées et ");
			} else {
				System.out.print(" bien placée et ");
			}
			System.out.print(my_computer.count_present);
			if (my_computer.count_present > 1) {
				System.out.println(" présentes");
			} else {
				System.out.println(" présente");
			}
		}
		
		if (my_computer.first_start == true) {
			my_computer.last_placed = my_computer.count_placed;
			my_computer = my_computer.generate_tab_try(my_computer, my_person);
			my_computer.first_start = false;
		} else {
			my_computer = my_computer.generate_tab_try(my_computer, my_person);
			my_computer.last_placed = my_computer.count_placed;

		}

		my_computer.last_present = my_computer.count_present;

		logger.trace("Nombre de chiffres bien placés : " + my_computer.count_placed + " et nombre de chiffres présents "
				+ my_computer.count_present);

		return my_computer;
	}

}
