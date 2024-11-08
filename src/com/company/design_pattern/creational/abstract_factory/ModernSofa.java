package com.company.design_pattern.creational.abstract_factory;

public class ModernSofa implements Sofa{
    @Override
    public void hasLegs() {
        System.out.println("Modern sofa has legs...");
    }

    @Override
    public void sleepOn() {
        System.out.println("You are sleeping on modern sofa...");
    }
}
