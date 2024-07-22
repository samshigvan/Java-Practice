package com.company.collection;

import com.company.collection.pojo.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));


//        1- Find list of students whose first name starts with alphabet A
        System.out.println("1- Find list of students whose first name starts with alphabet A");
        List<Student> fNameStartsA = list.stream().filter(student -> student.getFirstName().startsWith("A")).collect(Collectors.toList());
        fNameStartsA.forEach(System.out::println);
        System.out.println();

//        2- Group The Student By Department Names
        System.out.println("2- Group The Student By Department Names");
        Map<String,List<Student>> groupwiseList = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        groupwiseList.forEach((key,value)-> System.out.println(key+ " "+ value));
        System.out.println();

//        3- Find the total count of student using stream
        System.out.println("3- Find the total count of student using stream");
        System.out.println(list.stream().count());
        System.out.println();

//        4- Find the max age of student
        System.out.println("4- Find the max age of student");
        System.out.println(list.stream().max((s1, s2)-> s1.getAge() - s2.getAge()));
        System.out.println(list.stream().mapToInt(Student::getAge).max());
        System.out.println();

//        5- Find all departments names
        System.out.println("5- Find all departments names");
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName)).forEach((key, value)-> System.out.println(key));
        System.out.println();
        list.stream().map(Student::getDepartmantName).collect(Collectors.toSet()).forEach(System.out::println);
        list.stream().map(Student::getDepartmantName).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();

//        6- Find the count of student in each department
        System.out.println("6- Find the count of student in each department");
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println();

//        7- Find the list of students whose age is less than 30
        System.out.println("7- Find the list of students whose age is less than 30");
        list.stream().filter(student -> student.getAge()<30).forEach(System.out::println);
        System.out.println();

//        8- Find the list of students whose rank is in between 50 and 100
        System.out.println("8- Find the list of students whose rank is in between 50 and 100");
        list.stream().filter(student -> student.getRank() > 50 && student.getRank()<100).forEach(System.out::println);
        System.out.println();

//        9- Find the average age of male and female students
        System.out.println("9- Find the average age of male and female students");
        list.stream().collect(Collectors.groupingBy(Student::getGender,  Collectors.averagingInt(Student::getAge))).forEach((key, value)-> System.out.println(key + " " + value));
        System.out.println();

//        10- Find the department who is having maximum number of students
        System.out.println("10- Find the department who is having maximum number of students");
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                        .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).ifPresent(System.out::println);
        System.out.println();

//        11- Find the Students who stays in Delhi and sort them by their names
        System.out.println("11- Find the Students who stays in Delhi and sort them by their names");
        list.stream().filter(student -> student.getCity().equals("Delhi")).sorted(Comparator.comparing(Student::getFirstName)).forEach(System.out::println);
        System.out.println();

//        12- Find the average rank in all departments
        System.out.println("12- Find the average rank in all departments");
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank))).forEach((key, value)-> System.out.println(key + " " + value));
        System.out.println();

//        13- Find the highest rank in each department
        System.out.println("13- Find the highest rank in each department");
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank)))).forEach((key, value)-> System.out.println(key + " " + value));
        System.out.println();

//        14- Find the list of students and sort them by their rank
        System.out.println("14- Find the list of students and sort them by their rank");
        list.stream().sorted(Comparator.comparing(Student::getRank)).forEach(System.out::println);
        System.out.println();

//        15- Find the student who has second rank
        System.out.println("15- Find the student who has second rank");
        list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().ifPresent(System.out::println);
        System.out.println();

    }

}
