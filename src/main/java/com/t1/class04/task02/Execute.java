package com.t1.class04.task02;

import com.t1.class02.task01.QuadraticEquation;

public class Execute {
    /*
    Оформить решение квадратного уравнения в виде класса, если этого ещё не сделали.
    Сбрасывать исключение java.lang.IllegalArgumentException, если a=0.
    Сброс делать в конструкторе и в сеттере (если он есть).
    Обеспечить перехват исключения в вызываемом коде.
     */
    public static void main(String[] args) {
        try {
            QuadraticEquation equation = new QuadraticEquation(0, 0, 54);
            System.out.println(equation.getResultMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}