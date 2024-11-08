package com.company.design_pattern.creational.abstract_factory;

public class MainClass {
    /*
    * When we want to create objects based on certain conditions with respect to their families
    * then we can use Abstract factory design pattern
    *
    * Abstract Factory is a creational design pattern that lets you produce families of
    * related objects without specifying their concrete classes.
    * */
    public static void main(String[] args) {

        FurnitureFactory factory;

        /*Configuration*/
        String style = "Modern";

        if (style.equals("Victorian"))
            factory = new VictorianFactory();
        else
            factory = new ModernFactory();
        /*Configuration end*/

        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();

        chair.sitOn();
        sofa.sleepOn();
    }
}
