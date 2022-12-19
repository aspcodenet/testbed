package com.systementor.testbed.services;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public int calculateFreight(float weightInGrams, String country, int orderAmount){
        if(orderAmount>10000) return 0;
        if(country.equals("SE") && weightInGrams > 1000 ) return 88;
        if(country.equals("SE") && weightInGrams <= 1000 ) return 50;
        if(country.equals("AR") ) return 0;
        return 500;
    }
}
