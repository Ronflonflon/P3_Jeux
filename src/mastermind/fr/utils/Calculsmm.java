package mastermind.fr.utils;

public class Calculsmm {
	public void trans_nb_word (int value_translate) {
		Messagesmm messages = new Messagesmm();
		
		String colors [] = {"gris", "rouge", "vert", "bleu", "jaune", "violet"};
		int size = colors.length;
		
		if (value_translate <= size) {
			System.out.print(colors[value_translate]);
		} else {
			messages.fail_value();
		}
	}
	
	
	// Bug à prévoir ici.
	public int trans_word_nb (String word) {
		Messagesmm messages = new Messagesmm();
		
		String colors [] = {"gris", "rouge", "vert", "bleu", "jaune", "violet"};
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
	
	public int find_unit (int nb) {
		return nb % 10;
	}
	
	public int[] create_tab (int nb, int size) {
		int tab[] = new int[size];
		int unit = 0;
		
		for (int i = 0; i < size; i++) {
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
	
	public int nb_size (int nb) {
		int nb_size = 0;
		while (nb > 0) {
			nb = nb / 10;
			nb_size++;
		}
		return nb_size;
	}
}
