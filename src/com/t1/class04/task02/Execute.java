package com.t1.class04.task02;

import com.t1.class02.task01.QuadraticEquation;

public class Execute {
    public static void main(String[] args) {
        try {
            QuadraticEquation equation = new QuadraticEquation(0, 0, 54);
            System.out.println(equation.getResultMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}