package mastermind.fr.utils;

public class Comparatormm {
	public int challenger_tab_compar(int tab_person[], int tab_computer[]) {
		int is_placed = 0;
		int is_present = 0;
		int i = 0;
		int j = 0;
		
		while (i < tab_person.length) {
			while (j < tab_computer.length) {
				if (tab_person[i] == tab_computer[j] && i == j) {
					is_placed++;
					System.out.println("Bien placés : " + tab_person[i] );
				} else if (tab_person[i] == tab_computer[j] && i != j) {
					is_present++;
				}
				j++;
			}
			j = 0;
			i++;
		}
		
		System.out.println("Il y a " + is_present + " couleurs présentes.");
		System.out.println("Il y a " + is_placed + " couleurs bien placées.");
		
		return 0;
	}
}
