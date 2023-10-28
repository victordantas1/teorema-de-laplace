package com.vct;

public class Main {
		
	public static void main(String[] args){
		Matriz mat1,mat2;
		int det, count;
		long inicio, fim, resultado;
		long mediaTemp01 = 0;
		long mediaTemp02 = 0;
		long mediaTemp03 = 0;
		Vetor vet = new Vetor();
		vet.inicializaOrdens();
		count = 0;
		while(count < vet.getTamanho()) {
			for(int i = 0; i < 3; i++) {


				mat1 = new Matriz((int) vet.getElemento(count),(int) vet.getElemento(count));
				mat1.inicializaRandomico();
				mat1.imprime();

				System.out.println("Determinante Base Line Ordem - " + (int) vet.getElemento(count));
				inicio = System.nanoTime();
				det = mat1.determinante();
				fim = System.nanoTime();
				resultado = fim - inicio;

				System.out.println("Determinante: " + det);
				System.out.println("Tempo em Nano: " + resultado);
				mediaTemp01 += resultado;

				System.out.println("");

				System.out.println("Determinante Otimizado 1 Ordem - " + (int) vet.getElemento(count));
				mat1.contaZeros();

				inicio = System.nanoTime();
				det = mat1.determinanteOtimizadoV1();
				fim = System.nanoTime();
				resultado = fim - inicio;

				System.out.println("Determinante: " + det);
				System.out.println("Tempo em Nano: " + resultado);
				mediaTemp02 += resultado;

				System.out.println("");

				System.out.println("Determinante Otimizado 2 Ordem - " + (int) vet.getElemento(count));
				mat1.econtraElementosIguais();
				mat1.encontraProp();

				inicio = System.nanoTime();
				det = mat1.determinanteOtimizadoV2();
				fim = System.nanoTime();
				resultado = fim - inicio;

				System.out.println("Determinante: " + det);
				System.out.println("Tempo em Nano: " + resultado);
				mediaTemp03 += resultado;

			}
			System.out.println("");
			System.out.println("Media Base Line: " + mediaTemp01/3);
			System.out.println("Media Otimizacao 1: " + mediaTemp02/3);
			System.out.println("Media Otimizacao 2: " + mediaTemp03/3);
			System.out.println("");

			count++;
		}

		/*
		
		array com as ordens [3,5,7,9,11,13]
		
		enquanto tiver ordem no array faca
			ordemMatriz = ordemDaVez
			
		 	para cada ordem faca
		 		cria a matriz com a ordem
		 		para cara repeticao faca	
		 			inicializa randomicamente com a ordem	
		 			calculaDet com metodoBase
		 			calculaDet com otimiV1
		 			calculaDet com otimiV2
		 		fim-para
		 	fim-para	
		 		

		*/


	}

}
