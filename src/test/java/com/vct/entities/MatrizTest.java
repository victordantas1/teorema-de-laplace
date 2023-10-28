package com.vct.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MatrizTest {

    @Test
    void testaDet() {
        Matriz mt = Matriz.meuInicializa();
        mt.contaZeros();
        mt.encontraProp();
        Assertions.assertEquals(0, mt.determinante());
    }

    @Test
    void testaContaZeros() {
        Matriz mt = Matriz.meuInicializa();
        mt.contaZeros();
        Assertions.assertEquals(0, mt.getQtdZerosLinhaOuColuna());
    }

    @Test
    void testaLinhaOuColunaMaisZeros() {
        Matriz mt = Matriz.meuInicializa();
        mt.contaZeros();
        Assertions.assertTrue(mt.isLinha());
    }

    @Test
    void testaIndexMaisZeros() {
        Matriz mt = Matriz.meuInicializa();
        mt.contaZeros();
        Assertions.assertEquals(4, mt.getIndexMaisZeros());
    }

    @Test
    void testaSePropEhTrue() {
        Matriz mt = Matriz.meuInicializa();
        mt.encontraProp();
        Assertions.assertTrue(mt.isProp());
    }

    @Test
    void testaSePropEhFalse() {
        Matriz mt = Matriz.meuInicializa3por3();
        mt.encontraProp();
        Assertions.assertFalse(mt.isProp());
    }

}
