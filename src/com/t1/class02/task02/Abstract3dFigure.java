package com.t1.class02.task02;

abstract class Abstract3dFigure {
    private String name;

    abstract double getVolume();

    abstract double getSurfaceArea();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
