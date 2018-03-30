package main.java.mastermind.fr.start;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.Config;
import main.java.Main;
import main.java.mastermind.fr.utils.Messagesmm;

public class Mastermind {
	private static final Logger logger = LogManager.getLogger(Main.class.getName());

	/**
	 * Envoie dans le mode de jeu correspondant au souhait de l'utilisateur
	 * 
	 * @param config
	 *            Contient les infos sur le dossier de config et le mode dev (ou
	 *            non) de l'utilisateur
	 * @return void
	 */
	public void Mastermind(Config config) {
		Scanner sc = new Scanner(System.in);
		Gamemm manager = new Gamemm();
		Messagesmm messages = new Messagesmm();
		int mode;
		int start = 1;

		System.out.println("============= Mastermind =============");

		try {
			messages.choose_mod();
			mode = sc.nextInt();
			if (mode == 1) {
				logger.trace("Mode choisi : Challenger");
				manager.challenger_mm(config);
			} else if (mode == 2) {
				logger.trace("Mode choisi : Defender");
				manager.defender_mm(config);
			} else if (mode == 3) {
				logger.trace("Mode choisi : Dual");
				manager.dual_mm(config);
			} else {
				logger.trace("Problème dans la valeur du mode choisi : " + mode);
				messages.fail_value();
				mode = 0;
			}
		} catch (Exception e) {
			messages.fail_value();

		}
	}
}
