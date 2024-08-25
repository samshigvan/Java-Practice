package com.company.collection;

import com.company.collection.pojo.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class StreamAPI {

    static int counter;

    public static void main(String[] args) {

        isStreamLazy();
//        sortMapByKeyOccurrenceInAnotherList();
    }

    public static void isStreamLazy(){
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });
        /* it will print 0, we didn't use terminal operator so stream will not execute */
        System.out.println("counter is:" + counter);


        /*
        * As we have a source of three elements, we can assume that the filter() method will be called three times,
        * and the value of the counter variable will be 3. However, running this code doesn’t change counter at all,
        * it is still zero, so the filter() method wasn’t even called once.
        * The reason why is missing of the terminal operation.
        *
        * Let’s rewrite this code a little bit by adding a map() operation and a terminal operation, findFirst().
        * We will also add the ability to track the order of method calls with the help of logging:
        * */
        Optional<String> stream2 = list.stream().filter(element -> {
            log.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            log.println("map() was called");
            return element.toUpperCase();
        }).findFirst();

    }
    public static void wasCalled(){
        counter++;
    }

    public static void simpleStream(){
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

    public static void highestOccurrence(){
        List<String> names = Arrays.asList(
                "Amaan","Ravi","Ahmad","Shafiq","Ahmad",
                "Ahmad","Amaan"
        );

        Map<String,Long> str = names.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()));
        System.out.println(str.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(2).collect(Collectors.toList()));
    }

    public static void sortMapByKeySplit(){

        Map<String, Integer> alphanumericMap = new HashMap<>();
        alphanumericMap.put("A12",1);
        alphanumericMap.put("A1",1);
        alphanumericMap.put("B10",1);
        alphanumericMap.put("B9",1);
        alphanumericMap.put("C8",1);
        alphanumericMap.put("C3",1);
        alphanumericMap.put("BD3",1);
        alphanumericMap.put("BD23",1);

        alphanumericMap.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int i = o1.getKey().split("(?<=[a-zA-Z])(?=\\d)")[0].compareTo(o2.getKey().split("(?<=[a-zA-Z])(?=\\d)")[0]);
                return i == 0? o1.getKey().split("(?<=[a-zA-Z])(?=\\d)")[1].compareTo(o2.getKey().split("(?<=[a-zA-Z])(?=\\d)")[1]) : i;
            }
        }).forEach(c -> System.out.println(c.getKey()));
    }

    public static void sortMapByKeyOccurrenceInAnotherList(){

        Map<String, Integer> map = new HashMap<>();
        map.put("abcd", 1);
        map.put("pqrst", 1);
        map.put("xyz", 1);
        map.put("lmn", 1);
        map.put("efg", 1);
        map.put("hij", 1);

        List<String> list = Arrays.asList("abcd","pqrst","xyz", "abcd", "xyz", "xyz", "lmn", "abcd", "abcd", "efg" );
        Map<String, Long> freq = list.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()));
        freq.entrySet().stream().forEach(str-> System.out.println(str.getKey() + " " + str.getValue()));

        System.out.println();

        map.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                if (!freq.containsKey(o1.getKey())){
                    return 1;
                }
                if (!freq.containsKey(o2.getKey())){
                    return -1;
                }
                return freq.get(o2.getKey()).compareTo(freq.get(o1.getKey()));
            }
        }).forEach(entry -> System.out.println(entry.getKey()));
    }

}
