package com.ibrahimatay;

/*

JEP 409: Sealed Classes
https://openjdk.org/jeps/409
 */

import java.util.UUID;

public class JEP409SealedClasses {
    public static void main(String[] args) {
        System.out.println(getNumberOfSeats(new Truck(100, UUID.randomUUID().toString())));
        System.out.println(getNumberOfSeats(new Car(20, UUID.randomUUID().toString())));
    }

    static int getNumberOfSeats(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return ((Car) vehicle).getNumberOfSeats();
        } else if (vehicle instanceof Truck) {
            return ((Truck) vehicle).getLoadCapacity();
        } else {
            throw new RuntimeException("Unknown instance of Vehicle");
        }
    }
}

sealed interface Vehicle permits Car, Truck {
    String getRegistrationNumber();
}

record Car(int numberOfSeats, String registrationNumber) implements Vehicle {

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}

record Truck(int loadCapacity, String registrationNumber) implements Vehicle {

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
}