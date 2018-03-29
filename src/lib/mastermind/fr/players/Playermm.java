package lib.mastermind.fr.players;

public class Playermm {
	public int nb_to_guess;
	public int nb_try;
	public int tab_try [];
	public int tab_to_guess[];
	public int size_try;
	public int size_to_guess;
	public int shots;
	public boolean win;
	
	public int nb_size (int nb) {
		int nb_size = 0;
		while (nb > 0) {
			nb = nb / 10;
			nb_size++;
		}
		return nb_size;
	}
}
