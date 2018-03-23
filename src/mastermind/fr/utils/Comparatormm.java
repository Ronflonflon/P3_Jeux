package mastermind.fr.utils;

import java.util.LinkedList;
import java.util.List;

public class Comparatormm {
	public int challenger_tab_compar(int tab_person[], int tab_computer[]) {
		int is_placed = 0;
		int is_present = 0;
		int i = 0;
		int j = 0;
		int actual = 0;
		int limit = 0;
		int tab_placed[] = new int[tab_person.length];
		int tab_present[] = new int[tab_person.length];
		
		while (i < tab_person.length) {
			while (j < tab_computer.length) {
				if (tab_person[i] == tab_computer[j] && i == j) {
					//System.out.println("=> Correspondent : " + tab_person[j] + " et " + tab_computer[j] + " i = "+ i + " j = " + j);
					is_placed++;
					
					tab_placed[j] = tab_computer[j];
					is_present = 0;
			//		System.out.println("Moins 1 ! is present = " + is_present);
				} else if (tab_person[i] == tab_computer[j] && i != j) {
					tab_present[j] = tab_computer[j];
					is_present++;
					//System.out.println("Correspondent : " + tab_person[j] + " et " + tab_computer[j] + " i = "+ i + " j = " + j);
					if (tab_placed[j] == tab_present[j]) {	
						is_present--;
					//System.out.println("Moins 2 ! is present = " + is_present);
					}
				}
				j++;
			}
			j = 0;
			i++;
		}
		
		for (int a = 0; a < tab_placed.length; a++) {
			//System.out.println("Tab placed : " + tab_placed[a]);
		}
		
		System.out.println("Il y a " + is_present + " couleurs présentes.");
		System.out.println("Il y a " + is_placed + " couleurs bien placées.");

		if (tab_computer.length == is_placed) {
			return 1;
		} else {
			return 0;
		}
	}
}
