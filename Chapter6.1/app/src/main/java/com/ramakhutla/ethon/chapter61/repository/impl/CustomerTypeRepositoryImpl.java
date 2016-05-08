package com.ramakhutla.ethon.chapter61.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ramakhutla.ethon.chapter61.conf.databases.DBConstants;
import com.ramakhutla.ethon.chapter61.domain.CustomerType;
import com.ramakhutla.ethon.chapter61.repository.CustomerTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-20.
 */
public class CustomerTypeRepositoryImpl extends SQLiteOpenHelper implements CustomerTypeRepository {

    public static final String TABLE_NAME = "customertype";
    private SQLiteDatabase db;



    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "firstName";
    public static final String COLUMN_LAST = "lastname";
    public static final String COLUMN_NUMBER = "phoneNumber";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT  NOT NULL , "
            + COLUMN_LAST + " TEXT  NOT NULL , "
            + COLUMN_NUMBER + " TEXT NOT NULL );";


    public CustomerTypeRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }



    @Override
    public CustomerType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_LAST,
                        COLUMN_NUMBER},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final CustomerType customerTypes = new CustomerType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LAST)))
                    .phoneNumber(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                    .build();

            return customerTypes;
        } else {
            return null;
        }
    }


    @Override
    public CustomerType save(CustomerType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getFirstName());
        values.put(COLUMN_LAST, entity.getLastName());
        values.put(COLUMN_NUMBER, entity.getPhoneNumber());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        CustomerType insertedEntity = new CustomerType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public CustomerType update(CustomerType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getFirstName());
        values.put(COLUMN_LAST, entity.getLastName());
        values.put(COLUMN_NUMBER, entity.getPhoneNumber());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public CustomerType delete(CustomerType entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<CustomerType> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<CustomerType> customerTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        //CustomerType customerType = null;
        if (cursor.moveToFirst()) {
            do {
                final CustomerType customerType = new CustomerType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LAST)))
                        .phoneNumber(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                        .build();
                customerTypes.add(customerType);
            } while (cursor.moveToNext());
        }
        return customerTypes;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
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


}
