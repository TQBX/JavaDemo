package com.my.collections.practice.myLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @auther Summerday
 */
public class LinkedTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("5");
        linkedList.add("6");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("b");
        linkedList.addAll(1,arrayList);
        System.out.println(linkedList.peek());
        linkedList.add("6");
        System.out.println(linkedList.size());
        Vector<Integer> vector = new Vector<>(10,-1);
        System.out.println(vector);
    }
}
