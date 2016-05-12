package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.CustomerResource;
import com.ramakhutla.ethon.chapter61.conf.util.App;
import com.ramakhutla.ethon.chapter61.domain.CustomerType;
import com.ramakhutla.ethon.chapter61.factory.AddressFactory;
import com.ramakhutla.ethon.chapter61.factory.LoginFactory;
import com.ramakhutla.ethon.chapter61.repository.CustomerTypeRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.CustomerTypeRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.CustomerService;


/*
I am using the intent service why I am using it is that
I am doing normal cruds which works on the database and I dont not
need to use bound services because I am not looking for a quick respons I only
need to know data has been updated or deleted or even new data has been added.
*/
public class CustomerServiceImpl extends IntentService implements CustomerService {

    private final CustomerTypeRepository repository;

    private static final String ACTION_ADD = "com.ramakhutla.ethon.chapter61.services.impl.action.ADD";

    private static final String ACTION_DELETE = "com.ramakhutla.ethon.chapter61.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.ramakhutla.ethon.chapter61.services.impl.extra.ADD";


    private static CustomerServiceImpl service = null;

    public static CustomerServiceImpl getInstance() {
        if (service == null)
            service = new CustomerServiceImpl();
        return service;
    }

    public CustomerServiceImpl() {
        super("CustomerServiceImpl");
        repository = new CustomerTypeRepositoryImpl(App.getAppContext());

    }




    @Override
    public void addCustomer(Context context, CustomerResource customerResource) {
        Intent intent = new Intent(context, CustomerServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, customerResource);
        context.startService(intent);

    }

    @Override
    public void deleteCustomer(Context context, CustomerResource customerResource) {
        Intent intent = new Intent(context, CustomerServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final CustomerResource customerResource = (CustomerResource) intent.getSerializableExtra(EXTRA_ADD);
                saveCustomer(customerResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteCustomerRecords();
            }
        }
    }

    private void deleteCustomerRecords() {
        repository.deleteAll();
    }

    private void saveCustomer(CustomerResource customerResource) {
        CustomerType customer = new CustomerType.Builder()
                .lastName(customerResource.getLastName())
                .firstName(customerResource.getFirstName())
                .phoneNumber(customerResource.getPhoneNumber())
                //.addressEmbeddabletype(customerResource.getAddressEmbeddabletype())
                //.loginEmbeddabletype(customerResource.getLoginEmbeddabletype())
                //.rentals(customerResource.getRentalsType())
                .build();
        CustomerType saveCustomer = repository.save(customer);

    }
   }
