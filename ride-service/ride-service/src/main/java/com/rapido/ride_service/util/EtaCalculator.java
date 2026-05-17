package com.rapido.ride_service.util;

public class EtaCalculator {

    public static double calculateETA(
            double distance,
            double averageSpeed) {

        return distance / averageSpeed;
    }
}