package com.t1.class03.task01;

import java.util.Arrays;

public class StringIsPalindrome {
    /*
    Задача 1 (простая) - Дана строка. Проверить, является ли она палиндромом.
     */
    public static void main(String[] args) {
        String string = "А роза упала на лапу Азора";
        System.out.println("Строка является палиндромом - " + isPalindrome(string));
    }

    static boolean isPalindrome(String string) {
        String lcString = string.toLowerCase().replace(" ", "");
        char[] array = lcString.toCharArray();
        char[] reversedArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return Arrays.equals(array, reversedArray);
    }
}