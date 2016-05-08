package com.ramakhutla.ethon.chapter61.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import com.ramakhutla.ethon.chapter61.conf.databases.DBConstants;
import com.ramakhutla.ethon.chapter61.domain.SalesPersonType;
import com.ramakhutla.ethon.chapter61.repository.SalesPersonTypeRepository;

/**
 * Created by Osman on 2016-04-20.
 */
public class SalesPersonTypeRepositoryImpl extends SQLiteOpenHelper implements SalesPersonTypeRepository {

    public static final String TABLE_NAME = "settings";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "firstName";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_TIME = "hours";
    public static final String COLUMN_RATE = "rate";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT UNIQUE NOT NULL , "
            + COLUMN_LASTNAME + " TEXT UNIQUE NOT NULL , "
            + COLUMN_TIME + " TEXT UNIQUE NOT NULL , "
            + COLUMN_RATE + " TEXT NOT NULL );";


    public SalesPersonTypeRepositoryImpl(Context context) {
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
    public SalesPersonType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME ,
                        COLUMN_LASTNAME,
                        COLUMN_TIME,
                        COLUMN_RATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final SalesPersonType salesPersonTypes = new SalesPersonType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                    .hours(cursor.getInt(cursor.getColumnIndex(COLUMN_TIME)))
                    .rate(cursor.getDouble(cursor.getColumnIndex(COLUMN_RATE)))
                    .build();

            return salesPersonTypes;
        } else {
            return null;
        }
    }

    @Override
    public SalesPersonType save(SalesPersonType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getFirstName());
        values.put(COLUMN_LASTNAME, entity.getLastName());
        values.put(COLUMN_TIME, entity.getHours());
        values.put(COLUMN_RATE, entity.getRate());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        SalesPersonType insertedEntity = new SalesPersonType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public SalesPersonType update(SalesPersonType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getFirstName());
        values.put(COLUMN_LASTNAME, entity.getLastName());
        values.put(COLUMN_TIME, entity.getHours());
        values.put(COLUMN_RATE, entity.getRate());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public SalesPersonType delete(SalesPersonType entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<SalesPersonType> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<SalesPersonType> salesPersonTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final SalesPersonType salesPersonType = new SalesPersonType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                        .hours(cursor.getInt(cursor.getColumnIndex(COLUMN_TIME)))
                        .rate(cursor.getDouble(cursor.getColumnIndex(COLUMN_RATE)))
                        .build();
                salesPersonTypes.add(salesPersonType);
            } while (cursor.moveToNext());
        }
        return salesPersonTypes;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
