package com.t1.class02.task01;

public class QuadraticEquation {
    double a, b, c, discriminant;

    public double[] findRoots() {
        double[] roots = new double[2];
        if (this.discriminant >= 0) {
            roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
        }
        return roots;
    }

    public String getResultMessage() {
        String resultMessage;
        if (this.discriminant > 0) {
            double[] roots = this.findRoots();
            resultMessage = "Корни уравнения = " + roots[0] + ", " + roots[1];
        } else if (this.discriminant == 0) {
            resultMessage = "Корень уравнения = " + this.findRoots()[0];
        } else {
            resultMessage = "Отрицательный дискриминант - корней нет";
        }
        return resultMessage;
    }

    public QuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Коэффициент a не может быть 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.discriminant = b * b - 4 * a * c;
    }
}