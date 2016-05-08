package com.ramakhutla.ethon.chapter61;

/**
 * Created by Dillin on 4/19/2016.
 */

import com.ramakhutla.ethon.chapter61.factory.AddressTest;
import com.ramakhutla.ethon.chapter61.factory.CusomerTest;
import com.ramakhutla.ethon.chapter61.factory.EnginSizeTest;
import com.ramakhutla.ethon.chapter61.factory.LoginTest;
import com.ramakhutla.ethon.chapter61.factory.PaymentTest;
import com.ramakhutla.ethon.chapter61.factory.RentalTest;
import com.ramakhutla.ethon.chapter61.factory.SalesPersonTest;
import com.ramakhutla.ethon.chapter61.factory.VehicleTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressTest.class,
        CusomerTest.class,
        EnginSizeTest.class,
        LoginTest.class,
        PaymentTest.class,
        RentalTest.class,
        //SalesPersonTest.class,
        VehicleTest.class
})

public class TestSuite {
}
