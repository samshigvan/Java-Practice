package com.company.design_pattern.creational.factory;

public class OrdinaryVehicle implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Normal drive...");
    }
}
