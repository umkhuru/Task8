package com.ramakhutla.ethon.chapter61;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.LoginRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.LoginRepositoryImpl;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Button save =(Button)findViewById(R.id.btnSave);

        Intent i = getIntent();

        final LoginEmbeddableType myLoginCatch = (LoginEmbeddableType)i.getSerializableExtra("LoginValue");

        Toast.makeText(Main3Activity.this,myLoginCatch.toString(),Toast.LENGTH_LONG).show();

        EditText myEdit = (EditText)findViewById(R.id.displayAlltxt);
        myEdit.setText(myLoginCatch.toString());


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginRepository repo = new LoginRepositoryImpl(getApplicationContext());

                LoginEmbeddableType insertedEntity =repo.save(myLoginCatch);

                //Call the fourth activity
                Intent myIntent = new Intent(v.getContext(),Main4Activity.class);
                startActivity(myIntent);
            }
        });
    }
}
