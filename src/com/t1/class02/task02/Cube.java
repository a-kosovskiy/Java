package com.t1.class02.task02;

public class Cube extends Abstract3dFigure {
    double a;

    Cube(String name, double a) {
        super.setName(name);
        this.a = a;
    }

    double getVolume() {
        return a * a * a;
    }


    double getSurfaceArea() {
        return 6 * a * a;
    }

}
