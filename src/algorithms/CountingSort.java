package algorithms;

public class CountingSort {
     public static int[] counting(int[] vetor) {
         // Encontrar o valor máximo no array
         int max = vetor[0];
         for (int i = 1; i < vetor.length; i++) {
             if (max < vetor[i]) {
                 max = vetor[i];
             }
         }

         // Criar o array de contagem
         int[] vetorAux = new int[max + 1];

         // Contar a ocorrência de cada número
         for (int i = 0; i < vetor.length; i++) {
             vetorAux[vetor[i]]++;
         }

         // Atualizar o array auxiliar para armazenar as posições dos elementos
         for (int i = 1; i <= max; i++) {
             vetorAux[i] += vetorAux[i - 1];
         }

         // Construir o array ordenado
         int[] vetorOrdenado = new int[vetor.length];
         for (int i = vetor.length - 1; i >= 0; i--) {
             vetorOrdenado[(vetorAux[vetor[i]] - 1)] = vetor[i];
             vetorAux[vetor[i]]--;
         }

         return vetorOrdenado;
     }
}
