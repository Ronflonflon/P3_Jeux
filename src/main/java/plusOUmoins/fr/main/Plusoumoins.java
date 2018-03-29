package main.java.plusOUmoins.fr.main;

import java.util.Scanner;

import lib.main.Config;
import lib.plusOUmoins.fr.utils.Messagespom;

public class Plusoumoins {
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
				manager.challenger_pom(config);
			} else if (mode == 2) {
				manager.defender_pom(config);
			} else if (mode == 3) {
				manager.dual_pom(config);
			} else {
				message.fail_value();
				mode = 0;
			}
		} catch (Exception e) {
			message.fail_value();
		}
	}
}
