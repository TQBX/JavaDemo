package com.my.base;

/**
 * @auther Summerday
 */
public class Person {

    private String name;
    private int age;
    public String ID;




    public Person(){
    }
    public Person(int age, String name,String ID) {
        this.age = age;
        this.name = name;
        this.ID = ID;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ID='" + ID + '\'' +
                '}';
    }

    public void doS(){
        System.out.println("Person.doS");
    }

    public void doS(String thing){
        System.out.println("do"+thing);
    }
}
