package lib.mastermind.fr.utils;

import java.util.Random;

public class Calculsmm {
	public void trans_nb_word(int value_translate) {
		Messagesmm messages = new Messagesmm();

		String colors[] = { "gris", "rouge", "vert", "bleu", "jaune", "violet" };
		int size = colors.length;

		if (value_translate <= size) {
			System.out.print(colors[value_translate]);
		} else {
			messages.fail_value();
		}
	}

	// Bug à prévoir ici.
	public int trans_word_nb(String word) {
		Messagesmm messages = new Messagesmm();

		String colors[] = { "gris", "rouge", "vert", "bleu", "jaune", "violet" };
		int size = colors.length;
		int i = 0;

		while (!word.equals(colors[i]) && i <= (size + 1)) {
			i++;
		}

		if (i <= size) {
			return i;
		} else {
			messages.fail_value();
			return 0;
		}
	}

	public int find_unit(int nb) {
		return nb % 10;
	}

	public int[] create_tab(int nb, int size) {
		int tab[] = new int[size];
		int max_index = size - 1;
		int unit = 0;
		for (int i = (size - 1); i >= 0; i--) {
			unit = find_unit(nb);
			if (nb <= 0) {
				tab[i] = 0;
			} else {
				tab[i] = unit;
			}
			nb = (nb - unit) / 10;
		}

		return tab;
	}

	public int[] create_tab_computer(int size, int limit_color) {
		int tab[] = new int[size];
		Random randomGenerator = new Random();

		for (int i = (size - 1); i >= 0; i--) {
			tab[i] = randomGenerator.nextInt(limit_color);
		}

		return tab;
	}

	public int nb_size(long nb) {
		int nb_size = 0;
		while (nb > 0) {
			nb = nb / 10;
			nb_size++;
		}
		return nb_size;
	}

	public int[] revers_tab(int tab[]) {
		int save_nb;
		int length = tab.length;
		int i = 0;

		while (tab.length / 2 < i) {
			save_nb = tab[length];
			tab[length] = tab[i];
			tab[i] = tab[length];
			i++;
			length--;
		}

		return tab;
	}

	public int[][] initialize_pos(int size, int nb) {
		int tab[][] = new int[size + 1][2];
		int a = 0;
		int unit = 0;

		for (int i = size; i > 0; i--) {
			unit = find_unit(nb);
			tab[a][0] = unit;
			tab[a][1] = a;
			nb = (nb - unit) / 10;
		}

		return tab;
	}
	
	public boolean verify_tab_try(int nb, int limit_color) {
		int size = nb_size(nb);
		int unit = 0;
		int forbid = 0;
		
		for (int i = (size - 1); i >= 0; i--) {
			unit = find_unit(nb);
			if (unit < 0 || unit >= limit_color) {
				forbid++;
			}
			nb = (nb - unit) / 10;
		}
		
		if (forbid > 0) {
			return false;
		} else {
			return true;
		}
	}
}
