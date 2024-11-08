package com.company.design_pattern.creational.abstract_factory;

public class ModernChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("Modern chair legs");
    }

    @Override
    public void sitOn() {
        System.out.println("You seated on modern chair");
    }
}
