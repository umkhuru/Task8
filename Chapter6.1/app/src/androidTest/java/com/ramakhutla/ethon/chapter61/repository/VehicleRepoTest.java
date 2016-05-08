package com.ramakhutla.ethon.chapter61.repository;

import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.VehicleType;
import com.ramakhutla.ethon.chapter61.repository.impl.VehicleTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/27/2016.
 */
public class VehicleRepoTest extends AndroidTestCase {

    private static final String TAG="VEHICLE TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        VehicleTypeRepository repo = new VehicleTypeRepositoryImpl(this.getContext());
        // CREATE
        VehicleType createEntity = new VehicleType.Builder()
                .SerialNumber("1234")
                .Make("BMW")
                .Model("3series")
                .year("2010")
                .build();

        VehicleType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<VehicleType> vehicleTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",vehicleTypes.size()>0);

        //READ ENTITY
        VehicleType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        VehicleType updateEntity = new VehicleType.Builder()
                .copy(entity)
                .year("2010")
                .build();
        repo.update(updateEntity);
        VehicleType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","2010",newEntity.getYear());

        // DELETE ENTITY
        repo.delete(updateEntity);
        VehicleType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
