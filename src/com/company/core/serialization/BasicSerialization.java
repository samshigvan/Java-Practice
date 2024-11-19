package com.company.core.serialization;

import java.io.*;

public class BasicSerialization {

    public static void main(String[] args) {

        String FILE_PATH = "src/temp/abcd.txt";
        Employee e1 = new Employee("Sameer", 10000);

        System.out.println("e1.name=" + e1.getName());
        System.out.println("e1.salary=" + e1.getSalary());

        serializeObject(e1, FILE_PATH);
        deserializeObject(FILE_PATH);

    }

    private static void serializeObject(Employee emp, String file_path){
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file_path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ) {

            objectOutputStream.writeObject(emp);
            System.out.println("Employee serialized...");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deserializeObject(String file_path){

        try (
                FileInputStream fileInputStream = new FileInputStream(file_path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ){

            Employee e2 = (Employee) objectInputStream.readObject();

            System.out.println("Employee deserialized...");
            System.out.println("e2.name=" + e2.getName());
            System.out.println("e2.salary=" + e2.getSalary());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee implements Serializable{

    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee() {}

}


