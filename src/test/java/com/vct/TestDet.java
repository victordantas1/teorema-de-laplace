package com.vct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.vct.Matriz;

@ExtendWith(MockitoExtension.class)
public class TestDet {

    @Test
    void testaMaisZeros() {
        Assertions.assertEquals(2, Matriz.meuInicializa().contaZeros());
    }

}
