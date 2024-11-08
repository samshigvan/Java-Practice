package com.company.design_pattern.creational.abstract_factory;

public class VictorianChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("Victorian chair legs");
    }

    @Override
    public void sitOn() {
        System.out.println("You seated on Victorian chair");
    }
}
