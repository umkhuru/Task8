package com.ramakhutla.ethon.chapter61.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ramakhutla.ethon.chapter61.conf.databases.DBConstants;
import com.ramakhutla.ethon.chapter61.domain.RentalType;
import com.ramakhutla.ethon.chapter61.repository.RentalTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-20.
 */
public class RentalTypeRepositoryImpl extends SQLiteOpenHelper implements RentalTypeRepository {

    public static final String TABLE_NAME = "rentals";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PICKUP = "pickUpDate";
    public static final String COLUMN_RETURN = "returnDate";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PICKUP + " TEXT UNIQUE NOT NULL , "
            + COLUMN_RETURN + " TEXT NOT NULL );";


    public RentalTypeRepositoryImpl(Context context) {
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
    public RentalType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_PICKUP,
                        COLUMN_RETURN},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final RentalType rentalTypes = new RentalType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .pickUpDate(cursor.getString(cursor.getColumnIndex(COLUMN_PICKUP)))
                    .returnDate(cursor.getString(cursor.getColumnIndex(COLUMN_RETURN)))
                    .build();

            return rentalTypes;
        } else {
            return null;
        }
    }

    @Override
    public RentalType save(RentalType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PICKUP, entity.getPickUpDate());
        values.put(COLUMN_RETURN, entity.getReturnDate());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        RentalType insertedEntity = new RentalType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public RentalType update(RentalType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PICKUP, entity.getPickUpDate());
        values.put(COLUMN_RETURN, entity.getReturnDate());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public RentalType delete(RentalType entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<RentalType> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<RentalType> rentalTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final RentalType rentalType = new RentalType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .pickUpDate(cursor.getString(cursor.getColumnIndex(COLUMN_PICKUP)))
                        .returnDate(cursor.getString(cursor.getColumnIndex(COLUMN_RETURN)))
                        .build();
                rentalTypes.add(rentalType);
            } while (cursor.moveToNext());
        }
        return rentalTypes;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }


}
