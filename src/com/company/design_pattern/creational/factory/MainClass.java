package com.company.design_pattern.creational.factory;

public class MainClass {
    /*
    * When we want to create objects based on certain conditions
    * then we can useqq:q Factory design patter
    * */
    public static void main(String[] args) {


        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle = factory.getVehicle("Luxury");
        vehicle.drive();
    }
}
