package com.ramakhutla.ethon.chapter61.repository;

import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.RentalType;
import com.ramakhutla.ethon.chapter61.repository.impl.RentalTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/27/2016.
 */
public class RentalRepoTest extends AndroidTestCase {

    private static final String TAG="RENTAL TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        RentalTypeRepository repo = new RentalTypeRepositoryImpl(this.getContext());
        // CREATE
        RentalType createEntity = new RentalType.Builder()
                .pickUpDate("21-08-16")
                .returnDate("09-09-16")
                //.paymentMethod("card",0.9)
                .build();

        RentalType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<RentalType> rentalTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",rentalTypes.size()>0);

        //READ ENTITY
        RentalType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        RentalType updateEntity = new RentalType.Builder()
                .copy(entity)
                .returnDate("21-09-16")
                .build();
        repo.update(updateEntity);
        RentalType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","21-09-16",newEntity.getReturnDate());

        // DELETE ENTITY
        repo.delete(updateEntity);
        RentalType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
