package org.example;//        1.Реализовать алгоритм обратной сортировки списков компаратором.
//        2.Пусть дан произвольный список целых чисел, удалить из него чётные числа
//        3.Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
//        4.Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
//        5.Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
//        6.Повторить пятый пункт но с LinkedList.
//        7.Сравнить время работы пятого и шестого пунктов.package org.example;

import java.util.Arrays;
import java.util.*;
import java.util.Collections;

import static java.lang.Math.round;


public class HW_3 {
    public static void main(String[] args) {


//        1 Task

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(30));
        }

        System.out.println(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);

        System.out.println("#".repeat(40));

//        2 Task

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(new Random().nextInt(30));
        }
        System.out.println(list1);

        for (int j = list1.size() - 1; j >= 0; j--) {
            if (list1.get(j) % 2 == 0)
                list1.remove(j);
        }
        System.out.println(list1);

        System.out.println("#".repeat(40));

//        3 Task
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(new Random().nextInt(30));
        }
        System.out.println(list2);
        System.out.println("Максимальное значение: " + Collections.max(list2));
        System.out.println("Минимальное значение: " + Collections.min(list2));

        int[] listArray = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            listArray[i] = list2.get(i);
        }
        double avg = Arrays.stream(listArray).average().getAsDouble();
        System.out.println("Среднее значение: " + avg);

        System.out.println("#".repeat(40));

//        4 Task

        System.out.println(list);
        System.out.println(list2);
        list2.removeAll(list);
        list.addAll(list2);
        System.out.println(list);

        System.out.println("#".repeat(40));

//        5,7 Task

        ArrayList<Integer> list3 = new ArrayList<>();
        list3 = (ArrayList<Integer>) list1.clone();

        System.out.println(list1);

        long begin = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            list1.add(0, 0);
        }
        System.out.print(list1);

        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Скорость работы с ArrayList<Integer>: " + (end - begin));

        System.out.println("#".repeat(40));

//        6,7 Task
        long begin1 = System.currentTimeMillis();

        LinkedList<Integer> int_list = new LinkedList<>();
        for (int i = 10000; i > 0; i--) {
            int_list.addFirst( 0);
        }
        int_list.addAll(list3);
        System.out.print(int_list);

        long end1 = System.currentTimeMillis();

        System.out.println();
        System.out.println("Скорость работы с LinkedList<Integer>: " + (end1 - begin1));

        System.out.println();
        float s = round((float) (end - begin) /(end1 - begin1));
        System.out.println("Скорость работы с LinkedList<Integer> быстрее, чем LinkedList<Integer> в "+ s + " раза!");
    }

}