package com.mongo.morphia.complex.core_dal.datasource.impl;

/**
 * Copyright 1993-2010 Kingdee , Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mongo.morphia.complex.core_dal.datasource.DataSource;
import com.mongo.morphia.complex.core_dal.datasource.DataSourceException;
import com.mongo.morphia.complex.core_dal.datasource.MongoFactory;
import com.mongo.morphia.complex.core_dal.datasource.PersistenceUnitInfo;
import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * 
 * @since 2010-6-8
 * @author guolei_mao
 */
public class DataSourceImpl implements DataSource {
    private static Logger logger = LoggerFactory.getLogger(DataSourceImpl.class);
    
    private PersistenceUnitInfo pu;

    public DataSourceImpl(PersistenceUnitInfo pu) {
        this.pu = pu;
    }

    @Override
    public Mongo getMongo() throws DataSourceException {
        return MongoFactory.getMongo(pu.getMongoUrl());
    }

    @Override
    public DB getDB() throws DataSourceException {
        return MongoFactory.getDB(pu.getMongoUrl(), pu.getMongoDbName());
    }
}
