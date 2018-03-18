package plusOUmoins.fr.utils;

import java.util.Scanner;

import plusOUmoins.fr.players.Computerpom;
import plusOUmoins.fr.players.Personpom;

public class Gamepom {
	public int challenger_pom(int mode) {
		Calculspom calcul = new Calculspom();
		Comparatorpom compar = new Comparatorpom();
		Personpom my_person = new Personpom();
		Computerpom my_computer = new Computerpom();
		Scanner sc = new Scanner(System.in);
		int win = 0;

		try {
			System.out.print("Choisi la taille du nombre à deviner : ");
			my_computer.size = sc.nextInt();
			if (my_computer.size <= 0) {
				System.out.println("La taille " + my_computer.size + " n'est pas valide...");
			} else {
				my_computer.nb_to_guess = my_computer.generate_nb_to_guess(my_computer.size);
				my_computer.size = calcul.nb_size(my_computer.nb_to_guess);
		
				while (win == 0) {
					System.out.print("Choisi un nombre contenant " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres : ");
					my_person.nb_try = sc.nextInt();
					if (calcul.nb_size(my_computer.nb_to_guess) >= calcul.nb_size(my_person.nb_try)) {
						win = compar.compar_numbers_challenger(my_computer, my_person, mode);
						my_person.shots++;
					} else {
						System.out
								.println("Le nombre doit contenir " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres !");
					}
				}
		
				System.out.println("Code dévérouillé en " + my_person.shots + " coups, bravo !");
			}
		} catch (Exception e) {
			System.out.println("La valeur que vous avez entré semble incorrecte...");
		}
		return win;
	}

	public int defender_pom(int mode) {
		Personpom my_person = new Personpom();
		Calculspom calcul = new Calculspom();
		Comparatorpom compar = new Comparatorpom();
		Scanner sc = new Scanner(System.in);
		int win = 0;

		try {
			System.out.print("Choisi le nombre à faire deviner : ");
			my_person.nb_to_guess = sc.nextInt();
			
			if (my_person.nb_to_guess <= 0) {
				System.out.println("Le nombre ne peut pas être " + my_person.nb_to_guess + ", il doit être supérieur à 0");
			} else {
				Computerpom my_computer = new Computerpom();
				my_computer.size = my_person.size = calcul.nb_size(my_person.nb_to_guess);
				my_person.tab_to_guess = calcul.create_tab(my_person, my_person.nb_to_guess, mode);
		
				my_computer = my_computer.initialize_compute_tabs(my_computer);
		
				while (win == 0) {
					win = compar.compar_numbers_defender(my_computer, my_person, mode);
					my_computer.shots++;
				}
		
				System.out.println("L'ordinateur a trouvé la combinaison en " + my_computer.shots + " coups !");
			}
		} catch (Exception e) {
			System.out.println("La valeur que vous avez entré semble incorrecte...");
		}
		return win;
	}

	public int dual_pom(int mode) {
		Calculspom calcul = new Calculspom();
		Comparatorpom compar = new Comparatorpom();
		Personpom my_person = new Personpom();
		Computerpom my_computer = new Computerpom();
		Scanner resp = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int win_person = 0;
		int win_computer = 0;

		try {
			System.out.print("Choisi le nombre à faire deviner : ");
			my_person.nb_to_guess = sc.nextInt();
			if (my_person.nb_to_guess <= 0) {
				System.out.println("Le nombre ne peut pas être " + my_person.nb_to_guess + ", il doit être supérieur à 0");
			} else {
				my_computer.size = my_person.size = calcul.nb_size(my_person.nb_to_guess);
				my_person.tab_to_guess = calcul.create_tab(my_person, my_person.nb_to_guess, mode);
				my_computer = my_computer.initialize_compute_tabs(my_computer);
		
				my_computer.nb_to_guess = my_computer.generate_nb_to_guess(my_person.size);
				System.out.println("Nb ordi : " + my_computer.nb_to_guess);
		
				while (win_person == 0 && win_computer == 0) {
					System.out.print("Choisi un nombre contenant " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres : ");
					my_person.nb_try = resp.nextInt();
					if (my_person.nb_try <= 0) {
						System.out.println("Le nombre ne peut pas être " + my_person.nb_try + ", il doit être supérieur à 0");
					} else {
						if (calcul.nb_size(my_computer.nb_to_guess) >= calcul.nb_size(my_person.nb_try)) {
							System.out.print("Resultat joueur : ");
							win_person = compar.compar_numbers_challenger(my_computer, my_person, mode);
							my_person.shots++;
						} else {
							System.out
									.println("Le nombre doit contenir " + calcul.nb_size(my_computer.nb_to_guess) + " chiffres !");
						}
						System.out.print("Résultat ordinateur : ");
						win_computer = compar.compar_numbers_defender(my_computer, my_person, mode);
						my_computer.shots++;
					}
				}
		
				if (win_person == 1 && win_computer == 1) {
					System.out.println("Egalité !");
				} else if (win_computer == 1) {
					System.out.println("L'ordinateur a gagné cette partie en " + my_computer.shots + " coups !");
				} else if (win_person == 1) {
					System.out.println("Tu as a gagné cette partie en " + my_computer.shots + " coups !");
				}
			}
		} catch (Exception e) {
			System.out.println("La valeur que vous avez entré semble incorrecte...");
		}
		return 0;
	}
}
