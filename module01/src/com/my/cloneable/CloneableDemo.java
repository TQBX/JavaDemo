package com.my.cloneable;

/**
 * @auther Summerday
 */
public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student stud1 = new Student("夏天", 18);
        Student stud2 = stud1.clone();
        System.out.println(stud1);
        System.out.println(stud2);
        System.out.println(stud1== stud2);
    }
}

class Student implements Cloneable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    protected Student clone() throws CloneNotSupportedException{
        return (Student)super.clone();
    }
}
