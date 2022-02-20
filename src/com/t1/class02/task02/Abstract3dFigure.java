package com.t1.class02.task02;

abstract class Abstract3dFigure {
    private String name;

    abstract double volume();

    abstract double surfaceArea();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
