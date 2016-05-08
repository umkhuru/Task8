package com.ramakhutla.ethon.chapter61.repository;

import java.util.Set;

/**
 * Created by Osman on 2016-04-20.
 */
public interface Repository <E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}
