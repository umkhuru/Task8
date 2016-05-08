package com.ramakhutla.ethon.chapter61.repository;

import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.CustomerType;
import com.ramakhutla.ethon.chapter61.repository.impl.CustomerTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/27/2016.
 */
public class CustomerRepoTest extends AndroidTestCase {

    private static final String TAG="CUSTOMER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        CustomerTypeRepository repo = new CustomerTypeRepositoryImpl(this.getContext());
        // CREATE
        CustomerType createEntity = new CustomerType.Builder()
                .lastName("ramakhutla")
                .firstName("ethan")
                .phoneNumber("0766651268")
                .build();

        CustomerType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<CustomerType> customerTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",customerTypes.size()>0);

        //READ ENTITY
        CustomerType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        CustomerType updateEntity = new CustomerType.Builder()
                .copy(entity)
                .phoneNumber("0813817755")
                .build();
        repo.update(updateEntity);
        CustomerType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","0813817755",newEntity.getPhoneNumber());

        // DELETE ENTITY
        repo.delete(updateEntity);
        CustomerType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
