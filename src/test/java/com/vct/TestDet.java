package com.vct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.vct.Matriz;

@ExtendWith(MockitoExtension.class)
public class TestDet {

    @Test
    void testaDet() {
        Matriz mt = Matriz.meuInicializa();
        mt.contaZeros();
        mt.encontraProporcional();
        Assertions.assertEquals(0, mt.determinante());
    }

    @Test
    void testaProporcional() {
        Matriz mt = Matriz.meuInicializa();
        Assertions.assertTrue(mt.encontraProporcional());
    }

    @Test
    void testaContaZeros() {
        Matriz mt = Matriz.meuInicializa();
        Assertions.assertEquals(3, mt.contaZeros());
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
