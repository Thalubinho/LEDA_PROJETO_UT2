package execution_sorts;

import algorithms.*;
import csv_io.RecordsCSV;

public class SortsByReleaseDate {

    private static void mergeSortByReleaseDateAverageCase() {
        // Initializing variable
        RecordsCSV recordsCSV = new RecordsCSV("transformations", "games_formated_release_date.csv");

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        MergeSortRecordArray.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_mergeSort_medioCaso.csv");
    }

	private static void mergeSortByReleaseDateBestCase() {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_mergeSort_medioCaso.csv"); //games_release_date_mergeSort_medioCaso

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        MergeSortRecordArray.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_mergeSort_melhorCaso.csv");
    }

	private static void mergeSortByReleaseDateWorstCase() {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_mergeSort_melhorCaso.csv"); //games_release_date_mergeSort_melhorCaso
		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Descending sort
		MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        MergeSortRecordArray.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_mergeSort_piorCaso.csv");
    }


    private static void heapSortByReleaseDateAverageCase() {
        // Initializing variable
        RecordsCSV recordsCSV = new RecordsCSV("transformations", "games_formated_release_date.csv"); //games_release_date.csv

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        HeapSort.heapSort(recordsCSV.getRecords());

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_heapSort_medioCaso.csv");
    }

	private static void heapSortByReleaseDateBestCase() {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_heapSort_medioCaso.csv"); //games_release_date_heapSort_medioCaso

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        HeapSort.heapSort(recordsCSV.getRecords());

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_heapSort_melhorCaso.csv");
    }

	private static void heapSortByReleaseDateWorstCase() {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_heapSort_melhorCaso.csv"); //games_release_date_heapSort_melhorCaso
		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Descending sort
		MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        HeapSort.heapSort(recordsCSV.getRecords());

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_heapSort_piorCaso.csv");
    }


