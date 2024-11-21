package app;

import execution_sorts.SortsByReleaseDate;

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

		// Sorts by Release Date
		SortsByReleaseDate.sortsReleaseDate();

		// Sorts by Prices


		// Sorts by Achievements


	}
}
