package com.ramakhutla.ethon.chapter61.repository.impl;

import com.ramakhutla.ethon.chapter61.conf.databases.DBConstants;
import com.ramakhutla.ethon.chapter61.domain.VehicleType;
import com.ramakhutla.ethon.chapter61.repository.VehicleTypeRepository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;
/**
 * Created by Osman on 2016-04-20.
 */
public class VehicleTypeRepositoryImpl extends SQLiteOpenHelper implements VehicleTypeRepository{

    public static final String TABLE_NAME = "vehicle";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SERIALNUMBER = "SerialNumber";
    public static final String COLUMN_MAKE = "Make";
    public static final String COLUMN_MODEL = "Model";
    public static final String COLUMN_YEAR = "year";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SERIALNUMBER + " TEXT UNIQUE NOT NULL , "
            + COLUMN_MAKE + " TEXT UNIQUE NOT NULL , "
            + COLUMN_MODEL + " TEXT UNIQUE NOT NULL , "
            + COLUMN_YEAR + " TEXT NOT NULL );";


    public VehicleTypeRepositoryImpl(Context context) {
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
    public VehicleType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_SERIALNUMBER,
                        COLUMN_MAKE,
                        COLUMN_MODEL,
                        COLUMN_YEAR},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final VehicleType vehicleTypes;
            vehicleTypes = new VehicleType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .SerialNumber(cursor.getString(cursor.getColumnIndex(COLUMN_SERIALNUMBER)))
                    .Make(cursor.getString(cursor.getColumnIndex(COLUMN_MAKE)))
                    .Model(cursor.getString(cursor.getColumnIndex(COLUMN_MODEL)))
                    .year(cursor.getString(cursor.getColumnIndex(COLUMN_YEAR)))
                    .build();

            return vehicleTypes;
        } else {
            return null;
        }
    }

    @Override
    public VehicleType save(VehicleType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_SERIALNUMBER, entity.getSerialNumber());
        values.put(COLUMN_MAKE, entity.getMake());
        values.put(COLUMN_MODEL, entity.getModel());
        values.put(COLUMN_YEAR, entity.getYear());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        VehicleType insertedEntity = new VehicleType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public VehicleType update(VehicleType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_SERIALNUMBER, entity.getSerialNumber());
        values.put(COLUMN_MAKE, entity.getMake());
        values.put(COLUMN_MODEL, entity.getModel());
        values.put(COLUMN_YEAR, entity.getYear());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public VehicleType delete(VehicleType entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<VehicleType> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<VehicleType> vehicleTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final VehicleType vehicleType = new VehicleType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .SerialNumber(cursor.getString(cursor.getColumnIndex(COLUMN_SERIALNUMBER)))
                        .Make(cursor.getString(cursor.getColumnIndex(COLUMN_MAKE)))
                        .Model(cursor.getString(cursor.getColumnIndex(COLUMN_MODEL)))
                        .year(cursor.getString(cursor.getColumnIndex(COLUMN_YEAR)))
                        .build();
                vehicleTypes.add(vehicleType);
            } while (cursor.moveToNext());
        }
        return vehicleTypes;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
