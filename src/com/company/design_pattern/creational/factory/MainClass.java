package com.company.design_pattern.creational.factory;

public class MainClass {

    public static void main(String[] args) {

        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle = factory.getVehicle("Luxury");
        vehicle.drive();
    }
}
