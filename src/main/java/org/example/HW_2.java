/*1. Написать метод принимающий строку, ищущий в ней основание и степень.class
После этого расчитывающий результат и выводящий в консоль строку параметра + ответ.
Пример строки: "Основание -12б степень 7, результат". Попробовать с разными входящими строками.
2. Сравнить скорость работы реплейса классов String и StringBuilder.*/

package org.example;

import java.util.Arrays;
import java.util.List;


public class HW_2 {
    public static void main(String[] args) {

//  1 Задача:
        add_string("Основание -12, степень 7, результат");
        add_string("Основание 5, степень 1, результат");
        add_string("Основание 12, степень 5, результат");


        System.out.println("");
        System.out.println("");

//  2 Задача:
//  класс  String
        String method_string = "Сравнить скорость работы реплейса классов String и StringBuilder.";

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            method_string = method_string.replace(method_string, Character.getName(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("Скорость работы класса String: " + (end - begin));

//        класс  StringBuilder
        StringBuilder method_SB = new StringBuilder("Сравнить скорость работы реплейса классов String и StringBuilder.");

        long beginB = System.currentTimeMillis();
        for (int j = 0; j < 500; j++) {
            method_SB.replace(0, method_SB.length(), Character.getName(j));
        }
        long endB = System.currentTimeMillis();
        System.out.println("Скорость работы класса StringBuilder: " + (endB - beginB));

        System.out.println("Метод StringBuilder работает в " + ((end - begin) / (endB - beginB)) + " раз быстрее, чем метод String.");


    }


    public static void add_string(String in_string) {
        in_string = in_string.replaceAll("[^-?0-9]+", " ");
        List<String> my_list = Arrays.asList(in_string.trim().split(" "));

        List<Integer> new_list = my_list.stream().map(Integer::parseInt).toList();
        int my_sqrt = (int) Math.pow(new_list.get(0), new_list.get(1));
        System.out.println("Основание " + my_list.get(0) + ", степень " + my_list.get(1) + ", результат " + my_sqrt);
    }


}
