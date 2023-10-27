package com.vct;

import com.vct.entities.Matriz;

public class MainTest {

    public static void main(String[] args){
        long inicio, fim, resultado;
        int det;
        Matriz mt = Matriz.meuInicializa();
        mt.imprime();
        mt.contaZeros();
        mt.encontraProp();

        inicio = System.nanoTime();
        det = mt.determinante();
        fim = System.nanoTime();
        resultado = fim - inicio;
        System.out.println(det);
        System.out.println(resultado);
    }

}
