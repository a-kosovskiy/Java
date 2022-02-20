package com.t1.class02.task02;

public class Cube extends Abstract3dFigure {
    double a;

    Cube(String name, double a) {
        super.setName(name);
        this.a = a;
    }

    double volume() {
        return a * a * a;
    }


    double surfaceArea() {
        return 6 * a * a;
    }

}
