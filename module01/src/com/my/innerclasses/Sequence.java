package com.my.innerclasses;

/**
 * @auther Summerday
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    //The inner class can access all members of the outer class
    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        @Override
        public Object current() {
            return items[i];
        }
    }

    //Upgrading to interfaces, hiding implementation details
    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sq = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sq.add(Integer.toString(i));
        }
        Selector sl = sq.selector();

        while (!sl.end()) {
            System.out.print(sl.current() + " ");
            sl.next();
        }
    }
}

interface Selector {
    boolean end();

    void next();

    Object current();
}