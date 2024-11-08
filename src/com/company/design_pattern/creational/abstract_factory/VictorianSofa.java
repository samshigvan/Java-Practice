package com.company.design_pattern.creational.abstract_factory;

public class VictorianSofa implements Sofa{
    @Override
    public void hasLegs() {
        System.out.println("Victorian sofa has legs...");
    }

    @Override
    public void sleepOn() {
        System.out.println("You are sleeping on Victorian sofa...");
    }
}
