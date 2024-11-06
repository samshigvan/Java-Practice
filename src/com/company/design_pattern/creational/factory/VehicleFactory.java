package com.company.design_pattern.creational.factory;

public class VehicleFactory {

    public Vehicle getVehicle(String vehicle){

        switch (vehicle){
            case "Ordinary":
                return new OrdinaryVehicle();
            case "Luxury":
                return new LuxuryVehicle();
            default:
                return null;
        }
    }
}
