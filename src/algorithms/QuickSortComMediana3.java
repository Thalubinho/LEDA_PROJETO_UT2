package algorithms;

import csv_io.RecordsCSV;
import org.apache.commons.csv.CSVRecord;

public class QuickSortComMediana3 {

    public static void quickSortMediana3(CSVRecord[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndice = particaoMediana3(vetor, inicio, fim);
            quickSortMediana3(vetor, inicio, pivoIndice - 1);       // Ordena a sublista à esquerda do pivô
            quickSortMediana3(vetor, pivoIndice + 1, fim);    // Ordena a sublista à direita do pivô
        }
    }

    private static int particaoMediana3(CSVRecord[] vetor, int esquerda, int direita) {
        int mediana = mediana3(vetor, esquerda, direita);
        CSVRecord pivo = vetor[mediana];

        int pivoIndice = mediana;
        int i = esquerda - 1;
        int j = direita  + 1;

        while (i < j) {
            do{
                i++;
            }while (!(RecordsCSV.compareReleaseDate(vetor[i].get(2), pivo.get(2))));

            do{
                j--;
            }while (RecordsCSV.compareReleaseDate(vetor[j].get(2), pivo.get(2)));

            // Troca os elementos
            if(!(i >= j)){
                CSVRecord aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }

        }

        //Procurando o indice do pivo
        int k = 0;
        do {
            if(RecordsCSV.equals(vetor[k].get(2), pivo.get(2))){
                pivoIndice = k;
            }
        } while (!(RecordsCSV.equals(vetor[k].get(2), pivo.get(2))));

        return pivoIndice;
    }
    
    private static int mediana3(CSVRecord[] vetor, int esquerda, int direita) {
        String firstDate = vetor[esquerda].get(2), midDate = vetor[(esquerda+direita)/2].get(2) , lastDate = vetor[direita].get(2);

        if ((RecordsCSV.compareReleaseDate(firstDate,midDate) && RecordsCSV.compareReleaseDate(midDate,lastDate)) ||
           (RecordsCSV.compareReleaseDate(lastDate,midDate) && RecordsCSV.compareReleaseDate(midDate,firstDate))) {
            return (esquerda + direita) / 2;
        } else if ((RecordsCSV.compareReleaseDate(midDate, firstDate) && RecordsCSV.compareReleaseDate(firstDate, lastDate)) ||
                  (RecordsCSV.compareReleaseDate(lastDate, firstDate) && RecordsCSV.compareReleaseDate(firstDate, midDate))) {
            return esquerda;
        } else {
            return direita;
        }
    }
}
