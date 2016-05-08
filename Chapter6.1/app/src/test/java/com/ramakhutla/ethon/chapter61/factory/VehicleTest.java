package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.VehicleType;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Dillin on 4/19/2016.
 */
public class VehicleTest {


    @Test
    public void testCreateVehicle() throws Exception
    {
        VehicleType vehicle = VehicleFactory.getVehicle("BM34AA", "BMW", "3series", "2006", "200km", "full", "Mint ", "600ccsd", "330d", "Diesel ", null);

        Assert.assertEquals("BMW", vehicle.getMake());
    }

    @Test
    public void testUpdateVehicle() throws Exception
    {
        VehicleType vehicle = VehicleFactory.getVehicle("BM34AA", "BMW", "3series", "2006", "200km", "full", "Mint ", "600ccsd", "330d", "Diesel ", null);

        VehicleType newVehicle = new VehicleType
                .Builder()
                .copy(vehicle)
                .Model("5series")
                .build();

        Assert.assertEquals("3series", vehicle.getModel());
        Assert.assertEquals("5series", newVehicle.getModel());
    }





    /*
    @Test
    public void testCreate() throws Exception {
        Settings settings = SettingsFactory.getSettings("test@test.com","USEM");
        Assert.assertEquals("test@test.com",settings.getUsername());

    }

    @Test
    public void testUpdate() throws Exception {
        Settings settings = SettingsFactory.getSettings("test@test.com","USEM");
        Settings newSettings = new Settings
                .Builder()
                .copy(settings)
                .username("test@t.com")
                .build();
        Assert.assertEquals("test@t.com",newSettings.getUsername());
        Assert.assertEquals("USEM",newSettings.getCode());

    }*/

}
