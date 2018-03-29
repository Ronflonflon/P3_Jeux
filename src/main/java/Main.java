package main.java;

import java.util.Scanner;

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
		int dev = 0;
		int start = 1;
		int game = 0;

		Properties prop = new Properties();
		InputStream input = null;
		String filename = "C:/Users/fabien/eclipse-workspace/p3_jeux/src/resources/config.properties";

		while (dev != 1 && dev != 2) {
			System.out.print("Voulez-vous être en mode développeur ? (1 = Oui, 2 = Non) : ");
			dev = sc.nextInt();
		}

		while (start == 1) {
			System.out.println("==============================");
			System.out.println("1 - Plus ou moins");
			System.out.println("2 - Mastermind");
			System.out.print("Sélectionne le jeu auquel tu souhaites jouer : ");

			try {
				input = new FileInputStream(filename);
				prop.load(input);
				game = sc.nextInt();

				if (game == 1) {
					party_pom.Plusoumoins(dev);
				} else if (game == 2) {
					party_mm.Mastermind(dev);
				} else {
					System.out.println("La valeur que vous avez entré semble incorrecte...");
				}
				System.out.print("Voulez-vous rejouer (1 pour oui, 0 pour non) : ");
				start = sc.nextInt();
				// TODO Remplacer toutes les exceptions par Exception e
			} catch (IOException e1) {
				System.out.println("Le chargement des configurations a rencontrée un problème...");
			} catch (Exception e) {
				// OK
				System.out.println("La valeur que vous avez entré semble incorrecte...");
			}
		}

		System.out.println("Au revoir !");
		sc.close();
	}

}
