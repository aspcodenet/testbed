
package com.systementor.testbed.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.systementor.testbed.model.CurrentCustomerContext;
import com.systementor.testbed.model.ProductServiceModel;
import com.systementor.testbed.model.UserAgreement;
import com.systementor.testbed.model.UserAgreementRepository;
import com.systementor.testbed.model.UserAgreementRowRepository;

public class PricingServiceTest {
    private PricingService sut;
    private UserAgreementRepository userAgreementRepository;
    private UserAgreementRowRepository userAgreementRowRepository;
    @BeforeEach
    public void initService(){
        userAgreementRepository = mock(UserAgreementRepository.class);
        userAgreementRowRepository = mock(UserAgreementRowRepository.class);
        sut = new PricingService(userAgreementRepository, userAgreementRowRepository);
    }

    @Test
    public void should_give_baseprice_when_no_agreement(){
        //ARRANGE
        var products = new ArrayList<ProductServiceModel>(){{  
            add(new ProductServiceModel(1,"Volvo" , "XC60", "Suv", 100000));
            add(new ProductServiceModel(2,"Volvo" , "XC90", "Suv", 200000));
        }};
        var context = new CurrentCustomerContext("stefan@stefan.se", "Stefan");
        when(userAgreementRepository.findByEmail("stefan@stefan.se")).thenReturn(new ArrayList<UserAgreement>());
        //ACT
        sut.CalculatePrices(products, context);

        //ASSERT
        assertEquals(100000, products.get(0).getPrice());
        assertEquals(200000, products.get(1).getPrice());
    }    
}
