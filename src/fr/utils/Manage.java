package fr.utils;

import java.util.Scanner;

import fr.players.Computer;
import fr.players.Person;
import fr.players.Player;
import fr.utils.*;
	
public class Manage {
	public void challenger(int mode) {
		Calculs calcul = new Calculs();
		Comparator compar = new Comparator();
		Person my_person = new Person();
		Computer my_computer = new Computer();
		int win = 0;
		
		my_computer.nb_to_guess = my_computer.generate_nb();
		
		while (win == 0) {
			System.out.print("Choisi un nombre contenant " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres : ");
			Scanner sc = new Scanner(System.in);
			my_person.nb_try = sc.nextInt();
			if (calcul.nb_size(my_computer.nb_to_guess) >= calcul.nb_size(my_person.nb_try)) {
				win = compar.compar_numbers(my_computer, my_person);
				my_person.shots++;
			} else {
				System.out.println("Le nombre doit contenir " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres !");
			}
		}
		System.out.println("Code dévérouillé en " + my_person.shots + " coups, bravo !");
	}
	
	public void defender(int mode) {
		Person my_person = new Person();
		Computer my_computer = new Computer();
		int win = 0;
		
		System.out.print("Choisi le nombre à faire deviner : ");
		Scanner sc = new Scanner(System.in);
		
		my_person.nb_to_guess = sc.nextInt();
		
		while (win == 0) {
			
		}
	}
	
	public void dual(int mode) {
		
	}
}
