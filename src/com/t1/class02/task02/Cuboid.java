package com.t1.class02.task02;

public class Cuboid extends Abstract3dFigure {
    double a, b, c;

    Cuboid(String name, double a, double b, double c) {
        super.setName(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double volume() {
        return a * b * c;
    }


    double surfaceArea() {
        return (a * b + b * c + a * c) * 2;
    }

}
