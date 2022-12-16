package com.systementor.testbed.services;

import org.springframework.stereotype.Service;

@Service
public class CanIBuyBeerCalculator {
    public enum Location {
        Krogen,
        Systemet
    }
    public boolean canIBuyBeer(Location location, int age, float promille){
        if(promille >= 1.5) return false;
        if(location == Location.Krogen && age < 18) return false;
        if(location == Location.Systemet && age < 20) return false;
        return true;
    }
}
