package com.vct.teoremas;

import java.util.Scanner;

public class DecLuBinet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] mat = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matriz A: ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

        escalonaMatrizSup(mat);

    }

    public static int[][] transformaMatrizSuperior(int[][] mat) {

        int[][] matSup = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j > i || i == j) matSup[i][j] = mat[i][j];
                else matSup[i][j] = 0;
            }
        }

        System.out.println("Matriz Superior");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matSup[i][j] + " ");
            }
            System.out.println("");
        }

        return matSup;

    }

    public static int[][] transformaMatrizInferior(int[][] mat) {

        int[][] matInf = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j < i) {
                    matInf[i][j] = mat[i][j];
                } else if(i == j) {
                    matInf[i][j] = 1;
                }
                else {
                    matInf[i][j] = 0;
                }
            }
        }

        System.out.println("Matriz Inferior");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matInf[i][j] + " ");
            }
            System.out.println("");
        }

        return matInf;

    }

    public static void imprimeProduto(int[][] mat1, int[][] mat2) {
        int mat[][] = new int[3][3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum = 0;
                for(int a = 0; a < 3; a++) {
                    sum += mat2[i][a] * mat1[a][j];
                }
                mat[i][j] = sum;
            }
        }

        System.out.println("Produto: ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static void escalonaMatrizSup(int[][] mat) {
        float a;
        int i, j, cont;
        a = 0;
        j = 0;
        cont = 0;
        int[] vet = new int[3];
        for (i = 0; i < 3; i++) {
            if(i < 1) a = mat[i][j];
            for (j = 0; j < 3; j++) {
                mat[i][j] /= a;
                a = (float) mat[i + 1][i] / mat[i][j];
                vet[j] = mat[i][j] * (int) a;
                if(vet[j] == 0) cont++;
                mat[i + 1][j] += -vet[j];
            }
        }

        System.out.println("Escalonada: ");

        for (int s = 0; s < 3; s++) {
            for (int p = 0; p < 3; p++) {
                System.out.print(mat[s][p] + " ");
            }
            System.out.println("");
        }

    }

  /*
    1 1 2
    3 3 2
    1 2 1

    1 1 2
    0 0 -4
    0 1 -1

   Superior
    1 1 2
    0 1 -1
    0 0 -4

   Inferior
    1 0 0
    3 1 0
    1 0 1
   */

}


