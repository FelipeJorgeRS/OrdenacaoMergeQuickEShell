public class Principal {
	
		// 	MERGER SORT
		    public static int[]  lerVetorPorMergerSort(int []vetor) {		        
			        mergeSort(vetor, 0, vetor.length - 1);
			        return vetor;
		    }
		    public static void mergeSort(int[] vetor, int inicio, int fim) {
		        if (inicio < fim) {
		            int meio = (inicio + fim) / 2;
		            mergeSort(vetor, inicio, meio);
		            mergeSort(vetor, meio + 1, fim);
		            merge(vetor, inicio, meio, fim);
		        }
		    }

		    public static void merge(int[] vetor, int inicio, int meio, int fim) {
		        int[] temp = new int[fim - inicio + 1];
		        int i = inicio, j = meio + 1, k = 0;
		        while (i <= meio && j <= fim) {
		            if (vetor[i] <= vetor[j]) {
		                temp[k] = vetor[i];
		                i++;
		            } else {
		                temp[k] = vetor[j];
		                j++;
		            }
		            k++;
		        }
		        while (i <= meio) {
		            temp[k] = vetor[i];
		            i++;
		            k++;
		        }
		        while (j <= fim) {
		            temp[k] = vetor[j];
		            j++;
		            k++;
		        }
		        if (fim + 1 - inicio >= 0)
		            System.arraycopy(temp, 0, vetor, inicio, fim + 1 - inicio);
		     // Imprimir o vetor após cada mesclagem
		        for (int x = 0; x < vetor.length; x++) {
		            System.out.print(vetor[x] + " ");
		        }
		        System.out.println();
		    }
		
		///// QUICK SORT
		    static void particao(int[] E, int esquerda, int direita, int[] fe, int[] ir) {
		        int pivo;
		        int aux;
		        int i, j;
		        i = esquerda;
		        j = direita;
		        pivo = E[(i+j)/2];
		        do {
		            while (E[i] < pivo) i++;
		            while (pivo < E[j]) j--;
		            if (i <= j)
		            {
		                aux=E[i];
		                E[i]=E[j];
		                E[j]=aux;
		                i++;
		                j--;
		            }
		        } while (i <= j);
		        fe[0] = j;
		        ir[0] = i;
		    }

		    static void rapido(int[] E, int esquerda, int direita) {
		        int[] le = new int[1];
		        int[] rb = new int[1];
		        particao(E, esquerda, direita, le, rb);
		        if (esquerda < le[0]) rapido(E, esquerda, le[0]);
		        if (rb[0] < direita) rapido(E, rb[0], direita);

		        // Imprimir o vetor a cada iteração
		        System.out.print("[");
		        for (int i = 0; i < E.length; i++) {
		            if (i > 0) {
		                System.out.print(", ");
		            }
		            System.out.print(E[i]);
		        }
		        System.out.println("]");
		    }

		    public static int[] quickSort(int[] vetor) {
		        rapido(vetor, 0, vetor.length-1);
		        
		        return vetor;
		    }
		       
		 // SHLELL SORT
	
		    public static void ordenacaoShell(int[] arrayNumeros) {
		        int tamanhoArray = arrayNumeros.length;
		        int indice, indiceAuxiliar, valorH;
		        int numeroAtual;
	
		        valorH = 1;
		        while (valorH < tamanhoArray) valorH = 3 * valorH + 1;
		        do {
		            valorH = valorH / 3;
		            for (indice = valorH; indice < tamanhoArray; indice++) {
		                numeroAtual = arrayNumeros[indice];
		                indiceAuxiliar = indice - valorH;
		                while (indiceAuxiliar >= 0 && numeroAtual < arrayNumeros[indiceAuxiliar]) {
		                    arrayNumeros[indiceAuxiliar + valorH] = arrayNumeros[indiceAuxiliar];
		                    indiceAuxiliar -= valorH;
		                }
		                arrayNumeros[indiceAuxiliar + valorH] = numeroAtual;
	
		                // Imprimi o array após cada iteração          
		                for (int i = 0; i < arrayNumeros.length; i++) {
		                    System.out.print(arrayNumeros[i] + " ");
		                }
		                System.out.println();
		            }
		        } while (valorH >= 1);
		    }

		public static void main(String[] args) {
			 int [] vetor = {3,4,9,2,5,8,2,1,7,4,6,2,9,8, 5, 1};
			
			 
			 System.out.println("Método quickSort");
			 quickSort(vetor);
			 System.out.println("========================================================\n");
			 
			 System.out.println("Método MergerSort");
			lerVetorPorMergerSort(vetor);
			System.out.println("========================================================\n");
			 
			System.out.println("Método ShellSort");
			ordenacaoShell(vetor);
			System.out.println("========================================================\n");
			
		}
		
}



