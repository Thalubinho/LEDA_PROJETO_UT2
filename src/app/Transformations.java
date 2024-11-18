package app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import csv_io.HeaderGamesCSV;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import csv_io.CSVReader;
import csv_io.CSVWriter;

public class Transformations {

	public static void transformationReleaseDate() {
		// Extract this later, use CSVCopier instead
		CSVReader gamesCSV = new CSVReader("games.csv");
		CSVWriter transformedGamesCSV = new CSVWriter("transformations","games_formated_release_date.csv");

		try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(transformedGamesCSV.getPath()));
			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.Builder.create()
                    					.setHeader(HeaderGamesCSV.class)
                    					.build())) {

			for(CSVRecord record: gamesCSV.getCsvRecords()) { // Each record is one line
				String date = record.get(2);   // Each column is a .get(index)

 				// Formating "Release Date"
 				date = date.replace(' ', '/').replace(",","");
 				String[] dateFormated = date.split("/");
				dateFormated = addDayIfIsMissing(dateFormated);
 				date = convertArrayToString(formatDate(dateFormated));

 				//Cloning "games.csv" and changing "Release Date"
 				int numColumns = record.size();
 				String[] row = new String[numColumns];

 				for(int column = 0; column < numColumns; column++) {
 					if(column == 2) { // "Release Date" column
 						row[column] = date;
 					} else {
 						row[column] = record.get(column);
 					}
 				}

 				// Creating "games_formated_release_data.csv"
 				csvPrinter.printRecord((Object[]) row);
				//System.out.println(Arrays.toString(row));
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.err.println("Erro ao ler 'games.csv' e/ou ao criar 'games_formated_release_date.csv'");
		}
	}

	private static String[] formatDate(String[] date) {
		changeDayWithMonth(date);
		convertNameMonthToNum(date);
		convertDayToTwoDigits(date);

		return date;
	}

	private static void changeDayWithMonth(String[] date) { // "MM/DD/AAAA" -> "DD/MM/AAAA"
		String aux;
		aux = date[0];
		date[0] = date[1];
		date[1] = aux;
	}

	private static String[] addDayIfIsMissing(String[] date) { // MM/AAAA to MM/DD/AAA
		if(date.length == 2){
			String[] newDate = new String[3];
			newDate[0] = date[0];
			newDate[1] = "01";
			newDate[2] = date[1];

			return newDate;
		}
		return date;
	}

	private static String convertArrayToString(String[] date) { // ["DD", "MM", "AAAA"] to "DD/MM/AAAA"
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < date.length; i++) {

			result.append(date[i]);
			if (i != date.length - 1) {
				result.append("/");
			}
		}

		return result.toString();
	}

	private static void convertNameMonthToNum(String[] date) { //  ["DD", "MM(name)", "AAAA"] -> ["DD", "MM(number)", "AAAA"]
		Map<String, String> months = new HashMap<String, String>(); // Extract this
		months.put("Jan", "01");
		months.put("Feb", "02");
		months.put("Mar", "03");
		months.put("Apr", "04");
		months.put("May", "05");
		months.put("Jun", "06");
		months.put("Jul", "07");
		months.put("Aug", "08");
		months.put("Sep", "09");
		months.put("Oct", "10");
		months.put("Nov", "11");
		months.put("Dec", "12");

		date[1] = months.get(date[1]);
	}

	private static void convertDayToTwoDigits(String[] date) { // ["D", "MM", "AAAA"] -> ["DD", "MM", "AAAA"]
		if (date[0].length() == 1) {
			date[0] = "0" + date[0];
		}
	}

	public static void transformationLinux() {
		CSVReader originalCSV = new CSVReader("transformations","games_formated_release_date.csv");
		CSVWriter transformedCSV = new CSVWriter("transformations","games_linux.csv");

		try (Reader reader = Files.newBufferedReader(Paths.get(originalCSV.getPath()));
			 CSVParser csvParser = CSVFormat.Builder.create()
					 .setHeader()                 // The first line is set as Header
					 .build()
					 .parse(reader);

			 BufferedWriter writer = Files.newBufferedWriter(Paths.get(transformedCSV.getPath()));
			 CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.Builder.create()
					 .setHeader(csvParser.getHeaderMap().keySet().toArray(new String[0]))
					 .build())) {

			for (CSVRecord record : csvParser) { // Each record is one line
				String linux = record.get(18);

				//Cloning "games_formated_release_data.csv" and removing the ones that don´t support linux
				if (Objects.equals(linux, "True")) {
					int numColumns = record.size();
					String[] row = new String[numColumns];

					for (int column = 0; column < numColumns; column++) {
						row[column] = record.get(column);
					}

					// Creating "games_linux.csv"
					csvPrinter.printRecord((Object[]) row);
					//System.out.println(Arrays.toString(row));
					//System.out.println(linux);
				}
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.err.println("Erro ao ler 'games_formated_release_date.csv' e/ou ao criar 'games_linux.csv'");
		}
	}

	public static void transformationPortuguese(){
		// Extract this later, use CSVCopier instead
		CSVReader gamesCSV = new CSVReader("games.csv");
		CSVWriter transformedGamesCSV = new CSVWriter("transformations","portuguese_supported_games.csv");

		try(Reader reader = Files.newBufferedReader(Paths.get(gamesCSV.getPath()));
			CSVParser csvParser = CSVFormat.Builder.create()
					.setHeader()				 // The first line is set as Header
					.build()
					.parse(reader);

			BufferedWriter writer = Files.newBufferedWriter(Paths.get(transformedGamesCSV.getPath()));
			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.Builder.create()
					.setHeader(csvParser.getHeaderMap().keySet().toArray(new String[0]))
					.build())) {

			for(CSVRecord record: csvParser) { // Each record is one line
				String languagesSupported = record.get(10);  // Each column is a .get(index)

				// Formating by games that support portuguese
				if(languagesSupported.contains("Portuguese")){

					//Cloning "games.csv" and changing "Release Date"
					int numColumns = record.size();
					String[] row = new String[numColumns];

					for(int column = 0; column < numColumns; column++) {
						if(column == 2) { // "Release Date" column
							row[column] = languagesSupported;
						} else {
							row[column] = record.get(column);
						}
					}

					// Creating "portuguese_supported_games.csv"
					csvPrinter.printRecord((Object[]) row);
					//System.out.println(Arrays.toString(row));
					System.out.println(languagesSupported);
				}


			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.err.println("Erro ao ler 'games.csv' e/ou ao criar 'games_formated_release_date.csv'");
		}
	}

	public static void main(String[] args) {
		transformationReleaseDate();
	}
}
