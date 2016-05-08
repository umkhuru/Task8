package com.ramakhutla.ethon.chapter61.repository;

import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.impl.LoginRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/27/2016.
 */
public class LoginRepoTest extends AndroidTestCase {

    private static final String TAG="LOGIN TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        LoginRepository repo = new LoginRepositoryImpl(this.getContext());
        // CREATE
        LoginEmbeddableType createEntity = new LoginEmbeddableType.Builder()
                .username("211162213")
                .password("mom")
                .build();

        LoginEmbeddableType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<LoginEmbeddableType> loginEmbeddableTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",loginEmbeddableTypes.size()>0);

        //READ ENTITY
        LoginEmbeddableType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        LoginEmbeddableType updateEntity = new LoginEmbeddableType.Builder()
                .copy(entity)
                .password("dad")
                .build();
        repo.update(updateEntity);
        LoginEmbeddableType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","dad",newEntity.getPassword());

        // DELETE ENTITY
        repo.delete(updateEntity);
        LoginEmbeddableType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
