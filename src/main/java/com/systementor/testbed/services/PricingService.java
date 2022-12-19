package com.systementor.testbed.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.systementor.testbed.model.CurrentCustomerContext;
import com.systementor.testbed.model.ProductServiceModel;
import com.systementor.testbed.model.UserAgreement;
import com.systementor.testbed.model.UserAgreementRepository;
import com.systementor.testbed.model.UserAgreementRow;
import com.systementor.testbed.model.UserAgreementRowRepository;

@Service
public class PricingService {
    private UserAgreementRepository userAgreementRepository;
    private UserAgreementRowRepository userAgreementRowRepository;

    public PricingService(UserAgreementRepository userAgreementRepository, UserAgreementRowRepository userAgreementRowRepository) {
        super();
        this.userAgreementRepository = userAgreementRepository;
        this.userAgreementRowRepository = userAgreementRowRepository;
    }

    public void CalculatePrices(Iterable<ProductServiceModel> products, CurrentCustomerContext context)
    {
        var agreementsRows = getAgreementRows(context.getUserEmail());
        for (ProductServiceModel product : products) {
            product.setPrice( calculatePrice(product,agreementsRows) );
        }
    }

    private float calculatePrice(ProductServiceModel product, ArrayList<UserAgreementRow> agreementsRows) {
        float startingPrice = product.getPrice();
        float calculatedPrice = startingPrice;
        for (UserAgreementRow userAgreementRow : agreementsRows) {
            if(appliesTo(userAgreementRow,product)){
                float discountedPrice =  calculateDiscountPrice(product,userAgreementRow);
                if(discountedPrice < calculatedPrice)
                    calculatedPrice = discountedPrice;
            }

            product.setPrice( calculatePrice(product,agreementsRows) );
        }

        return calculatedPrice;
    }

    private float calculateDiscountPrice(ProductServiceModel product, UserAgreementRow userAgreementRow) {
        return product.getPrice() * (1.0f - (userAgreementRow.getPercentageDiscount()/100.0f));
    }

    private boolean appliesTo(UserAgreementRow userAgreementRow, ProductServiceModel product) {
        if(product.getManufacturerName().toLowerCase().contains(userAgreementRow.getManufacturerMatch().toLowerCase()))
            return true;
        if(product.getProductName().toLowerCase().contains(userAgreementRow.getProductMatch().toLowerCase()))
            return true;
        if(product.getCategoryName().toLowerCase().contains(userAgreementRow.getCategoryMatch().toLowerCase()))
            return true;
        return false;
    }

    private ArrayList<UserAgreementRow> getAgreementRows(String userEmail) {
        ArrayList<UserAgreementRow> result = new ArrayList<UserAgreementRow>();
        userAgreementRepository.findByEmail(userEmail).forEach(userAgreement ->{
            userAgreementRowRepository.findByAgreementId(userAgreement.getAgreementId()).forEach(userAgreementRow ->{
                result.add(userAgreementRow);
            } );
        } );
        return result;
    }
}
