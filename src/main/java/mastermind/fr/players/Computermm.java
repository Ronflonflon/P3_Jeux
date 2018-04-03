package main.java.mastermind.fr.players;

import java.util.Random;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingUse;

public class Computermm extends Playermm {
	public int last_try[];
	public int proba_result[][];
	public int count_present;
	public int count_placed;
	public int last_present;
	public int last_placed;
	public int position;
	public boolean first_start;
	int i = 0;

	public Computermm generate_tab_try(Computermm my_computer, Personmm my_person) {
		int i = 0;

		/*
		 * for (int a = 0; a < my_computer.tab_try.length; a++) {
		 * System.out.println("a = " + a + " Valeur : " + my_computer.tab_try[a]); }
		 */
		//System.out.println(my_computer.count_placed + " et " + my_computer.last_placed);
		if (my_computer.count_placed < my_computer.last_placed || my_computer.count_placed > my_computer.last_placed) {
			while (i < my_computer.tab_try.length && my_computer.tab_try[i] == my_computer.last_try[i]) {
				// System.out.println("a = " + i + " tab_try = " + my_computer.tab_try[i] + " et
				// " + my_computer.last_try[i]);
				i++;
			}
			i--;
			//System.out.println("On entre");
			proba_result[i][my_computer.last_try[i]] = 1;
			my_computer.position--;
		} else {
			if (my_computer.first_start == true 
					&& my_computer.tab_try[my_computer.tab_try.length - 1] == my_person.tab_to_guess[my_person.tab_to_guess.length - 1]) {
				proba_result[my_computer.tab_try.length - 1][my_computer.last_try[my_computer.tab_try.length - 1]] = 1;
				my_computer.position--;
			}
			my_computer.tab_try[my_computer.position]++;
			//System.out.println("Par là = " + my_computer.position);
		}

		return my_computer;
	}

	public int[][] initialize_proba(int size, int limit) {
		int proba[][] = new int[size][limit];
		int i = 0;

		while (i < size) {
			for (int j = 0; j < limit; j++) {
				proba[i][j] = 0;
			}
			i++;
		}

		return proba;
	}

	public int[] initialize_result(int size) {
		int i = 0;
		int tab[] = new int[size];
		int limite = size;

		while (i < size) {
			tab[i] = 0;
			i++;
		}
		/*
		 * if (size % 2 == 1) { limite = limite + 1; } else { //NTD }
		 * 
		 * while (i < size) { if(i < (limite / 2)) { tab[i] = 0; } else { tab[i] = 1; }
		 * i++; }
		 */

		return tab;
	}

	public int[] generate_result(int actual_result[], int last_result[], int proba_result[]) {

		return actual_result;
	}

	public int generate_nb_to_guess(int size) {
		Random randomGenerator = new Random();
		int nb = 0;
		int min = 1;
		int max = 1;

		while (size > 1) {
			min *= 10;
			max *= 10;
			size--;
		}
		max *= 10;

		while (nb < min) {
			nb = randomGenerator.nextInt(max);
		}
		return nb;
	}
}
