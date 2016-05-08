package com.ramakhutla.ethon.chapter61.repository;

import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.impl.EngineSizeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/27/2016.
 */
public class EngineRepoTest extends AndroidTestCase {

    private static final String TAG="ENGINE TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        EngineSizeRepository repo = new EngineSizeRepositoryImpl(this.getContext());
        // CREATE
        EngineSizeEmbeddableType createEntity = new EngineSizeEmbeddableType.Builder()
                .EngineSerialNumber("1234")
                .EngineSize("m3")
                .FuelType("petrol")
                .build();

        EngineSizeEmbeddableType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<EngineSizeEmbeddableType> engineSizeEmbeddableTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",engineSizeEmbeddableTypes.size()>0);

        //READ ENTITY
        EngineSizeEmbeddableType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        EngineSizeEmbeddableType updateEntity = new EngineSizeEmbeddableType.Builder()
                .copy(entity)
                .EngineSize("m4")
                .build();
        repo.update(updateEntity);
        EngineSizeEmbeddableType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","m4",newEntity.getEngineSize());

        // DELETE ENTITY
        repo.delete(updateEntity);
        EngineSizeEmbeddableType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
