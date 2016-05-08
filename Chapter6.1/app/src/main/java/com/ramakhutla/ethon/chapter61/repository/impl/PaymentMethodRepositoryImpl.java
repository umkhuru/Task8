package com.ramakhutla.ethon.chapter61.repository.impl;

import com.ramakhutla.ethon.chapter61.conf.databases.DBConstants;
import com.ramakhutla.ethon.chapter61.domain.PaymentMethodType;
import com.ramakhutla.ethon.chapter61.repository.PaymentMethodTypeRepository;

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
public class PaymentMethodRepositoryImpl extends SQLiteOpenHelper implements PaymentMethodTypeRepository{

    public static final String TABLE_NAME = "payment";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PAYMENT = "PaymentType";
    public static final String COLUMN_PRICE = "Price";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PAYMENT + " TEXT UNIQUE NOT NULL , "
            + COLUMN_PRICE + " TEXT NOT NULL );";


    public PaymentMethodRepositoryImpl(Context context) {
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
    public PaymentMethodType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_PAYMENT,
                        COLUMN_PRICE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final PaymentMethodType paymentMethodTypes = new PaymentMethodType.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .PaymentType(cursor.getString(cursor.getColumnIndex(COLUMN_PAYMENT)))
                    .Price(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)))
                    .build();

            return paymentMethodTypes;
        } else {
            return null;
        }
    }

    @Override
    public PaymentMethodType save(PaymentMethodType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PAYMENT, entity.getPaymentType());
        values.put(COLUMN_PRICE, entity.getPrice());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        PaymentMethodType insertedEntity = new PaymentMethodType.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public PaymentMethodType update(PaymentMethodType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PAYMENT, entity.getPaymentType());
        values.put(COLUMN_PRICE, entity.getPrice());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public PaymentMethodType delete(PaymentMethodType entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<PaymentMethodType> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<PaymentMethodType> paymentMethodTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final PaymentMethodType paymentMethodType = new PaymentMethodType.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .PaymentType(cursor.getString(cursor.getColumnIndex(COLUMN_PAYMENT)))
                        .Price(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)))
                        .build();
                paymentMethodTypes.add(paymentMethodType);
            } while (cursor.moveToNext());
        }
        return paymentMethodTypes;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
