package main.java.plusOUmoins.fr.start;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.Config;
import main.java.Main;
import main.java.plusOUmoins.fr.utils.Messagespom;

public class Plusoumoins {
	private static final Logger logger = LogManager.getLogger(Main.class.getName());

	public void Plusoumoins(Config config) {
		int mode;
		Scanner sc = new Scanner(System.in);
		Gamepom manager = new Gamepom();
		Messagespom message = new Messagespom();

		System.out.println("============ Plus ou moins ============");
		try {
			message.choose_mod();
			mode = sc.nextInt();
			if (mode == 1) {
				logger.trace("Mode choisi : Challenger");
				manager.challenger_pom(config);
			} else if (mode == 2) {
				logger.trace("Mode choisi : Defender");
				manager.defender_pom(config);
			} else if (mode == 3) {
				logger.trace("Mode choisi : Dual");
				manager.dual_pom(config);
			} else {
				logger.trace("Problème dans la valeur du mode choisi : " + mode);
				message.fail_value();
				mode = 0;
			}
		} catch (Exception e) {
			message.fail_value();
		}
	}
}
