package mastermind.fr.utils;

import java.util.LinkedList;
import java.util.List;

import mastermind.fr.players.Computermm;
import mastermind.fr.players.Personmm;

public class Comparatormm {
	public int challenger_tab_compar(int tab_person[], int tab_computer[]) {
		Calculsmm calcul = new Calculsmm();
		int count_placed = 0;
		int count_present = 0;
		int j = 0;
		int k = 0;
		int forbid_placed[] = new int[tab_person.length];
		int forbid_present[] = new int[tab_person.length];

		for (int i = 0; i < tab_person.length; i++) {
			if (tab_person[i] == tab_computer[i]) {
				forbid_placed[i] = 1;
				count_placed++;
			} else {
				forbid_placed[i] = 0;
			}
		}

		while (j < tab_person.length) {
			while (k < tab_computer.length) {
				if (tab_person[j] == tab_computer[k] && forbid_present[k] == 0) {
					if (forbid_placed[k] == 0) {
						forbid_present[k] = 1;
						count_present++;
					} else {
						forbid_present[k] = 0;
					}
				}

				k++;
			}
			k = 0;
			j++;
		}

		if (count_placed == 0 && count_present == 0) {
			System.out.println("-> Aucune couleur n'est présente)");
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
				System.out.println("-> " + count_placed + " couleurs bien placée");
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
				System.out.println(" prétentes");
			} else {
				System.out.println(" présente");
			}
		}
		if (count_placed == tab_computer.length) {
			return 1;
		} else {
			return 0;
		}
	}

	public Computermm defender_tab_compar(Computermm my_computer, Personmm my_person) {
		Calculsmm calcul = new Calculsmm();
		my_computer.count_placed = 0;
		my_computer.count_present = 0;
		int j = 0;
		int k = 0;
		int forbid_placed[] = new int[my_person.tab_to_guess.length];
		int forbid_present[] = new int[my_person.tab_to_guess.length];

		for (int i = 0; i < my_computer.tab_try.length; i++) {
			if (my_computer.tab_try[i] == my_person.tab_to_guess[i]) {
				forbid_placed[i] = 1;
				my_computer.count_placed++;
			} else {
				forbid_placed[i] = 0;
			}
		}

		while (j < my_computer.tab_try.length) {
			while (k < my_person.tab_to_guess.length) {
				if (my_computer.tab_try[j] == my_person.tab_to_guess[k] && forbid_present[k] == 0) {
					if (forbid_placed[k] == 0) {
						forbid_present[k] = 1;
						my_computer.count_present++;
					} else {
						forbid_present[k] = 0;
					}
				}

				k++;
			}
			k = 0;
			j++;
		}
		j = 0;
		System.out.print("Combinaison tentée : ");
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
				System.out.println(" prétentes");
			} else {
				System.out.println(" présente");
			}
		}
		my_computer.last_try = my_computer.tab_try;
		my_computer = my_computer.generate_tab_try(my_computer);
		my_computer.last_placed = my_computer.count_placed;
		my_computer.last_present = my_computer.count_present;

		return my_computer;
	}

}
