package fr.players;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import fr.utils.Calculs;

public class Computer extends Player {
	public List min;
	public List max;
	public List result;
	
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
	
	public Computer initialize_compute_tabs (Computer my_computer) {
		int moyenne = 5;
		int min = 0;
		int max = 10;
		my_computer.tab_try = new LinkedList();
		my_computer.min = new LinkedList();
		my_computer.max = new LinkedList();
		my_computer.result = new LinkedList();

		for (int i = 0; i < my_computer.size; i++) {;
			my_computer.tab_try.add(moyenne);
		}
		for (int i = 0;  i < my_computer.size; i++) {
			my_computer.min.add(min);
		}
		for (int i = 0; i < my_computer.size; i++) {
			my_computer.max.add(max);
		}
		
		return my_computer;
	}
}
