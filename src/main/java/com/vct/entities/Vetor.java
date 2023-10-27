package com.vct.entities;

public class Vetor implements MetodosVetor{

    private int[] vet;
    private int tamanho;

    public Vetor(int newTamanho) {
        this.setTamanho(newTamanho);
        vet = new int[this.getTamanho()];
    }

    public void setTamanho(int newTamanho) { this.tamanho = newTamanho; }

    public int getTamanho() { return this.tamanho; }

    public void setElemento(int index, int elemento) { this.vet[index] = elemento; }

    public int getElemento(int index) { return this.vet[index]; }


    @Override
    public boolean comparaValoresLinha(Matriz mat, int index) {
        boolean iguais;
        boolean prop = false;
        for(int i = 0; i < mat.getTamanhoLinha(); i++) {
            iguais = true;
            if(i != index) {
                for(int j = 0; j < mat.getTamanhoColuna() && iguais == true; j++) {
                    if(this.getElemento(j) != mat.getValor(i, j)) {
                        iguais = false;
                    }
                }
                if(iguais) prop = true;
            }
        }
        return prop;
    }

    @Override
    public boolean comparaValoresColuna(Matriz mat, int index) {
        boolean iguais;
        boolean prop = false;
        for(int i = 0; i < mat.getTamanhoLinha(); i++) {
            iguais = true;
            if(i != index) {
                for(int j = 0; j < mat.getTamanhoColuna() && iguais == true; j++) {
                    if(this.getElemento(j) != mat.getValor(j, i)) {
                        iguais = false;
                    }
                }
                if(iguais) prop = true;
            }
        }
        return prop;
    }

    @Override
    public void insereMatrizNoVetLinha(Matriz mat, int index) {
        for(int i = 0; i < mat.getTamanhoLinha(); i++) {
            this.setElemento(i, mat.getValor(index, i));
        }
    }

    @Override
    public void insereMatrizNoVetColuna(Matriz mat, int index) {
        for(int i = 0; i < mat.getTamanhoLinha(); i++) {
            this.setElemento(i, mat.getValor(i, index));
        }
    }

    @Override
    public boolean comparaValoresInternos() {
        boolean igual = true;
        int count = 0;
        while(count < this.getTamanho() - 1) {
            if(this.getElemento(count) != this.getElemento(count + 1)) {
                igual = false;
            }
            count++;
        }
        return igual;
    }


    public boolean comparaValoresLinhaV2(Matriz mat, int index) {
        boolean iguais, divisores, prop;
        int a = 0;
        prop = false;
        this.insereMatrizNoVetLinha(mat, index);
        Vetor vetDivisores = new Vetor(mat.getTamanhoLinha());
        for(int i = 0; i < mat.getTamanhoLinha(); i++) {
            iguais = true;
            divisores = true;
            a = 1 + i;
            if(i != index) {
                for(int j = 0; j < mat.getTamanhoColuna() && iguais == true; j++) {
                    if((a > mat.getTamanhoLinha())) {
                        vetDivisores.setElemento(j, mat.getValor(a, j) / mat.getValor(i, j));
                        if(!vetDivisores.comparaValoresInternos()) {
                            divisores = false;
                        }
                    }
                    if(this.getElemento(j) != mat.getValor(i, j)) {
                        iguais = false;
                    }
                }
                if(iguais || divisores) prop = true;
            }
        }
        return prop;
    }

    public boolean comparaValoresColunaV2(Matriz mat, int index) {
        boolean iguais, divisores, prop;
        int a = 0;
        prop = false;
        this.insereMatrizNoVetLinha(mat, index);
        Vetor vetDivisores = new Vetor(mat.getTamanhoLinha());
        for(int i = 0; i < mat.getTamanhoLinha(); i++) {
            iguais = true;
            divisores = true;
            a = 1 + i;
            if(i != index) {
                for(int j = 0; j < mat.getTamanhoColuna() && iguais == true; j++) {
                    if((a > mat.getTamanhoColuna())) {
                        vetDivisores.setElemento(j, mat.getValor(j, a) / mat.getValor(j, i));
                        if(!vetDivisores.comparaValoresInternos()) {
                            divisores = false;
                        }
                    }
                    if(this.getElemento(j) != mat.getValor(j, i)) {
                        iguais = false;
                    }
                }
                if(iguais || divisores) prop = true;
            }
        }
        return prop;
    }
}
