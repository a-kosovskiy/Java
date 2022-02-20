package com.t1.class04.task01;

import java.util.ArrayList;
import java.util.List;

public class Execute {
    /*
     Задача: программа на вход получает список школьников следующего вида:
    9 Иванов
    10 Петров
    11 Сидоров
    9 Григорьев
    9 Сергеев
    10 Яковлев
    В каждой строке сначала записан номер класса (число, равное 9, 10 или 11), затем (через пробел) – фамилия.
    Необходимо вывести список по классам: сначала всех учащихся 1 класса, затем – 2, и так до 11.
    Внутри класса выводить список учеников по алфавиту.
     */

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("9 Иванов"));
        students.add(new Student("10 Петров"));
        students.add(new Student("11 Сидоров"));
        students.add(new Student("9 Григорьев"));
        students.add(new Student("9 Сергеев"));
        students.add(new Student("10 Яковлев"));
        students.sort(Student::compareTo);
        for (Student student : students) {
            System.out.println(student.gradeAndName);
        }
    }
}