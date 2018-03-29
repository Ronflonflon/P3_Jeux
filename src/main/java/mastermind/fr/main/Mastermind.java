package main.java.mastermind.fr.main;

import java.util.Scanner;

import lib.main.Config;
import lib.mastermind.fr.utils.Messagesmm;

public class Mastermind {
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
				manager.challenger_mm(config);
			} else if (mode == 2) {
				manager.defender_mm(config);
			} else if (mode == 3) {
				manager.dual_mm(config);
			} else {
				messages.fail_value();
				mode = 0;
			}
		} catch (Exception e) {
			System.out.println("EEE");
			messages.fail_value();

		}
	}
}
