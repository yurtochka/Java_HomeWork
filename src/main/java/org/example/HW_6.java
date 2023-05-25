package org.example;

import java.util.*;

public class HW_6 {
    public static void main(String[] args) {
        my_Set mySet = new my_Set();
//        mySet.add(11);
        for (int i = 0; i < 5; i++) {
            mySet.add(new Random().nextInt(10));
        }
        System.out.println(mySet.my_contains(7));
        System.out.println(Arrays.toString(mySet.toArray()));

        Iterator<Integer> iterator = mySet.myIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
        System.out.println(mySet.getItem(3));
        System.out.println(mySet.getString());
    }
}

class my_Set {

//    private ArrayList<Integer> my_list = new ArrayList<>();
//    public boolean add(int number) {
//        if (my_list.contains(number)) {
//            my_list.add(number);
//            return true;
//        }
//        return false;
//    }

    static final Object OBJECT = new Object();
//    private HashMap<Integer, Object> my_map = new HashMap<>();
    private LinkedHashMap<Integer, Object> my_map = new LinkedHashMap<>();
    public boolean add(int number) {
        return my_map.put(number, OBJECT) == null;
    }

    public boolean my_contains(int number) {
        return my_map.containsKey(number);
    }

    public Object[] toArray() {
        return my_map.keySet().toArray();
    }

    public Iterator<Integer> myIterator() {
        return my_map.keySet().iterator();
    }

    public Integer getItem(int index) {
        return (Integer) toArray()[index];
    }

    public String getString(){
        return  my_map.keySet().toString();
    }
}