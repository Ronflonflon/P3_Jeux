package main.java;

import java.util.Scanner;

import main.java.mastermind.fr.start.Mastermind;
import main.java.plusOUmoins.fr.start.Plusoumoins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class.getName());
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Plusoumoins party_pom = new Plusoumoins();
		Mastermind party_mm = new Mastermind();
		Messages message = new Messages();
		int start = 1;
		int game = 0;
		
		
		logger.trace("Entré dans le jeu");
		
		try {
			Config config = new Config();
			if ((config.limit_color >= 4 && config.limit_color <= 10) && (config.nb_case <= 8 && config.nb_case >= 4)) {
				logger.trace("Mode développer choisi : " + config.dev);
				
				try {
					while (start == 1) {
						message.choose_game();
						game = sc.nextInt();
						
						if (game == 1) {
							logger.trace("Jeu choisi : plus ou moins");
							party_pom.Plusoumoins(config);
						} else if (game == 2) {
							logger.trace("Jeu choisi : mastermind");
							party_mm.Mastermind(config);
						} else {
							logger.trace("Une valeur entrée est incorrecte, game = " + game);
							message.fail_value();
						}
						System.out.print("Voulez-vous rejouer (1 pour oui, 0 pour non) : ");
						start = sc.nextInt();
					}
				} catch (ClassCastException e) {
					logger.trace("Une valeur entrée est incorrecte");
					message.fail_value();
				}

			} else {
				System.out.println("Un problème s'est produit dans le fichier de configuration, vérifiez les valeurs indiquées");
			}
		} catch (ClassCastException e) {
			logger.trace("Une valeur entrée est incorrecte");
			message.fail_value();
		}

		System.out.println("Au revoir !");
		sc.close();
	}

}
