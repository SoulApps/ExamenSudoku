/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examensudoku;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Sudoku {

    private final int TAM_SUDOKU = 9;
    private char[][] sudoku = new char[9][9];

    private String cadenaSudoku;
    private boolean retorno;
    private ArrayList<Point> listaCambios = new ArrayList();
    private Point lugarCambios;

    public Sudoku(String cadenaSudoku) {
        this.cadenaSudoku = cadenaSudoku;
//        char[] lista = cadenaSudoku.toCharArray();

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                for (int k = 0; k < cadenaSudoku.length(); k++) {
                    sudoku[i][j] = cadenaSudoku.charAt(k);
                }
            }
        }
    }

    public char getValue(int fila, int columna) {
        char caracterMatriz = ' ';
        caracterMatriz = sudoku[fila][columna];
        return caracterMatriz;
    }

    public boolean setValue(int fila, int columna, char valor) {
        this.sudoku = sudoku;
        lugarCambios.x = fila;
        lugarCambios.y = columna;

        if (sudoku[fila][columna] == '.') {
            if (valor <= '0' && valor == '9') {
                sudoku[fila][columna] = valor;
            }
            retorno = true;
        } else {
            retorno = false;
        }
        for (int i = 0; i < listaCambios.size(); i++) {
            listaCambios.add(i, lugarCambios);
        }
        return retorno;
    }

    public boolean isFinished() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] != '.') {
                    retorno = true;
                } else {
                    retorno = false;
                }
            }
        }
        return retorno;
    }
//    IsNumInCol

    public boolean isNumInRow(char isNumInRow) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == isNumInRow) {
                    retorno = true;
                } else {
                    retorno = false;
                }
            }
        }
        return retorno;

    }

    public boolean IsNumInCol(char IsNumInCol) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == IsNumInCol) {
                    retorno = true;
                } else {
                    retorno = false;
                }
            }
        }
        return retorno;
    }

    @Override
    public String toString() {
        int contadorFilas = 0;
        int contadorColumnas = 0;
        for (int i = 0; i < sudoku.length; i++) {
            if (contadorFilas <= 3) {
                contadorFilas++;
            } else {
                contadorFilas = 0;
            }
            for (int j = 0; j < sudoku.length; j++) {
                if (contadorColumnas <= 3) {
                    contadorColumnas++;
                } else {
                    contadorColumnas = 0;
                }
                if (contadorColumnas == 3) {
                    cadenaSudoku += " ";
                }else{
                    cadenaSudoku += String.valueOf(sudoku[i][j]);
                }
            }
            cadenaSudoku += "\n";
//            if (contadorColumnas == 3) {
//                cadenaSudoku += " ";
//            }
            cadenaSudoku += "\n";
            if (contadorFilas == 3) {
                cadenaSudoku += "\n";
            }
        }

        return cadenaSudoku;
    }

}
