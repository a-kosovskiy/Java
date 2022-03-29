package com.t1.class04.task01;

public class Student implements Comparable<Student> {
    String gradeAndName;
    Integer grade;
    String name;

    public Student(String gradeAndName) {
        this.gradeAndName = gradeAndName;
        String[] strings = gradeAndName.split(" ");
        this.grade = Integer.parseInt(strings[0]);
        this.name = strings[1];
    }

    @Override
    public int compareTo(Student student) {
        String[] strings = student.gradeAndName.split(" ");
        Integer grade = Integer.parseInt(strings[0]);
        String name = strings[1];
        if (grade == this.grade) {
            return this.name.compareToIgnoreCase(name);
        } else {
            return this.grade.compareTo(grade);
        }
    }
}