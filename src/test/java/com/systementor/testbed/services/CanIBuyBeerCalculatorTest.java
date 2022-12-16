package com.systementor.testbed.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.systementor.testbed.services.CanIBuyBeerCalculator.Location;

public class CanIBuyBeerCalculatorTest {
    @Test
    void CantBuyWhenUnder20AndOnSystemet() {
        var service = new CanIBuyBeerCalculator();
        var result = service.canIBuyBeer(Location.Systemet, 19,0);
        assertEquals(false, result);
    }
    @Test
    void CanBuyWhenOver20AndOnSystemet() {
        var service = new CanIBuyBeerCalculator();
        var result = service.canIBuyBeer(Location.Systemet, 20,0);
        assertEquals(true, result);
    }

    @Test
    void CantBuyWhenOver20AndOnSystemetButDrunk() {
        var service = new CanIBuyBeerCalculator();
        var result = service.canIBuyBeer(Location.Systemet, 25,1.6f);
        assertEquals(false, result);
    }

    @Test
    void CantBuyWhenUnder18AndOnKrogen() {
        var service = new CanIBuyBeerCalculator();
        var result = service.canIBuyBeer(Location.Krogen, 17,0);
        assertEquals(false, result);
    }
    @Test
    void CanBuyWhenOver18AndOnKrogen() {
        var service = new CanIBuyBeerCalculator();
        var result = service.canIBuyBeer(Location.Krogen, 18,0);
        assertEquals(true, result);
    }

    @Test
    void CantBuyWhenOver18AndOnKrogenButDrunk() {
        var service = new CanIBuyBeerCalculator();
        var result = service.canIBuyBeer(Location.Krogen, 25,1.6f);
        assertEquals(false, result);
    }



}
