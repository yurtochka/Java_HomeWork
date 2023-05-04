package org.example;

import java.util.*;

//Создать множество, ключ и значение строки. Добавить шесть элементов. Вывести в консоль значения.
//Добавить ко всем значениям символ "!".
//Создать второе множество с таким же обобщением. Ключи второго множества частично совпадают с ключами первого.
//Объеденить значения во втором множестве и первом если ключи совподают. Вывести результат в консоль.
public class HW_5 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "first");
        map.put(2, "two");
        map.put(3, "second");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        List<String> my_list = new ArrayList<String>();
        my_list.add("!");
        for (int i = 1; i < 7; i++) {
//            map.put(i, map.get(i) + "!");
//            System.out.println(map.get(i));
            System.out.println(map.compute(i, (k, v) -> v + "!"));
        }
        System.out.println(map);
        HashMap<Integer, String> map_two = new HashMap<>();
        map_two.put(2, "два");
        map_two.put(5, "пять");
        map_two.put(7, "семь");
        for (Integer key : map_two.keySet()) {
            map_two.merge(key, "!", String::concat);
        }
        System.out.println(map_two);

        map_two.forEach((key, value) ->
                map.merge(key, value, (v1, v2) -> v1 + v2));
        System.out.println(map);
    }
}