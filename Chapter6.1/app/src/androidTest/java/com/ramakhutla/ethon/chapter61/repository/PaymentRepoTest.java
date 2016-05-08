package com.ramakhutla.ethon.chapter61.repository;

import android.content.Context;
import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.PaymentMethodType;
import com.ramakhutla.ethon.chapter61.repository.impl.PaymentMethodRepositoryImpl;


import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/24/2016.
 */
public class PaymentRepoTest extends AndroidTestCase {

    private static final String TAG="PAYMENT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        PaymentMethodTypeRepository repo = new PaymentMethodRepositoryImpl(this.getContext());
        // CREATE
        PaymentMethodType createEntity = new PaymentMethodType.Builder()
                .PaymentType("card")
                .Price(566.00)
                .build();

        PaymentMethodType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<PaymentMethodType> paymentMethodTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",paymentMethodTypes.size()>0);

        //READ ENTITY
        PaymentMethodType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        PaymentMethodType updateEntity = new PaymentMethodType.Builder()
                .copy(entity)
                .Price(500.00)
                .build();
        repo.update(updateEntity);
        PaymentMethodType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",500.00,newEntity.getPrice());

        // DELETE ENTITY
        repo.delete(updateEntity);
        PaymentMethodType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }


}
