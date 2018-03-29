package main.java;

import java.util.Scanner;

import lib.main.Config;
import main.java.mastermind.fr.main.Mastermind;
import main.java.plusOUmoins.fr.main.Plusoumoins;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Plusoumoins party_pom = new Plusoumoins();
		Mastermind party_mm = new Mastermind();
		int start = 1;
		int game = 0;

		try {
			Config config = new Config();
			config.dev = 0;
			if (config.limit_color >= 4 && config.limit_color <= 10 && config.nb_case <= 8) {
				while (config.dev != 1 && config.dev != 2) {
					System.out.print("Voulez-vous être en mode développeur ? (1 = Oui, 2 = Non) : ");
					config.dev = sc.nextInt();
				}

				try {
					while (start == 1) {
						System.out.println("==============================");
						System.out.println("1 - Plus ou moins");
						System.out.println("2 - Mastermind");
						System.out.print("Sélectionne le jeu auquel tu souhaites jouer : ");
						game = sc.nextInt();

						if (game == 1) {
							party_pom.Plusoumoins(config);
						} else if (game == 2) {
							party_mm.Mastermind(config);
						} else {
							System.out.println("La valeur que vous avez entré semble incorrecte...");
						}
						System.out.print("Voulez-vous rejouer (1 pour oui, 0 pour non) : ");
						start = sc.nextInt();
					}
				} catch (Exception e) {
					// OK
					System.out.println("La valeur que vous avez entré semble incorrecte...");
				}

			} else {
				System.out.println("Un problème s'est produit dans le fichier de configuration, vérifiez les valeurs indiquées");
			}
		} catch (Exception e) {
			System.out.println("Un problème s'est produit... (Avez-vous entré une valeur incorrecte ?)");
		}

		System.out.println("Au revoir !");
		sc.close();
	}

}
