package com.ramakhutla.ethon.chapter61.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ramakhutla.ethon.chapter61.conf.databases.DBConstants;
import com.ramakhutla.ethon.chapter61.domain.AddressEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.AddressRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ethon on 4/27/2016.
 */
public class AddressRepositoryImpl extends SQLiteOpenHelper implements AddressRepository {


    public static final String TABLE_NAME = "address";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ADDRESS = "Address";
    public static final String COLUMN_CITY = "City";
    public static final String COLUMN_POSTALCODE = "postalCode";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ADDRESS + " TEXT UNIQUE NOT NULL , "
            + COLUMN_CITY + " TEXT UNIQUE NOT NULL , "
            + COLUMN_POSTALCODE + " TEXT NOT NULL );";


    public AddressRepositoryImpl(Context context) {
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
    public AddressEmbeddableType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ADDRESS,
                        COLUMN_CITY,
                        COLUMN_POSTALCODE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final AddressEmbeddableType addressEmbeddableTypes = new AddressEmbeddableType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .Address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                    .City(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                    .postalCode(cursor.getString(cursor.getColumnIndex(COLUMN_POSTALCODE)))
                    .build();

            return addressEmbeddableTypes;
        } else {
            return null;
        }
    }

    @Override
    public AddressEmbeddableType save(AddressEmbeddableType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_CITY, entity.getCity());
        values.put(COLUMN_POSTALCODE, entity.getPostalCode());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        AddressEmbeddableType insertedEntity = new AddressEmbeddableType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public AddressEmbeddableType update(AddressEmbeddableType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_CITY, entity.getCity());
        values.put(COLUMN_POSTALCODE, entity.getPostalCode());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public AddressEmbeddableType delete(AddressEmbeddableType entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<AddressEmbeddableType> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<AddressEmbeddableType> addressEmbeddableTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final AddressEmbeddableType addressEmbeddableType = new AddressEmbeddableType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .Address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                        .City(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                        .postalCode(cursor.getString(cursor.getColumnIndex(COLUMN_POSTALCODE)))
                        .build();
                addressEmbeddableTypes.add(addressEmbeddableType);
            } while (cursor.moveToNext());
        }
        return addressEmbeddableTypes;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
