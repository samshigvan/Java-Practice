package com.company.collection;

import java.util.HashMap;

import static java.lang.System.out;

public class HashCodeRule {

    //Rule is if 2 objects equals with equals method they must have same hashcode,
    // and if hashcode of 2 objects are not same then they may and may not be equal.

    int a;
    String b;

    public HashCodeRule() {
    }

    public HashCodeRule(int a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "HashCodeRule{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        HashCodeRule that = (HashCodeRule) o;
//        return a == that.a && Objects.equals(b, that.b);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(a, b);
//    }

    public static void main(String[] args) {
        HashCodeRule obj1 = new HashCodeRule(1, "abcd");
        HashCodeRule obj2 = new HashCodeRule(1, "abcd");
        HashMap<HashCodeRule, String> map= new HashMap<>();
        map.put(obj1, "abcd");
        map.put(obj2, "abcd");

        // object class Equals method checks interal reference address is same or not
        // object class hashcode method returns internal reference address
        // so if we didn't override both methods then we can use it in Hashmap as key,
        // collections based on hash will get failed to check identicale objects.

        out.println("obj1 hashcode:"+ obj1.hashCode());
        out.println("obj2 hashcode:"+ obj2.hashCode());
        out.println(map);
    }
}
