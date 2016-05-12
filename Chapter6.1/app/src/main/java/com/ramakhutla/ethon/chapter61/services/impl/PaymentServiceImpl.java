package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.PaymentResource;
import com.ramakhutla.ethon.chapter61.conf.util.App;
import com.ramakhutla.ethon.chapter61.domain.PaymentMethodType;
import com.ramakhutla.ethon.chapter61.repository.PaymentMethodTypeRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.PaymentMethodRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.PaymentService;

/*
I am using the intent service why I am using it is that
I am doing normal cruds which works on the database and I dont not
need to use bound services because I am not looking for a quick respons I only
need to know data has been updated or deleted or even new data has been added.
*/
public class PaymentServiceImpl extends IntentService implements PaymentService{
    private final PaymentMethodTypeRepository repository;

    private static final String ACTION_ADD = "com.ramakhutla.ethon.chapter61.services.impl.action.ADD";

    private static final String ACTION_DELETE = "com.ramakhutla.ethon.chapter61.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.ramakhutla.ethon.chapter61.services.impl.extra.ADD";


    private static PaymentServiceImpl service = null;

    public static PaymentServiceImpl getInstance() {
        if (service == null)
            service = new PaymentServiceImpl();
        return service;
    }

    public PaymentServiceImpl() {
        super("PaymentServiceImpl");
        repository = new PaymentMethodRepositoryImpl(App.getAppContext());

    }

    @Override
    public void addPayment(Context context, PaymentResource paymentResource) {
        Intent intent = new Intent(context, PaymentServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, paymentResource);
        context.startService(intent);

    }

    @Override
    public void deletePayment(Context context, PaymentResource paymentResource) {
        Intent intent = new Intent(context, PaymentServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final PaymentResource paymentResource = (PaymentResource) intent.getSerializableExtra(EXTRA_ADD);
                savePayment(paymentResource);
            } else if (ACTION_DELETE.equals(action)) {
                deletePaymentRecords();
            }
        }

    }

    private void deletePaymentRecords() {
        repository.deleteAll();
    }

    private void savePayment( PaymentResource paymentResource) {
        PaymentMethodType paymentMethodType = new PaymentMethodType.Builder()
                .PaymentType(paymentResource.getPaymentType())
                .Price(paymentResource.getPrice())
                .build();
        PaymentMethodType savePayment = repository.save(paymentMethodType);

    }
}