	private static void quickSortHoareByReleaseDateAverageCase() {
        // Initializing variable
        RecordsCSV recordsCSV = new RecordsCSV("transformations", "games_formated_release_date.csv"); //games_release_date.csv

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        QuickSort.quickSort(recordsCSV.getRecords(), 0, recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_quickSortHoare_medioCaso.csv");
    }

	private static void quickSortHoareByReleaseDateBestCase() {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_quickSortHoare_medioCaso.csv"); //games_release_date_quickSortHoare_medioCaso

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        QuickSort.quickSort(recordsCSV.getRecords(), 0, recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_quickSortHoare_melhorCaso.csv");
    }

	private static void quickSortHoareByReleaseDateWorstCase() {
        // Initializing variables
        RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_quickSortHoare_melhorCaso.csv"); //games_release_date_quickSortHoare_melhorCaso
		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Descending sort
		MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

        QuickSort.quickSort(recordsCSV.getRecords(), 0, recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

        //Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %2f; %.2f;  ", durationTime, consumedMemory);

        recordsCSV.copyCSV("sorts","games_release_date_quickSortHoare_piorCaso.csv");
    }


	private static void insertionSortByReleaseDateAverageCase() {
			// Initializing variable
			RecordsCSV recordsCSV = new RecordsCSV("transformations", "games_formated_release_date.csv"); //games_release_date.csv

			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			InsertionSort.insertionSortDate(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_insertionSort_medioCaso.csv");
		}

	private static void insertionSortByReleaseDateBestCase() {
			// Initializing variables
			RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_insertionSort_medioCaso.csv"); //games_release_date_insertioSort_medioCaso

			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			InsertionSort.insertionSortDate(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_insertionSort_melhorCaso.csv");
		}

	private static void insertionSortByReleaseDateWorstCase() {
			// Initializing variables
			RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_insertionSort_melhorCaso.csv"); //games_release_date_insertioSort_melhorCaso
			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Descending sort
			MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			InsertionSort.insertionSortDate(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_insertionSort_piorCaso.csv");
		}


	private static void selectionSortByReleaseDateAverageCase() {
			// Initializing variable
			RecordsCSV recordsCSV = new RecordsCSV("transformations", "games_formated_release_data.csv"); //games_release_date.csv

			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			SelectionSort.selectionSortReleaseDate(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_selectionSort_medioCaso.csv");
		}

	private static void selectionSortByReleaseDateBestCase() {
			// Initializing variables
			RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_selectionSort_medioCaso.csv"); //games_release_date_selectionSort_medioCaso

			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			SelectionSort.selectionSortReleaseDate(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_selectionSort_melhorCaso.csv");
		}

	private static void selectionSortByReleaseDateWorstCase() {
			// Initializing variables
			RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_selectionSort_melhorCaso.csv"); //games_release_date_selectionSort_melhorCaso
			double initialMemory, finalMemory, initialTime, finalTime;
			double consumedMemory, durationTime;
			Runtime runtime = Runtime.getRuntime();

			// Descending sort
			MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

			// Cleaning Garbage Collector
			System.gc();

			// Measuring execution time and consumed memory
			initialTime = System.nanoTime();
			initialMemory = runtime.totalMemory() - runtime.freeMemory();

			SelectionSort.selectionSortReleaseDate(recordsCSV.getRecords());

			finalMemory = runtime.totalMemory() - runtime.freeMemory();
			finalTime = System.nanoTime();

			//Final
			durationTime = (finalTime - initialTime) / 1_000_000;
			consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

			System.out.printf(" %2f; %.2f;  ", durationTime, consumedMemory);

			recordsCSV.copyCSV("sorts","games_release_date_selectionSort_piorCaso.csv");
		}


	private static void quickSortMediana3ByReleaseDateAverageCase() {
		// Initializing variable
		RecordsCSV recordsCSV = new RecordsCSV("transformations", "games_formated_release_date.csv"); //games_release_date.csv

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

		QuickSortComMediana3.quickSortMediana3(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

		//Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

		recordsCSV.copyCSV("sorts","games_release_date_quickSortMediana3_medioCaso.csv");
	}

	private static void quickSortMediana3ByReleaseDateBestCase() {
		// Initializing variables
		RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_quickSortMediana3_medioCaso.csv"); //games_release_date_quickSortMediana3_medioCaso

		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

		QuickSortComMediana3.quickSortMediana3(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

		//Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

		recordsCSV.copyCSV("sorts","games_release_date_quickSortMediana3_melhorCaso.csv");
	}

	private static void quickSortMediana3ByReleaseDateWorstCase() {
		// Initializing variables
		RecordsCSV recordsCSV = new RecordsCSV("sorts", "games_release_date_quickSortMediana3_melhorCaso.csv"); //games_release_date_quickSortMediana3_melhorCaso
		double initialMemory, finalMemory, initialTime, finalTime;
		double consumedMemory, durationTime;
		Runtime runtime = Runtime.getRuntime();

		// Descending sort
		MergeSortRecordArrayDescending.sort(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		// Cleaning Garbage Collector
		System.gc();

		// Measuring execution time and consumed memory
		initialTime = System.nanoTime();
		initialMemory = runtime.totalMemory() - runtime.freeMemory();

		QuickSortComMediana3.quickSortMediana3(recordsCSV.getRecords(),0,recordsCSV.getRecords().length-1);

		finalMemory = runtime.totalMemory() - runtime.freeMemory();
		finalTime = System.nanoTime();

		//Final
		durationTime = (finalTime - initialTime) / 1_000_000;
		consumedMemory = ((finalMemory - initialMemory) / (1_024 * 1_024));

		System.out.printf(" %.2f; %.2f;  ", durationTime, consumedMemory);

		recordsCSV.copyCSV("sorts","games_release_date_quickSortMediana3_piorCaso.csv");
	}


	public static void sortsReleaseDate() {
		System.out.print("Merge Sort; Release Date;");
		mergeSortByReleaseDateAverageCase();
		mergeSortByReleaseDateBestCase();
		mergeSortByReleaseDateWorstCase();

		System.out.print("Heap Sort; Release Date;");
		heapSortByReleaseDateAverageCase();
		heapSortByReleaseDateBestCase();
		heapSortByReleaseDateWorstCase();

		System.out.print("Quick Sort Hoare; Release Date;");
		quickSortHoareByReleaseDateAverageCase();
		quickSortHoareByReleaseDateBestCase();
		quickSortHoareByReleaseDateWorstCase();

		System.out.print("Quick Sort Mediana 3; Release Date;");
		SortsByReleaseDate.quickSortMediana3ByReleaseDateAverageCase();
		SortsByReleaseDate.quickSortMediana3ByReleaseDateBestCase();
		SortsByReleaseDate.quickSortMediana3ByReleaseDateWorstCase();

		System.out.print("Insertion Sort; Release Date;");
		insertionSortByReleaseDateAverageCase();
		insertionSortByReleaseDateBestCase();
		insertionSortByReleaseDateWorstCase();

		System.out.print("Selection Sort; Release Date;");
		selectionSortByReleaseDateAverageCase();
		selectionSortByReleaseDateBestCase();
		selectionSortByReleaseDateWorstCase();

    }

}
