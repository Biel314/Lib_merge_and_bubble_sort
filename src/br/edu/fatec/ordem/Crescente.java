package br.edu.fatec.ordem;

public class Crescente {

	public Crescente() {
		super();
	}
	
	
	public int[] bubble(int arr[]) {
		int size = arr.length;
		int aux;
		
		//Comparando dois elementos do vetor
		for(int i=0; i < size; i++) {
			for(int j=i+1; j < size; j++) {
				//Trocando-os caso a condicao seja atendida
				if(arr[i] > arr[j]) {
					aux = arr[j];
					arr[j] = arr[i];
					arr[i] = aux;
				}
			}
		}
		
		return arr;
	}
	
	
	public int[] merge(int arr[], int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			//Dividindo o vetor em seus lados
			merge(arr, start, mid); //Esquerda
			merge(arr, mid+1, end); //Direita
			
			//Ordenando seus lados (funcao intercalar)
			intercalando(arr, start, mid, end);
		}
		
		return arr;
	}

	private void intercalando(int[] arr, int start, int mid, int end) {
		int[] aux = new int[arr.length];
		
		//inserindo os valores do vetor original no vetor auxiliar
		for(int i = start; i <= end; i++) {
			aux[i] = arr[i];
		}
		
		//Ponteiro da esquerda
		int left = start;
		
		//Ponteiro da Direita
		int right = mid + 1;

		//Iniciando contador
		for(int cont = start; cont <= end; cont++) {
			//Logicas
			if(left > mid) {
				arr[cont] = aux[right];
				right++;
			} else if(right > end) {
				arr[cont] = aux[left];
				left++;
			} else if(aux[left] < aux[right]) {
				arr[cont] = aux[left];
				left++;
			} else {
				arr[cont] = aux[right];
				right++;
			}
		}
		
	}

	
	
}
