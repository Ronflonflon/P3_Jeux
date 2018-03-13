package fr.utils;

import java.util.Scanner;

import fr.players.Computer;
import fr.players.Person;
	
public class Game {
	public int challenger(int mode) {
		Calculs calcul = new Calculs();
		Comparator compar = new Comparator();
		Person my_person = new Person();
		Computer my_computer = new Computer();
		Scanner sc = new Scanner(System.in);
		int win = 0;
		
		System.out.print("Choisi la taille du nombre à deviner : ");
		my_computer.size = sc.nextInt();
		my_computer.nb_to_guess = my_computer.generate_nb_to_guess(my_computer.size);
		my_computer.size = calcul.nb_size(my_computer.nb_to_guess);
		
		while (win == 0) {
			System.out.print("Choisi un nombre contenant " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres : ");
			my_person.nb_try = sc.nextInt();
			if (calcul.nb_size(my_computer.nb_to_guess) >= calcul.nb_size(my_person.nb_try)) {
				win = compar.compar_numbers_challenger(my_computer, my_person, mode);
				my_person.shots++;
			} else {
				System.out.println("Le nombre doit contenir " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres !");
			}
		}
		
		System.out.println("Code dévérouillé en " + my_person.shots + " coups, bravo !");
		return win;
	}
	
	public int defender(int mode) {
		Person my_person = new Person();
		Calculs calcul = new Calculs();
		Comparator compar = new Comparator();
		Scanner sc = new Scanner(System.in);
		int win = 0;
		
		System.out.print("Choisi le nombre à faire deviner : ");
		my_person.nb_to_guess = sc.nextInt();
		Computer my_computer = new Computer();
		my_computer.size = my_person.size = calcul.nb_size(my_person.nb_to_guess);
		my_person.tab_to_guess = calcul.create_tab(my_person, my_person.nb_to_guess, mode);
		
		my_computer = my_computer.initialize_compute_tabs(my_computer);
		
		System.out.println(my_computer.tab_try.get(0));
		while (win == 0) {
			win = compar.compar_numbers_defender(my_computer, my_person, mode);
			my_computer.shots++;
		}
		
		System.out.println("L'ordinateur a trouvé la combinaison en " + my_computer.shots + " coups !");
		
		return win;
	}
	
	public int dual(int mode) {
		Calculs calcul = new Calculs();
		Comparator compar = new Comparator();
		Person my_person = new Person();
		Computer my_computer = new Computer();
		Scanner resp = new Scanner (System.in);
		Scanner sc = new Scanner(System.in);
		int win_person = 0;
		int win_computer = 0;
		
		System.out.print("Choisi le nombre à faire deviner : ");
		my_person.nb_to_guess = sc.nextInt();
		my_computer.size = my_person.size = calcul.nb_size(my_person.nb_to_guess);
		my_person.tab_to_guess = calcul.create_tab(my_person, my_person.nb_to_guess, mode);
		my_computer = my_computer.initialize_compute_tabs(my_computer);
		
		my_computer.nb_to_guess = my_computer.generate_nb_to_guess(my_person.size);
		System.out.println("Nb ordi : " + my_computer.nb_to_guess);
		
		while (win_person == 0 && win_computer == 0) {
			System.out.print("Choisi un nombre contenant " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres : ");
			my_person.nb_try = resp.nextInt();
			if (calcul.nb_size(my_computer.nb_to_guess) >= calcul.nb_size(my_person.nb_try)) {
				System.out.print("Resultat joueur : ");
				win_person = compar.compar_numbers_challenger(my_computer, my_person, mode);
				my_person.shots++;
			} else {
				System.out.println("Le nombre doit contenir " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres !");
			}
			System.out.print("Résultat ordinateur : ");
			win_computer = compar.compar_numbers_defender(my_computer, my_person, mode);
			my_computer.shots++;
		}
		
		if (win_person == 1 && win_computer == 1) {
			System.out.println("Egalité !");
		} else if (win_computer == 1){
			System.out.println("L'ordinateur a gagné cette partie en " + my_computer.shots + " coups !");
		} else if (win_person == 1){
			System.out.println("Tu as a gagné cette partie en " + my_computer.shots + " coups !");
		}
		
		return 0;
}
}
