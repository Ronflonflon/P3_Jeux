package mastermind.fr.main;

import java.util.Scanner;

import mastermind.fr.utils.Gamemm;
import mastermind.fr.utils.Messagesmm;

public class Mastermind {
	public void Mastermind(int admin) {
		Scanner sc = new Scanner(System.in);
		Gamemm manager = new Gamemm();
		Messagesmm messages = new Messagesmm();
		int mode;
		int start = 1;
		
		System.out.println("============= Mastermind =============");
		
		while (start == 1) {
			//try {
				messages.choose_mod();
				mode = sc.nextInt();
				if (mode == 1) {
					manager.challenger_mm(mode);
				} else if (mode == 2) {
					manager.defender_mm(mode);
				} else if (mode == 3) {
					manager.dual_mm(mode);
				} else {
					System.out.println("EE");
					messages.fail_value();
					mode = 0;
				}
			/*} catch (Exception e) {
				System.out.println("EEE");
				messages.fail_value();
			}*/
			try {
				messages.restart_game();
				start = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Valeur start : " + start);
				messages.fail_value();
				start = 0;
			}
		}
		sc.close();
		messages.end_game();
	}
}
