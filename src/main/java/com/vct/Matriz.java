package com.vct;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;


@Getter
@Setter
class Matriz {
	private int[][] mat;
	private int tamLinha;
	private int tamColuna;
	private boolean linha;
	private int indexMaisZeros;

	Matriz(){
		mat = new int[6][6];
		this.setTamanhoLinha(6);	
		this.setTamanhoColuna(6);
	}

	Matriz(int numLinhas, int numColunas){
		mat = new int[numLinhas][numColunas];
		this.setTamanhoLinha(numLinhas);	
		this.setTamanhoColuna(numColunas);
	}



	public int getValor(int indiceI,int indiceJ){
		return mat[indiceI][indiceJ];
	}	
	
	public void setValor(int indiceI,int indiceJ, int novoValor){
		mat[indiceI][indiceJ] = novoValor;
	}

	public int getTamanhoLinha(){
		return tamLinha;
	}	
	
	public int getTamanhoColuna(){
		return tamColuna;
	}	

	private void setTamanhoLinha(int novoValor){
		tamLinha = novoValor;
	}

	private void setTamanhoColuna(int novoValor){
		tamColuna = novoValor;
	}

	public void imprime(){
		int conti,contj;	
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			System.out.println();
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				System.out.print(this.getValor(conti,contj) + " ");
			}
		}
		System.out.println();	
	}

	public void inicializaRandomico(){
		int conti,contj, novoValor;
		int ordem = this.getTamanhoLinha();
		Random gerador = new Random();
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				novoValor = gerador.nextInt(ordem);
				this.setValor(conti,contj,novoValor);
			}
		}
	}

	// caso matriz nao quadrada, retorna -1
	public int retorneOrdem(){
		int numL, numC, ordem;

		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		ordem = -1;
		if(numL == numC){
			ordem = numL;
		}

		return ordem;
	}	

	private int detOrdem1(Matriz mat){
		return mat.getValor(0,0);
	}
	
	private int detOrdem2(Matriz mat){
		int diagonalP, diagonalI;

		diagonalP = mat.getValor(0,0) * mat.getValor(1,1);		
		diagonalI = mat.getValor(1,0) * mat.getValor(0,1);		

		return (diagonalP - diagonalI);
	}

	private int calculaSinal(int indiceL, int indiceC){
		int sinal;

		sinal = -1;

		if( ((indiceL + indiceC)% 2) == 0 ){
			sinal = 1;
		}

		return sinal;		
	}

	public void copiaMatrizMaiorParaMenor(Matriz maior,Matriz menor,int isqn,int jsqn){
		int contAi,contAj,contBi,contBj,temp,numL,numC;
		numL = menor.getTamanhoLinha();
		numC = menor.getTamanhoColuna();

		contAi = 0;
		for(contBi = 0; contBi < numL; contBi++){
			if(contAi == isqn){
				contAi++;
			}
			contAj = 0;
			for(contBj = 0; contBj < numC; contBj++){
				if(contAj == jsqn){
					contAj++;
				}
				temp = maior.getValor(contAi,contAj);
				menor.setValor(contBi,contBj,temp);
				contAj++;
			}
			contAi++;
		}
	}

	private int detOrdemN(Matriz mat){
		int sinal, cofator, detTemp, resposta, contC, numL, numC;
		Matriz matmenor;
		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();

		resposta = 0;
		if(this.isLinha()) {
			for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
				cofator = mat.getValor(this.getIndexMaisZeros(),contC);
				sinal = this.calculaSinal(this.getIndexMaisZeros(),contC);
				matmenor = new Matriz(numL-1,numC-1);
				this.copiaMatrizMaiorParaMenor(mat,matmenor,this.getIndexMaisZeros(),contC);
				detTemp = matmenor.determinante();
				resposta = resposta + (cofator * sinal * detTemp);
			}
		}
		else {
			for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
				cofator = mat.getValor(this.getIndexMaisZeros(),contC);
				sinal = this.calculaSinal(this.getIndexMaisZeros(),contC);
				matmenor = new Matriz(numL-1,numC-1);
				this.copiaMatrizMaiorParaMenor(mat,matmenor,this.getIndexMaisZeros(),contC);
				detTemp = matmenor.determinante();
				resposta = resposta + (cofator * sinal * detTemp);
			}
		}
		return (resposta);
	}


	public int determinante(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
			    case 1:  det = this.detOrdem1(this);
				     break;
			    case 2:  det = this.detOrdem2(this);;
				     break;
				case 3: det = this.detOrdem3(this);
					break;
			    default: det = this.detOrdemN(this);;
				     break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}

	public void contaZeros() {
		int maisZeros = 0;
		int index = 0;
		int countC, countL, i, j;

		for(i = 0; i < this.getTamanhoLinha(); i++) {
			countC = 0;
			countL = 0;
			for(j = 0; j < this.getTamanhoColuna(); j++) {
				if(this.getValor(i, j) == 0) countL++;
				if(this.getValor(j, i) == 0) countC++;
				if(countC > maisZeros) {
					maisZeros = countC;
					index = j;
					this.setLinha(false);
				} else if (countL > maisZeros){
					maisZeros = countL;
					index = i;
					this.setLinha(true);
				}
			}
		}
	}

	public static Matriz meuInicializa() {
		Matriz mt = new Matriz(3, 3);
		mt.setValor(0 , 0 , 0);
		mt.setValor(0, 1, 0);
		mt.setValor(0, 2, 0);
		mt.setValor(1 , 0 , 0);
		mt.setValor(1, 1, 1);
		mt.setValor(1, 2, 0);
		mt.setValor(2 , 0 , 4);
		mt.setValor(2, 1, 3);
		mt.setValor(2, 2, 0);
		return mt;
	}


	public int detOrdem3(Matriz mat) {
		return 	(getValor(0, 0) * getValor(1, 1)
				* getValor(2, 2)) + (getValor(0, 1)
				* getValor(1, 2) * getValor(2, 0))
				+ (getValor(1, 0) * getValor(2, 1)
				* getValor(0, 2))
				- ((getValor(2 , 2) * getValor(0, 1)
				* getValor(1, 0)) + (getValor(0, 2)
				* getValor(1, 1) * getValor(2, 0))
				+ (getValor(1, 2) * getValor(2, 1)
				* getValor(0, 0)));
	}

}