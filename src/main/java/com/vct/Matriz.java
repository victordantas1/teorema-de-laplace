package com.vct;

import java.util.Random;

public class Matriz implements MetodosMatriz {

	private int[][] mat;
	private int tamLinha;
	private int tamColuna;
	private boolean ehLinha;
	private int indexMaisZeros;
	private int qtdZerosLinhaOuColuna;
	private boolean prop;
    private boolean elementoLinOuColIguais;

	public Matriz(){
		mat = new int[6][6];
		this.setTamanhoLinha(6);	
		this.setTamanhoColuna(6);
	}

	public Matriz(int numLinhas, int numColunas){
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

	public boolean getEhLinha() {
		return ehLinha;
	}

	public void setEhLinha(boolean linha) {
		this.ehLinha = linha;
	}

	public int getIndexMaisZeros() {
		return indexMaisZeros;
	}

	public void setIndexMaisZeros(int indexMaisZeros) {
		this.indexMaisZeros = indexMaisZeros;
	}

	public int getQtdZerosLinhaOuColuna() {
		return qtdZerosLinhaOuColuna;
	}

	public void setQtdZerosLinhaOuColuna(int qtdZeros) {
		this.qtdZerosLinhaOuColuna = qtdZeros;
	}

	public boolean getProp() {
		return this.prop;
	}

	public void setProp(boolean proporcional) {
		this.prop = proporcional;
	}

    public boolean getElementoLinOuColIguais() {
        return elementoLinOuColIguais;
    }

    public void setElementoLinOuColIguais(boolean elementoLinOuColIguais) {
        this.elementoLinOuColIguais = elementoLinOuColIguais;
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
		for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
			cofator = mat.getValor(0,contC);
			sinal = this.calculaSinal(0,contC);
			matmenor = new Matriz(numL-1,numC-1);
			this.copiaMatrizMaiorParaMenor(mat,matmenor,0,contC);
			detTemp = matmenor.determinante();
			resposta = resposta + (cofator * sinal * detTemp);
		}
		return (resposta);
	}

	private int detOrdemNOtimizadoV1(Matriz mat){
		int sinal, cofator, detTemp, resposta, contC, contL, numL, numC;
		Matriz matmenor;
		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();

		resposta = 0;

		if(this.getEhLinha()) {
			for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
				cofator = mat.getValor(this.getIndexMaisZeros(), contC);
				if(cofator == 0) {
					resposta += cofator;
				}
				else {
					sinal = this.calculaSinal(this.getIndexMaisZeros(),contC);
					matmenor = new Matriz(numL-1,numC-1);
					this.copiaMatrizMaiorParaMenor(mat,matmenor,this.getIndexMaisZeros(),contC);
					detTemp = matmenor.determinante();
					resposta = resposta + (cofator * sinal * detTemp);
				}
			}
		}
		else {
			for(contL = 0; contL < mat.getTamanhoColuna(); contL++){
				cofator = mat.getValor(contL, this.getIndexMaisZeros());
				if(cofator == 0) {
					resposta += cofator;
				}
				else {
					sinal = this.calculaSinal(contL, this.getIndexMaisZeros());
					matmenor = new Matriz(numL-1,numC-1);
					this.copiaMatrizMaiorParaMenor(mat,matmenor,contL,this.getIndexMaisZeros());
					detTemp = matmenor.determinante();
					resposta = resposta + (cofator * sinal * detTemp);
				}
			}
		}

