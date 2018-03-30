package main.java.mastermind.fr.utils;

import java.util.Random;

public class Calculsmm {
	/**
	 * Trouve l'unité d'un nombre donné
	 * 
	 * @param nb
	 * @return int Renvoie l'unité du nombre entré
	 */
	public int find_unit(int nb) {
		return nb % 10;
	}

	/**
	 * Créer des tableaux. C'est dans ces tableaux que sont stockées les
	 * combinaisons à deviner et les tentatives.
	 * 
	 * @param nb
	 * @param size
	 * @return int[]
	 */
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

	/**
	 * Créer un tableau à deviner pour l'ordinateur en respectant les limites
	 * imposées dans le fichier de config
	 * 
	 * @param size
	 * @param limit_color
	 * @return int[]
	 */
	public int[] create_tab_computer(int size, int limit_color) {
		int tab[] = new int[size];
		Random randomGenerator = new Random();

		for (int i = (size - 1); i >= 0; i--) {
			tab[i] = randomGenerator.nextInt(limit_color);
		}

		return tab;
	}

	/**
	 * Trouve la taille d'un nombre, ex : 1000 = 4
	 * 
	 * @param nb
	 * @return int
	 */
	public int nb_size(long nb) {
		int nb_size = 0;
		while (nb > 0) {
			nb = nb / 10;
			nb_size++;
		}
		return nb_size;
	}

	/**
	 * Inverse le sens d'un tableau
	 * 
	 * @param tab
	 * @return int[]
	 */
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

	/**
	 * Vérifie que chaque valeur entrée par le joueur est autorisée par le fichier
	 * de config
	 * 
	 * @param nb
	 * @param limit_color
	 * @return boolean Return "C'est bon, il respecte" ou "Non, il ne respecte pas"
	 */
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
