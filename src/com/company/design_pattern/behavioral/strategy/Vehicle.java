package com.company.design_pattern.behavioral.strategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
//        System.out.println("Normal drive");

        driveStrategy.drive();
    }

    public static void main(String[] args) {

        Vehicle v = new OffroadVehicle();
        v.drive();
    }
}
