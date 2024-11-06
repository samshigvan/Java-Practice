package com.company.design_pattern.behavioral.strategy;

public class OffroadVehicle extends Vehicle{

    OffroadVehicle(){
        super(new AdventureDriveStrategy());
    }

    // it is getting duplicate in offroad vehical and sport vehicle so will use drive strategy
//    @Override
//    public void drive() {
//        System.out.println("Special capability drive from child");
//    }
}
