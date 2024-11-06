package com.company.design_pattern.behavioral.strategy;

public class SportVehicle extends Vehicle{

    SportVehicle(){
        super(new AdventureDriveStrategy());
    }

//    @Override
//    public void drive() {
//        System.out.println("Special capability drive");
//    }
}
