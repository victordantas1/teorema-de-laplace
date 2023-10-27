package com.vct.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VetorTest {

    @Test
    void comparaValoresLinha() {
        Matriz mt = Matriz.meuInicializa3por3();
        Vetor vet = new Vetor(mt.getTamanhoLinha());
        vet.insereMatrizNoVetLinha(mt, 0);
        Assertions.assertTrue(vet.comparaValoresLinha(mt, 0));
    }

    @Test
    void comparaValoresColuna() {
        Matriz mt = Matriz.meuInicializa3por3();
        Vetor vet = new Vetor(mt.getTamanhoLinha());
        vet.insereMatrizNoVetColuna(mt, 0);
        Assertions.assertFalse(vet.comparaValoresColuna(mt, 0));
    }

    @Test
    void insereLinha() {
        Matriz mt = Matriz.meuInicializa3por3();
        Vetor vet = new Vetor(mt.getTamanhoLinha());
        vet.insereMatrizNoVetLinha(mt, 1);
        Assertions.assertEquals(1, vet.getElemento(0));
        Assertions.assertEquals(1, vet.getElemento(1));
        Assertions.assertEquals(6, vet.getElemento(2));
    }

    @Test
    void insereColuna() {
        Matriz mt = Matriz.meuInicializa3por3();
        Vetor vet = new Vetor(mt.getTamanhoLinha());
        vet.insereMatrizNoVetColuna(mt, 1);
        Assertions.assertEquals(2, vet.getElemento(0));
        Assertions.assertEquals(1, vet.getElemento(1));
        Assertions.assertEquals(2, vet.getElemento(2));
    }

    @Test
    void comparValoresInternos() {
        Vetor vet = new Vetor(3);
        vet.setElemento(0, 1);
        vet.setElemento(1, 2);
        vet.setElemento(2, 1);
        Assertions.assertFalse(vet.comparaValoresInternos());
    }
}