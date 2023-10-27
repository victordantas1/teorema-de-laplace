package com.vct.entities;

public interface MetodosVetor {

    boolean comparaValoresLinha(Matriz mat, int index);
    boolean comparaValoresColuna(Matriz mat, int index);
    void insereMatrizNoVetLinha(Matriz mat, int index);
    void insereMatrizNoVetColuna(Matriz mat, int index);
    boolean comparaValoresInternos();
}
