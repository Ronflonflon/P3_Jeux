package fr.players;

import java.util.LinkedList;
import java.util.List;

public class Player {
	public int nb_to_guess;
	public int nb_try;
	public int size;
	public int shots;
	public List tab_try;
	public List tab_to_guess;
	
	public Player() {
		shots = 0;
	}
}
