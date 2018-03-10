package fr.utils;

import java.util.Scanner;

import fr.players.Computer;
import fr.players.Person;
import fr.players.Player;
import fr.utils.*;
	
public class Game {
	public int challenger(int mode) {
		Calculs calcul = new Calculs();
		Comparator compar = new Comparator();
		Person my_person = new Person();
		Computer my_computer = new Computer();
		int win = 0;
		
		my_computer.nb_to_guess = my_computer.generate_nb();
		my_computer.size = calcul.nb_size(my_computer.nb_to_guess);
		
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
		return win;
	}
	
	public void defender(int mode) {
		Person my_person = new Person();
		Calculs calcul = new Calculs();
		Comparator compar = new Comparator();
		int win = 0;
		
		System.out.print("Choisi le nombre à faire deviner : ");
		Scanner sc = new Scanner(System.in);
		Computer my_computer = new Computer();
		int min = 0;
		int max = 9;
		int moyenne = 5;
		my_person.nb_to_guess = sc.nextInt();
		my_person.tab_to_guess = calcul.create_tab(my_person, my_person.nb_to_guess);
		my_person.size = calcul.nb_size(my_person.nb_to_guess);
		my_computer.size = my_person.size;
		
		//my_computer.tab_try = calcul.create_tab(my_computer, nb);
		
		while (win == 0) {
			if (calcul.nb_size(my_computer.nb_to_guess) >= calcul.nb_size(my_person.nb_try)) {
				win = compar.compar_numbers(my_computer, my_person);
				my_person.shots++;
			} else {
				System.out.println("Le nombre doit contenir " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres !");
			}
		}
	}
	
	public void dual(int mode) {
		
	}
}
