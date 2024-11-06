package com.company.design_pattern.behavioral.strategy;

public class AdventureDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Special capability drive...");
    }
}
