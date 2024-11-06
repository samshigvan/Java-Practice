package com.company.design_pattern.behavioral.strategy;

public class NormalDriveStrategy implements DriveStrategy{


    @Override
    public void drive() {
        System.out.println("Normal drive strategy...");
    }
}