		return (resposta);
	}

	private int detOrdemNOtimizadoV2(Matriz mat){
		int sinal, cofator, detTemp, resposta, contC, contL, numL, numC;
		Matriz matmenor;
		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();

		resposta = 0;
		if(this.getQtdZerosLinhaOuColuna() == this.getTamanhoLinha() || this.getProp()
				|| this.getElementoLinOuColIguais()) {
			resposta = 0;
		}
		else {
			if(this.getEhLinha()) {
				for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
					cofator = mat.getValor(this.getIndexMaisZeros(), contC);
					if(cofator == 0) {
						resposta += cofator;
					}
					else {
						sinal = this.calculaSinal(this.getIndexMaisZeros(),contC);
						matmenor = new Matriz(numL-1,numC-1);
						this.copiaMatrizMaiorParaMenor(mat,matmenor,this.getIndexMaisZeros(),contC);
						detTemp = matmenor.determinanteOtimizadoV2();
						resposta = resposta + (cofator * sinal * detTemp);
					}
				}
			}
			else {
				for(contL = 0; contL < mat.getTamanhoColuna(); contL++){
					cofator = mat.getValor(contL, this.getIndexMaisZeros());
					if(cofator == 0) {
						resposta += cofator;
					}
					else {
						sinal = this.calculaSinal(contL, this.getIndexMaisZeros());
						matmenor = new Matriz(numL-1,numC-1);
						this.copiaMatrizMaiorParaMenor(mat,matmenor,contL,this.getIndexMaisZeros());
						detTemp = matmenor.determinanteOtimizadoV2();
						resposta = resposta + (cofator * sinal * detTemp);
					}
				}
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
			    default: det = this.detOrdemN(this);;
				     break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}

	public int determinanteOtimizadoV1(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
				case 1:  det = this.detOrdem1(this);
					break;
				case 2:  det = this.detOrdem2(this);;
					break;
				default: det = this.detOrdemNOtimizadoV1(this);;
					break;
			}

		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}


	public int determinanteOtimizadoV2(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
				case 1:  det = this.detOrdem1(this);
					break;
				case 2:  det = this.detOrdem2(this);;
					break;
				case 3: det = this.detOrdem3(this);;
					break;
				default: det = this.detOrdemNOtimizadoV2(this);;
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
			}
			if(countC > maisZeros) {
				maisZeros = countC;
				index = i;
				this.setEhLinha(false);
			}
			else if (countL > maisZeros){
				maisZeros = countL;
				index = i;
				this.setEhLinha(true);
			}
		}
		this.setIndexMaisZeros(index);
		this.setQtdZerosLinhaOuColuna(maisZeros);
	}

	public static Matriz meuInicializa() {
		Matriz mt = new Matriz(5, 5);
		mt.setValor(0 , 0 , 2);
		mt.setValor(0, 1, 1);
		mt.setValor(0, 2, 4);
		mt.setValor(0, 3, 4);
		mt.setValor(0, 4, 2);
		mt.setValor(1, 0, 3);
		mt.setValor(1 , 1, 0);
		mt.setValor(1, 2, 9);
		mt.setValor(1, 3, 12);
		mt.setValor(1 , 4 ,5);
		mt.setValor(2, 0, 1);
		mt.setValor(2, 1, 0);
		mt.setValor(2, 2, 6);
		mt.setValor(2, 3, 1);
		mt.setValor(2, 4, 2);
		mt.setValor(3 , 0, 2);
		mt.setValor(3, 1, 0);
		mt.setValor(3, 2, 1);
		mt.setValor(3, 3, 6);
		mt.setValor(3, 4, 3);
		mt.setValor(4,0 , 0);
		mt.setValor(4, 1, 0);
		mt.setValor(4 , 2, 6);
		mt.setValor(4, 3, 1);
		mt.setValor(4, 4, 2);

		return mt;
	}

	public static Matriz meuInicializa3por3() {
		Matriz mt = new Matriz(3, 3);
		mt.setValor(0 , 0 , 4);
		mt.setValor(0, 1, 6);
		mt.setValor(0, 2, 8);
		mt.setValor(1, 0, 2);
		mt.setValor(1, 1, 6);
		mt.setValor(1, 2, 4);
		mt.setValor(2 , 0, 4);
		mt.setValor(2, 1, 6);
		mt.setValor(2, 2, 8);

		return mt;
	}


	public int detOrdem3(Matriz mat) {
        int resultado;
        if(mat.getProp() || mat.getQtdZerosLinhaOuColuna() == mat.getTamanhoLinha()) {
            resultado = 0;
        }
        else {
               resultado = (mat.getValor(0, 0) * mat.getValor(1, 1)
				* mat.getValor(2, 2)) + (mat.getValor(0, 1)
				* mat.getValor(1, 2) * mat.getValor(2, 0))
				+ (mat.getValor(1, 0) * mat.getValor(2, 1)
				* mat.getValor(0, 2))
				- ((mat.getValor(2 , 2) * mat.getValor(0, 1)
				* mat.getValor(1, 0)) + (mat.getValor(0, 2)
				* mat.getValor(1, 1) * mat.getValor(2, 0))
				+ (mat.getValor(1, 2) * mat.getValor(2, 1)
				* mat.getValor(0, 0)));
	    }
        return resultado;
    }

	public void encontraProp() {
		boolean prop, linhaProp, colunaProp;
		prop = false;
		Vetor vetLinha = new Vetor(this.getTamanhoLinha());
		Vetor vetColuna = new Vetor(this.getTamanhoColuna());
		int cont = 0;
		while(cont < this.getTamanhoLinha() && prop == false) {
			linhaProp = vetLinha.comparaValoresLinhaV2(this, cont);
			colunaProp = vetColuna.comparaValoresColunaV2(this, cont);
				if(linhaProp || colunaProp){
					prop = true;
				}
				cont++;
		}
		this.setProp(prop);
	}

    @Override
    public void econtraElementosIguais() {
        boolean iguais = false;
        int count = 0;
        Vetor vetLinha = new Vetor(this.getTamanhoLinha());
        Vetor vetColuna = new Vetor(this.getTamanhoColuna());
        while (count < this.getTamanhoLinha() && iguais == false) {
            vetLinha.insereMatrizNoVetLinha(this, count);
            vetColuna.insereMatrizNoVetColuna(this, count);
            if(vetLinha.comparaValoresInternos() || vetColuna.comparaValoresInternos()) {
                iguais = true;
            }
			count++;
        }
        this.setElementoLinOuColIguais(iguais);
    }

}