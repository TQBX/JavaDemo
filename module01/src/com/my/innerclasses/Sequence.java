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
    //reverseSelector implements Selector
    private class reverseSelector implements Selector{
        private int i = items.length-1;
        @Override
        public boolean end() {
            return i == -1;
        }

        @Override
        public void next() {
            if(i>-1){
                i--;
            }
        }

        @Override
        public Object current() {
            return items[i];
        }


    }
    public Selector reverseSelector(){
        return new reverseSelector();
    }

    //Upgrading to interfaces, hiding implementation details
    public Selector sequenceSelector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sq = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sq.add(Integer.toString(i));
        }
        Selector sl = sq.sequenceSelector();

        while (!sl.end()) {
            System.out.print(sl.current() + " ");
            sl.next();
        }
        System.out.println();
        Selector s2 = sq.reverseSelector();
        while(!s2.end()){
            System.out.print(s2.current()+" ");
            s2.next();
        }
    }
}

interface Selector {
    boolean end();
    void next();
    Object current();
}