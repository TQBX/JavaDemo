package com.my.集合;

/**
 * @auther Summerday
 */
public class MyLinkedList {

    private class Node{
        String item;
        Node prev;
        Node next;

        Node(String item,Node prev,Node next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node first;
    private Node last;
    private int size;

    public void add(String str){
        Node node =new Node(str,null,null);
        if(size == 0){
            first = node;
            last = node;
        }else{
            node.prev = last;
            last.next = node;
            last = node;
        }
        size++;
    }
    public void outOfBounds(int index){
        if(index<0||index>= size){
            throw new IndexOutOfBoundsException();
        }
    }
    private Node getNode(int index){
        Node node;
        if(index<(size>>1)){
            int num = 0;
            node = first;
            while(num<index){
                node = node.next;
                num++;
            }
        }else{
            node = last;
            int num = size - 1;
            while(num>index){
                node = node.prev;
                num--;
            }
        }
        return node;
    }
    public void add(int index,String str){
        if(index>size||index<0){
            throw new IndexOutOfBoundsException();
        }
        if(index==size){
            add(str);
            return;
        }
        Node node = new Node(str, null, null);
        if(index==0){
            node.next = first;
            first.prev = node;
            first = node;
        }else{
            Node currNode = getNode(index);
            currNode.prev.next = node;
            node.prev = currNode.prev;
            node.next = currNode;
            currNode.prev = node;
        }
        size++;
    }
    public String get(int index){
        outOfBounds(index);
        return getNode(index).item;
    }
}
