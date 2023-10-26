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
        mt.encontraProporcional();
        Assertions.assertEquals(-614, mt.determinante());
    }

    @Test
    void testaProporcional() {
        Matriz mt = Matriz.meuInicializa3por3();
        mt.encontraProporcional();
        Assertions.assertTrue(mt.isProporcional());
    }

    @Test
    void testaContaZeros() {
        Matriz mt = Matriz.meuInicializa();
        mt.contaZeros();
        Assertions.assertEquals(3, mt.getQtdZeros());
    }

    @Test
    void testaLinhaOuColuna() {
        Matriz mt = Matriz.meuInicializa();
        Assertions.assertEquals(false, mt.isLinha());
    }

    @Test
    void testaIndexMaisZeros() {
        Matriz mt = Matriz.meuInicializa();
        Assertions.assertEquals(0, mt.getIndexMaisZeros());
    }

}
