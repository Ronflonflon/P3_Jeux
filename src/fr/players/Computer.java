package fr.players;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import fr.utils.Calculs;

public class Computer extends Player {
	public List min = new LinkedList();
	public List max = new LinkedList();
	public List result = new LinkedList();
	
	public int generate_nb() {
		Random randomGenerator = new Random();
		int nb = 0;
		
		while (nb < 1000) {
			nb = randomGenerator.nextInt(10000);
		}
		return nb;
	}
	
	public Computer actualize_list(Computer list, int initialize) {
		Calculs calcul = new Calculs();
		int moyenne = 5555;
		
		if (initialize == 0) {
			//list.tab_try = calcul.create_tab(this);
			//list.min = calcul.create_tab(0000);
			
		} else {
			
		}
		return list;
	}
}
