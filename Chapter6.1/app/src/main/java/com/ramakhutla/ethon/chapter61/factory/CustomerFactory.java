package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.CustomerType;
import com.ramakhutla.ethon.chapter61.domain.RentalType;

import java.util.List;

/**
 * Created by Dillin on 4/19/2016.
 */
public class CustomerFactory {


    public static CustomerType getCustomerType(String firstName, String lastName, String phoneNumber, String Address, String City, String postalCode, String username, String password, List<RentalType> rentalstype)
    {
        return new CustomerType.Builder()
                .lastName(lastName)
                .firstName(firstName)
                .phoneNumber(phoneNumber)
                .addressEmbeddabletype(AddressFactory.getAddressEmbeddableType(Address, City, postalCode))
                .loginEmbeddabletype(LoginFactory.getLogin(username, password))
                .rentals(rentalstype)
                .build();

    }


}
