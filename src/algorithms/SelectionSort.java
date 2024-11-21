package algorithms;

import static csv_io.RecordsCSV.*;
import org.apache.commons.csv.CSVRecord;

public class SelectionSort {

	public static void selectionSortReleaseDate(CSVRecord[] array) {
		int minorIndex;
		CSVRecord minor;

		for(int unsortedIndex = 0; unsortedIndex < array.length - 1; unsortedIndex++) {
			minor = array[unsortedIndex];
			minorIndex = unsortedIndex;
			for(int index = unsortedIndex; index < array.length; index++) {
				if (!compareReleaseDate(minor.get(RELEASE_DATE),array[index].get(RELEASE_DATE))) {
					minor = array[index];
					minorIndex = index;
				}				
			}			
			array[minorIndex] = array[unsortedIndex];
			array[unsortedIndex] = minor;		
		}
	}

	public static void selectionSortPrice(CSVRecord[] array) {
		int minorIndex;
		CSVRecord minor;

		for(int unsortedIndex = 0; unsortedIndex < array.length - 1; unsortedIndex++) {
			minor = array[unsortedIndex];
			minorIndex = unsortedIndex;
			for(int index = unsortedIndex; index < array.length; index++) {
				if ( !(Float.parseFloat(minor.get(PRICE)) > Float.parseFloat(array[index].get(PRICE))) ) {
					minor = array[index];
					minorIndex = index;
				}
			}
			array[minorIndex] = array[unsortedIndex];
			array[unsortedIndex] = minor;
		}
	}

	public static void selectionSortAchievements(CSVRecord[] array) {
		int minorIndex;
		CSVRecord minor;

		for(int unsortedIndex = 0; unsortedIndex < array.length - 1; unsortedIndex++) {
			minor = array[unsortedIndex];
			minorIndex = unsortedIndex;
			for(int index = unsortedIndex; index < array.length; index++) {
				if ( !(Integer.parseInt(minor.get(ACHIEVEMENTS)) > Integer.parseInt(array[index].get(ACHIEVEMENTS))) ) {
					minor = array[index];
					minorIndex = index;
				}
			}
			array[minorIndex] = array[unsortedIndex];
			array[unsortedIndex] = minor;
		}
	}

}
