package com.ramakhutla.ethon.chapter61.repository;

import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.AddressEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.impl.AddressRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/27/2016.
 */
public class AddressRepoTest extends AndroidTestCase {

    private static final String TAG="ADDRESS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        AddressRepository repo = new AddressRepositoryImpl(this.getContext());
        // CREATE
        AddressEmbeddableType createEntity = new AddressEmbeddableType.Builder()
                .Address("e15-9th ave")
                .City("oranjemund")
                .postalCode("1624")
                .build();

        AddressEmbeddableType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<AddressEmbeddableType> addressEmbeddableTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",addressEmbeddableTypes.size()>0);

        //READ ENTITY
        AddressEmbeddableType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        AddressEmbeddableType updateEntity = new AddressEmbeddableType.Builder()
                .copy(entity)
                .postalCode("1625")
                .build();
        repo.update(updateEntity);
        AddressEmbeddableType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","1625",newEntity.getPostalCode());

        // DELETE ENTITY
        repo.delete(updateEntity);
        AddressEmbeddableType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }


}
