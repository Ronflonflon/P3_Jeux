package fr.utils;

import java.util.LinkedList;
import java.util.List;
import fr.players.*;
import fr.utils.Calculs;

public class Comparator {
	int compar_numbers_challenger (Computer my_computer, Person my_person, int mode) {
		int good_shot = 0;
		Calculs calcul = new Calculs();
		
		my_person.size = calcul.nb_size(my_computer.nb_to_guess);
		my_computer.size = calcul.nb_size(my_computer.nb_to_guess);
		my_computer.tab_to_guess = 	calcul.create_tab(my_computer, my_computer.nb_to_guess, mode);
		my_person.tab_try = calcul.create_tab(my_person, my_person.nb_try, mode);
		
		for (int i = (my_computer.tab_to_guess.size() - 1); i >= 0 ; i--) {
			if ((int) my_computer.tab_to_guess.get(i) < (int) my_person.tab_try.get(i)) {
				//System.out.print(unit_try + " : ");
				System.out.print("-");
			} else if ((int) my_computer.tab_to_guess.get(i) > (int) my_person.tab_try.get(i)) {
				//System.out.print(unit_try + " : ");
				System.out.print("+");
			} else {
				//System.out.print(unit_try + " : ");
				System.out.print("=");
				good_shot++;
			}
			if (my_computer.nb_to_guess == 0 || my_person.nb_try == 0) {
				my_computer.nb_to_guess = -1;
				my_person.nb_try = -1;
			}
		}
		System.out.println();
		
		if(good_shot >= calcul.nb_size(my_computer.nb_to_guess)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	int compar_numbers_defender (Computer my_computer, Person my_person, int mode) {
		int good_shot = 0;
		Calculs calcul = new Calculs();
		
		my_person.size = calcul.nb_size(my_computer.nb_to_guess);
		my_computer.size = calcul.nb_size(my_computer.nb_to_guess);
		
		//System.out.println("Nb to guess" + my_person.tab_to_guess.get(0));
		
		for (int i = (my_person.tab_to_guess.size() - 1); i >= 0 ; i--) {
			
			if ((int) my_person.tab_to_guess.get(i) < (int) my_computer.tab_try.get(i)) {
				//System.out.print(unit_try + " : ");
				System.out.print("-");
				my_computer.result.add("-");
				my_computer.max.set(i, my_computer.tab_try.get(i));
				my_computer.tab_try.set(i, (((int) my_computer.max.get(i) + (int) my_computer.min.get(i)) / 2));
				
			} else if ((int) my_person.tab_to_guess.get(i) > (int) my_computer.tab_try.get(i)) {
				//System.out.print(unit_try + " : ");
				System.out.print("+");
				my_computer.result.add("+");
				my_computer.min.set(i, my_computer.tab_try.get(i));
				my_computer.tab_try.set(i, (((int) my_computer.max.get(i) + (int) my_computer.min.get(i)) / 2));
				} else {
				//System.out.print(unit_try + " : ");
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
		if(good_shot >= calcul.nb_size(my_person.nb_to_guess)) {
			return 1;
		} else {
			return 0;
		}
	}
}
