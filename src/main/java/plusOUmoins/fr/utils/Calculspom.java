package main.java.plusOUmoins.fr.utils;

import java.util.LinkedList;
import java.util.List;

import main.java.plusOUmoins.fr.players.Playerpom;

public class Calculspom {
	public int generate_divisor(int nb) {
		int divisor = 1;
		int nb_size = nb_size(nb);

		while (nb_size > 1) {
			divisor *= 10;
			nb_size--;
		}
		return divisor;
	}

	public int nb_size(int nb) {
		int nb_size = 0;
		while (nb > 0) {
			nb = nb / 10;
			nb_size++;
		}
		return nb_size;
	}

	public int find_unit(int nb) {
		return nb % 10;
	}

	public List create_tab(Playerpom player, int nb) {
		List nb_list = new LinkedList();
		int unit = 0;

		for (int i = 0; i < player.size; i++) {
			unit = find_unit(nb);
			if (nb <= 0) {
				nb_list.add(0);
			} else {
				nb_list.add(unit);
			}
			nb = (nb - unit) / 10;
		}

		return nb_list;
	}
}
