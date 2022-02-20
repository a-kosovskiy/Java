package com.t1.class02.task02;

public class Execute {
    /*
    Домашнее задание № 2 - сделать абстрактный класс «трёхмерная фигура», с методами «объём» и «площадь поверхности».
    Написать его реализации для шара, куба, прямоугольного параллепипеда.
     */
    public static void main(String[] args) {
        Abstract3dFigure[] figures = {new Cube("Куб 1", 10), new Cuboid("Параллелепипед 1", 1, 2, 3), new Sphere("Шар 1", 10)};

        for (Abstract3dFigure figure : figures) {
            System.out.println(figure.getName() + ". Объём: " + figure.volume() + "; Площадь поверхности: " + figure.surfaceArea());
        }
    }
}
