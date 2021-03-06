/**
 * Copyright 1993-2010 Kingdee Software (China), Co. Ltd., All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */


package com.mongo.morphia.complex.core_dal;

import com.mongo.morphia.complex.core.BObject;
import com.mongo.morphia.complex.core_dal.exceptions.DataAccessException;



/**
 *
 * @since 2010-7-15
 * @author pl
 */
public interface DAOListener<E extends BObject> {
	
	/**
	 * @see DAO#save(BObject...)
	 */
    void preSave(E bObj) throws DataAccessException;

    /**
     * @see DAO#addNew(BObject)
     * @see DAO#addNew(BObject...)
     */
    void preAddNew(E bObj) throws DataAccessException;

    /**
     * @see DAO#update(CriteriaQuery, Updates)
     * @see DAO#update(String, Updates)
     * 
     * @param updates
     */
    void preUpdate(Updates updates) throws DataAccessException;

    /**
     * @see DAO#update(CriteriaQuery, Updates)
     */
    void preUpdate(CriteriaQuery<E> filter);

    /**
     * @see DAO#delete(CriteriaQuery)
     */
    void preDelete(CriteriaQuery<E> filter);
    
    /**
     * @see DAO#exists(String)
     */
    boolean exists(String id) throws DataAccessException;

    /**
     * @see DAO#findOne(String)
     */
    E postHandleFindOne(E bObj) throws DataAccessException;
    
    /**
     * @see DAO#count(CriteriaQuery)
     * @see DAO#findIds(CriteriaQuery)
     * @see DAO#query(CriteriaQuery)
     * @see DAO#query(CriteriaQuery, QueryCallback)
     */
    void preHandleQuery(CriteriaQuery<E> filter);
    
    /**
     * @see DAO#find(String...)
     * @see DAO#query(CriteriaQuery)
     */
    Results<E> postHandleQuery(Results<E> results) throws DataAccessException;    
}