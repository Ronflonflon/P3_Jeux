package plusOUmoins.fr.main;

import java.util.Scanner;

import plusOUmoins.fr.utils.Gamepom;
import plusOUmoins.fr.utils.Messagespom;

public class Plusoumoins {
	public void Plusoumoins(int dev) {
		int start = 1;
		int mode;
		Scanner sc = new Scanner(System.in);
		Gamepom manager = new Gamepom();
		Messagespom message = new Messagespom();
		
		System.out.println("============ Plus ou moins ============");
			while (start == 1) {
				try {
					message.choose_mod();
					mode = sc.nextInt();
					if (mode == 1) {
						manager.challenger_pom(dev);
					} else if (mode == 2) {
						manager.defender_pom(dev);
					} else if (mode == 3) {
						manager.dual_pom(dev);
					} else {
						message.fail_value();
						mode = 0;
					}
				} catch (Exception e) {
					message.fail_value();
				}
				try {
					message.restart_game();
					start = sc.nextInt();
				} catch (Exception e) {
					message.fail_value();
					start = 0;
				}
			}
			sc.close();
			message.end_game();
	}
}
