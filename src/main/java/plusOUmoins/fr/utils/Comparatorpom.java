package main.java.plusOUmoins.fr.utils;

import java.util.LinkedList;
import java.util.List;

import main.java.plusOUmoins.fr.players.*;
import main.java.plusOUmoins.fr.utils.Calculspom;

public class Comparatorpom {
	public int compar_numbers_challenger(Computerpom my_computer, Personpom my_person) {
		int good_shot = 0;
		Calculspom calcul = new Calculspom();

		my_person.size = calcul.nb_size(my_computer.nb_to_guess);
		my_computer.size = calcul.nb_size(my_computer.nb_to_guess);
		my_computer.tab_to_guess = calcul.create_tab(my_computer, my_computer.nb_to_guess);
		my_person.tab_try = calcul.create_tab(my_person, my_person.nb_try);

		for (int i = (my_computer.tab_to_guess.size() - 1); i >= 0; i--) {
			if ((int) my_computer.tab_to_guess.get(i) < (int) my_person.tab_try.get(i)) {
				// System.out.print(unit_try + " : ");
				System.out.print("-");
			} else if ((int) my_computer.tab_to_guess.get(i) > (int) my_person.tab_try.get(i)) {
				// System.out.print(unit_try + " : ");
				System.out.print("+");
			} else {
				// System.out.print(unit_try + " : ");
				System.out.print("=");
				good_shot++;
			}
		}
		System.out.println();
		if (good_shot >= calcul.nb_size(my_computer.nb_to_guess)) {
			return 1;
		} else {
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public int compar_numbers_defender(Computerpom my_computer, Personpom my_person) {
		int good_shot = 0;
		Calculspom calcul = new Calculspom();

		my_person.size = calcul.nb_size(my_computer.nb_to_guess);
		my_computer.size = calcul.nb_size(my_computer.nb_to_guess);

		for (int i = (my_person.tab_to_guess.size() - 1); i >= 0; i--) {

			if ((int) my_person.tab_to_guess.get(i) < (int) my_computer.tab_try.get(i)) {
				// System.out.print(unit_try + " : ");
				System.out.print("-");
				my_computer.result.add("-");
				my_computer.max.set(i, my_computer.tab_try.get(i));
				my_computer.tab_try.set(i, (((int) my_computer.max.get(i) + (int) my_computer.min.get(i)) / 2));

			} else if ((int) my_person.tab_to_guess.get(i) > (int) my_computer.tab_try.get(i)) {
				// System.out.print(unit_try + " : ");
				System.out.print("+");
				my_computer.result.add("+");
				my_computer.min.set(i, my_computer.tab_try.get(i));
				my_computer.tab_try.set(i, (((int) my_computer.max.get(i) + (int) my_computer.min.get(i)) / 2));
			} else {
				// System.out.print(unit_try + " : ");
				System.out.print("=");
				my_computer.result.add("=");
				my_computer.max.set(i, my_computer.tab_try.get(i));
				my_computer.min.set(i, my_computer.tab_try.get(i));
				good_shot++;
			}
			if (my_computer.nb_to_guess == 0 || my_person.nb_try == 0) {
				my_computer.nb_to_guess = -1;
				my_person.nb_try = -1;
			}
		}

		System.out.println();
		if (good_shot >= calcul.nb_size(my_person.nb_to_guess)) {
			return 1;
		} else {
			return 0;
		}
	}
}
