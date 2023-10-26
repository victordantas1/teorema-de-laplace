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
        boolean iguais = true;
        for(int i = 0; i < mat.getTamanhoLinha(); i++) {
            for(int j = 0; j < mat.getTamanhoColuna(); j++) {
               if(i != index) {
                   if(this.getElemento(j) != mat.getValor(i, j)) {
                       iguais = false;
                   }
               }
            }
        }
        return iguais;
    }

    @Override
    public boolean comparaValoresColuna(Matriz mat, int index) {
        boolean iguais = true;
        for(int i = 0; i < mat.getTamanhoLinha(); i++) {
            for(int j = 0; j < mat.getTamanhoColuna(); j++) {
                if(i != index) {
                    if(this.getElemento(j) != mat.getValor(j, i)) {
                        iguais = false;
                    }
                }
            }
        }
        return iguais;
    }


}
