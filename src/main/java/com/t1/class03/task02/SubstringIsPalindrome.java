package com.t1.class03.task02;

import java.util.Arrays;

public class SubstringIsPalindrome {
    /*
    Задача 2 (средняя) - Дана строка. Найти в ней подстроку-палиндром максимальной длины.
    */
    public static void main(String[] args) {
        String string = "А роза упала на лапу Азора";

        String lcString = string.toLowerCase().replace(" ", "");
        String[][] substrings = new String[lcString.length()][lcString.length()];

        String longestSubstring = "";
        for (int i = 0; i < lcString.length(); i++) {
            for (int j = 0; j <= i; j++) {
                substrings[i][j] = lcString.substring(j, i + 1);

                if (isPalindrome(substrings[i][j]) && longestSubstring.length() < substrings[i][j].length()) {
                    longestSubstring = substrings[i][j];
                }
            }
        }
        System.out.println(longestSubstring);
    }

    static boolean isPalindrome(String string) {
        if (string.length() < 2) return false;

        char[] array = string.toCharArray();
        char[] reversedArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return Arrays.equals(array, reversedArray);
    }
}