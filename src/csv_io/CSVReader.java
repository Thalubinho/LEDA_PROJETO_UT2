package csv_io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVReader {
	private final String path;
	private final CSVRecord[] csvRecords; // csvRecord[0] is the first line, header is ignored

	public CSVReader(String name) {
		this.path = name;
		this.csvRecords = read();
	}

	public CSVReader(String folder, String name) {
		this.path = folder + File.separator + name;
		this.csvRecords = read();
	}

	public String getPath() {
		return this.path;
	}

	public CSVRecord[] getCsvRecords() {
		return this.csvRecords;
	}

	private CSVRecord[] read() {
		CSVRecord[] csvRecords = new CSVRecord[0];

		File file = new File(this.getPath());
		if (!file.exists() || !file.isFile()) {
			System.err.println("Arquivo não encontrado: " + this.getPath());
			return csvRecords;
		}

		try (Reader reader = Files.newBufferedReader(Paths.get(this.getPath()));
			 CSVParser csvParser = CSVFormat.DEFAULT
					 .builder()
					 .setHeader()// Define a primeira linha como cabeçalho
					 .build()
					 .parse(reader)) {

			List<CSVRecord> recordsList = csvParser.getRecords();
			csvRecords = recordsList.toArray(new CSVRecord[0]);

//			for (CSVRecord record : csvRecords) {
//				System.out.println(record);
//			}
//			System.out.println("Total de registros lidos: " + csvRecords.length);

		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.err.printf("Erro ao ler '%s'%n", this.getPath());
		}
		return csvRecords;
	}

	public static void main(String[] args) {
		//CSVReader gamesCSV = new CSVReader("games.csv");
	}
}
