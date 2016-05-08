package com.ramakhutla.ethon.chapter61.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ramakhutla.ethon.chapter61.conf.databases.DBConstants;
import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.EngineSizeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ethon on 4/27/2016.
 */
public class EngineSizeRepositoryImpl extends SQLiteOpenHelper implements EngineSizeRepository{

    public static final String TABLE_NAME = "enginesize";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ENGINESERIALNUMBER = "EngineSerialNumber";
    public static final String COLUMN_ENGINESIZE = "EngineSize";
    public static final String COLUMN_FUELTYPE = "FuelType";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ENGINESERIALNUMBER + " TEXT UNIQUE NOT NULL , "
            + COLUMN_ENGINESIZE + " TEXT UNIQUE NOT NULL , "
            + COLUMN_FUELTYPE + " TEXT NOT NULL );";


    public EngineSizeRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public EngineSizeEmbeddableType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ENGINESERIALNUMBER,
                        COLUMN_ENGINESIZE,
                        COLUMN_FUELTYPE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final EngineSizeEmbeddableType engineSizeEmbeddableTypes = new EngineSizeEmbeddableType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .EngineSerialNumber(cursor.getString(cursor.getColumnIndex(COLUMN_ENGINESERIALNUMBER)))
                    .EngineSize(cursor.getString(cursor.getColumnIndex(COLUMN_ENGINESIZE)))
                    .FuelType(cursor.getString(cursor.getColumnIndex(COLUMN_FUELTYPE)))
                    .build();

            return engineSizeEmbeddableTypes;
        } else {
            return null;
        }
    }

    @Override
    public EngineSizeEmbeddableType save(EngineSizeEmbeddableType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ENGINESERIALNUMBER, entity.getEngineSerialNumber());
        values.put(COLUMN_ENGINESIZE, entity.getEngineSize());
        values.put(COLUMN_FUELTYPE, entity.getFuelType());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        EngineSizeEmbeddableType insertedEntity = new EngineSizeEmbeddableType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public EngineSizeEmbeddableType update(EngineSizeEmbeddableType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ENGINESERIALNUMBER, entity.getEngineSerialNumber());
        values.put(COLUMN_ENGINESIZE, entity.getEngineSize());
        values.put(COLUMN_FUELTYPE, entity.getFuelType());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public EngineSizeEmbeddableType delete(EngineSizeEmbeddableType entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<EngineSizeEmbeddableType> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<EngineSizeEmbeddableType> engineSizeEmbeddableTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final EngineSizeEmbeddableType engineSizeEmbeddableType = new EngineSizeEmbeddableType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .EngineSerialNumber(cursor.getString(cursor.getColumnIndex(COLUMN_ENGINESERIALNUMBER)))
                        .EngineSize(cursor.getString(cursor.getColumnIndex(COLUMN_ENGINESIZE)))
                        .FuelType(cursor.getString(cursor.getColumnIndex(COLUMN_FUELTYPE)))
                        .build();
                engineSizeEmbeddableTypes.add(engineSizeEmbeddableType);
            } while (cursor.moveToNext());
        }
        return engineSizeEmbeddableTypes;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
