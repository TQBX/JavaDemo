package com.my.集合;

/**
 * @auther Summerday
 */

//用节点模拟LinkedList
public class LinkList {

    private int size;//节点个数
    private Node first;//头节点
    private Node last;//尾节点

    //add方法添加元素
    public void add(String str) {
        //创建一个新节点存储元素
        Node node = new Node(null, null, str);
        //如果是第一个节点，让头节点和为节点都指向这个节点
        if (size == 0) {
            this.first = this.last = node;

        } else {
            //新节点的上一位指向原尾节点
            node.prev = this.last;
            //原尾节点的下一位指向新节点
            this.last.next = node;
            //新节点变成尾节点
            this.last = node;
        }
        size++;
    }

    //插入
    public void add(int index, String str) {


        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        //判断是否为尾部追加
        if (index == size) {
            add(str);
            return;
        }
        //创建节点
        Node node = new Node(null, null, str);
        //判断是否从头部插入
        if (index == 0) {
            node.next = this.first;
            this.first.prev = node;
            this.first = node;
        } else {
            Node no = getNode(index);
            no.prev.next = node;
            node.prev = no.prev;
            node.next = no;
            no.prev = node;
        }
        size++;

    }

    //获取指定索引位置的节点
    private Node getNode(int index) {
        Node no;
        if (index < (size >> 1)) {
            no = this.first;
            int i = 0;
            while (i != index) {
                no = no.next;
                i++;
            }
            return no;
        } else {
            no = this.last;
            int i = size - 1;
            while (i != index) {
                no = no.prev;
                i--;
            }
            return no;
        }

    }


    //clear
    public void clear() {
        //第一种方式
//        this.first = this.last = null;
        //第二种方式
        //while(node.next!=null)
        //node.prev.next = null;
        //node.item = null;


        if (size > 0) {
            Node node = this.first;
            while (true) {
                node.item = null;

                node = node.next;
                if (node == null)
                    break;
                node.prev.next = null;
                node.prev = null;
            }
        }

        size = 0;
    }

    //判断是否包含指定的元素
    public boolean contains(String str) {
        return indexOf(str) != -1;
    }

    //
    private void outOfBounds(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    //获取指定下标下的元素
    public String get(int index) {
        this.outOfBounds(index);
        return this.getNode(index).item;
    }

    public int indexOf(String str) {

        Node node = this.first;
        int index = 0;
        while (index < size) {
            if (node.item == str || str != null && str.equals(node.item))
                return index;
            node = node.next;
            index++;
        }
        return -1;
    }

//    public void remove(int index) {
//        //TODO
//        if (index < 0 || index > size)
//            throw new IndexOutOfBoundsException();
//        Node no = this.getNode(index);
//        no.prev.next = no.next;
//        no.next.prev = no.prev;
//        size--;
//    }


    public void remove(int index){
        this.outOfBounds(index);
        //判断是否只有一个元素
        if(size==1){
            this.first.item = null;
            this.first = this.last = null;

        }else if(index==size-1){
            //清空最后一位数据
            this.last.item = null;
            //将last前移一位
            this.last = this.last.prev;
            //下一位为空
            this.last.next = null;
        }else if(index == 0){
            //清空第一位数据
            this.first.item =null;
            //first后移
            this.first = this.first.next;
            //first上一个节点为空
            this.first.prev = null;
        }else{
            //找到指定下标对应的元素
            Node node = getNode(index);
            //清空节点的元素
            node.item = null;
            //原节点的上一位的下一位指向源节点的下一位
            node.prev.next = node.next;
            //原节点的下一位的上一位指向源节点的上一位
            node.next.prev = node.prev;
        }
        size--;
    }
    //移除指定元素
    public void remove(String str){
        int index = this.indexOf(str);
        if(index!=-1){
            remove(index);
        }
    }
    public void set(int index,String str){
        this.outOfBounds(index);
        Node node = getNode(index);
        node.item = str;
    }
    public int size(){
        return size;
    }

    public LinkList subList(int fromIndex,int toIndex){
        //index checking
        if(fromIndex<0||toIndex>size||fromIndex>toIndex)
            throw new IllegalArgumentException();
        Node node = getNode(fromIndex);
        LinkList sub = new LinkList();
        for (int i = fromIndex; i <toIndex; i++) {
            sub.add(node.item);
            node = node.next;
        }
        return sub;
    }
    //转化为数组
    public String[] toArray(){
        String[]data = new String[size];
        Node node = first;
        for (int i = 0; i < size; i++) {
            data[i] = node.item;
            node = node.next;
        }
        return data;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node node = first;
        while(node!=null){
            sb.append(node.item).append(", ");
            node=node.next;
        }
        String str = sb.toString();
        if(size>0)
            str = str.substring(0, str.length()-2);
        str+="]";
        return str;
    }
    public int lastIndexOf(String str){
        Node node = this.last;
        int index = size-1;
        while(index>=0){
            if(node.item==str||str!=null&&str.equals(node.item))
                return index;
            node = node.prev;
            index--;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //代表节点的内部类
    private class Node {
        Node prev;//上一个元素
        Node next;//下一元素
        String item;//数据


        private Node(Node prev, Node next, String item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

}
class Test{
    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.add("天");
        l.add("乔");
        l.add(2,"巴");
        l.add("夏");

        System.out.println(l);
        System.out.println(l.contains("天"));
        System.out.println(l.get(0));
        System.out.println(l.isEmpty());
        System.out.println(l.lastIndexOf("天"));
        System.out.println(l.subList(0, 2));
        System.out.println(l.toArray());

    }
}