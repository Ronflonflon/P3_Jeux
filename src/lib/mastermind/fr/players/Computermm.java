package lib.mastermind.fr.players;

import java.util.Random;

public class Computermm extends Playermm {
	public int last_try[];
	public int proba_result[][];
	public int count_present;
	public int count_placed;
	public int last_present;
	public int last_placed;
	public int position;
	int i = 0;

	public Computermm generate_tab_try(Computermm my_computer) {
		int i = 0;
		
		if (my_computer.count_placed < my_computer.last_placed) {
			while (my_computer.tab_try[i] == my_computer.last_try[i] && i < my_computer.tab_try.length) {
				i++;
			}
			proba_result[i][my_computer.last_try[i]] = 1;
			my_computer.position--;
		} else if (my_computer.count_placed > my_computer.last_placed) {
			while (my_computer.tab_try[i] == my_computer.last_try[i] && i < (my_computer.tab_try.length - 1)) {
				i++;
			}
			proba_result[i][my_computer.tab_try[i]] = 1;
			my_computer.position--;
		} else {
			my_computer.tab_try[my_computer.position]++; 
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
