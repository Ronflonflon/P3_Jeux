package mastermind.fr.players;

import java.util.Random;

public class Computermm extends Playermm {
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
