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
}
