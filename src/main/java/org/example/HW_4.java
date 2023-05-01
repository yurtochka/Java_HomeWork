package org.example;//package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;

public class HW_4 {

    static ArrayList<String> surname = new ArrayList<>();
    static ArrayList<String> name = new ArrayList<>();
    static ArrayList<String> patronymic = new ArrayList<>();
    static ArrayList<Integer> age = new ArrayList<>();
    static ArrayList<Boolean> gender = new ArrayList<>();
    static LinkedList<Integer> id = new LinkedList<>();

//Вывод в консоль в формате "Иванов И.И. 32 М"
    private static String getFIOVG(int index) {
        return surname.get(index).toUpperCase().charAt(0)
                + surname.get(index).toLowerCase().substring(1) + " "
                + name.get(index).toUpperCase().charAt(0) + "."
                + patronymic.get(index).toUpperCase().charAt(0) + ". "
                + age.get(index)
                + (gender.get(index) ? " Ж" : " М");
    }

    public static void main(String[] args) throws Exception {

//читаем строки из файла
        String str1 = "";
        try {
            FileReader reader = new FileReader("text.in");
            while (reader.ready()) str1 += (char) reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] my_string = str1.toString().split("\n");
        int i = 0;
        for (int k = 0; k < my_string.length; k++) {
            String[] str = my_string[k].split(" ");
            surname.add(str[0]);
            name.add(str[1]);
            patronymic.add(str[2]);
            age.add(Integer.parseInt(str[3]));
            gender.add(str[4].contains(" "));
            id.add(k);
        }

//Сортируем по возрасту используя дополнительный список индексов.

        int cnt = id.size() - 1;
        while (cnt > -1) {
            int max_age = age.get(id.get(cnt));
            int index = cnt;
            for (int j = 0; j <= cnt; j++) {
                if (max_age < age.get(id.get(j))) {
                    max_age = age.get(id.get(j));
                    index = j;
                }
            }

            int tmp = id.get(cnt);
            id.set(cnt, id.get(index));
            id.set(index, tmp);
            cnt--;
        }

        for (int k : id) {
            System.out.println(getFIOVG(k));
        }
    }
}



