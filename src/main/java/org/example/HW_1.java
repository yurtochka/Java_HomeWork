/*
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

Пункты реализовать в методе main
*Пункты реализовать в разных методах

int i = new Random().nextInt(k); //это кидалка случайных чисел!)*/

package org.example;

import java.util.Random;

public class HW_1 {

    public static void main(String[] dz1) {

// 1 task
        System.out.print("Случайное число: ");
        int i = new Random().nextInt(0, 2000);
        System.out.println(i);

// 2 task
        System.out.print("Номер старшего значащего бита " + i + " числа: ");
        int n = Integer.toBinaryString(i).length();
        System.out.println(n);

// 3 task
        int size_array = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) size_array++;
        }

        int[] m1 = new int[size_array];
        size_array = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[size_array] = j;
                size_array++;
            }
        }
// 4 task
        int size_array1 = 0;
        for (int j = Short.MIN_VALUE; j < 1; j++) {
            if (j % n != 0) size_array1++;
        }

        int[] m2 = new int[size_array1];
        size_array1 = 0;
        for (int j = Short.MIN_VALUE; j < 1; j++) {
            if (j % n != 0) {
                m2[size_array1] = j;
                size_array1++;
            }

        }
    }
}

