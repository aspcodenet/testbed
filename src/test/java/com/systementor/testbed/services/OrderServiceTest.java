package com.systementor.testbed.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private OrderService sut; // System under test

    @BeforeEach
    void setupService(){
        sut = new OrderService();
    }

    @Test
    void whenOrderIsGreaterThan10000ThenFreeFreight() {
        //ARRANGE
        int orderAmount = 10001;
        int weightInGrams = 10;
        String country = "SE";

        //ACT
        int result = sut.calculateFreight(weightInGrams, country, orderAmount);

        //ASSERT
        assertEquals(0, result);
    }


    @Test
    void whenCountryIsSeAndGramsLargerThan1000Then88() {
        //ARRANGE
        int orderAmount = 110;
        int weightInGrams = 10000;
        String country = "SE";

        //ACT
        int result = sut.calculateFreight(weightInGrams, country, orderAmount);

        //ASSERT
        assertEquals(88, result);
    }

    @Test
    void whenCountryIsSeAndGramsLessOrEqual1000Then50() {
        //ARRANGE
        int orderAmount = 110;
        int weightInGrams = 300;
        String country = "SE";

        //ACT
        int result = sut.calculateFreight(weightInGrams, country, orderAmount);

        //ASSERT
        assertEquals(50, result);
    }

    @Test
    void whenCountryIsARThenFreightIs0() {
        //ARRANGE
        int orderAmount = 110;
        int weightInGrams = 300;
        String country = "AR";

        //ACT
        int result = sut.calculateFreight(weightInGrams, country, orderAmount);

        //ASSERT
        assertEquals(0, result);
    }


    @Test
    void whenCountryIsNotSwedenOrArThenFreightIs50() {
        //ARRANGE
        int orderAmount = 110;
        int weightInGrams = 300;
        String country = "FI";

        //ACT
        int result = sut.calculateFreight(weightInGrams, country, orderAmount);

        //ASSERT
        assertEquals(500, result);
    }

}
