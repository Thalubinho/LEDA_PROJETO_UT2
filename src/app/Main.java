package app;

import java.io.IOException;
import java.nio.file.*;

public class Main {
	public static void main(String[] args) {

		// Creating folders "transformations" and "sorts"
		Path path_transformations = Paths.get("transformations");
		Path path_ordinations = Paths.get("sorts");
		try {
			Files.createDirectory(path_transformations);
			Files.createDirectory(path_ordinations);
		} catch (FileAlreadyExistsException e) {
			System.err.println("The folder(s) 'transformations' and/or 'sorts' already exist");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error creating folders");
		}

		Transformations.transformationReleaseDate();
		Transformations.transformationLinux();
		Transformations.transformationPortuguese();

		// Sorts
		SortsByReleaseDate.mergeSortByReleaseDateAverageCase("games_formated_release_date.csv");
		SortsByReleaseDate.mergeSortByReleaseDateBestCase("games_release_date_mergeSort_medioCaso.csv");
		SortsByReleaseDate.mergeSortByReleaseDateWorstCase("games_formated_release_date.csv");

		SortsByReleaseDate.heapSortByReleaseDateAverageCase("games_formated_release_date.csv");
		SortsByReleaseDate.heapSortByReleaseDateBestCase("games_release_date_heapSort_medioCaso.csv");
		SortsByReleaseDate.heapSortByReleaseDateWorstCase("games_formated_release_date.csv");

	}
}
