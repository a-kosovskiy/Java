package com.t1.class02.task01;

public class Execute {
    /*
    Домашнее задание № 1 - сделать программу для решения квадратного уравнения с действительными коэффициентами.
    Рассмотреть варианты с отсутствием действительных корней, одним и двумя корнями.

    Вид уравнения: ax2 + bx + c = 0
    Дискриминант: D = b2 − 4ac
     */

    public static void main(String[] args) {
        QuadraticEquation equation = new QuadraticEquation(1, 12, 36);
        System.out.println(equation.getResultMessage());
    }
}