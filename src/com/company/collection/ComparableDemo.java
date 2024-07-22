package com.company.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo implements Comparable<ComparableDemo>{

    private int id;

    private String name;
    private double salary;

    // With comparable we can define only one way of sorting (sorting based on one or more property)
    // If we want multiple flavours of sorting we need to go for Comparator.
    @Override
    public int compareTo(ComparableDemo o) {
        double flag = this.id - o.id;
        if(flag == 0){
            flag = this.salary-o.salary;
        }
        return (int) flag;
    }

    @Override
    public String toString() {
        return "ComparableDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public ComparableDemo(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public ComparableDemo() {
    }


    public static void main(String[] args) {
        List<ComparableDemo> list = new ArrayList<ComparableDemo>();
        list.add(new ComparableDemo(1,"abcd", 100));
        list.add(new ComparableDemo(3,"pqrs", 300));
        list.add(new ComparableDemo(4,"xyz", 400));
        list.add(new ComparableDemo(2,"mnq", 200));
        list.add(new ComparableDemo(4,"lmn", 200));

        System.out.println(list);
        Collections.sort(list);
        System.out.println("after sort"+ list);
    }
}
