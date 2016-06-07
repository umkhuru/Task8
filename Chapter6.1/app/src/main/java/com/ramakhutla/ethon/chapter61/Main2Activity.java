package com.ramakhutla.ethon.chapter61;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btnMoveData = (Button) findViewById(R.id.btnMove);

        final EditText user = (EditText) findViewById(R.id.editTextUsername);
        final EditText pass = (EditText)findViewById(R.id.editTextPassword);
        final EditText mylongId = (EditText)findViewById(R.id.editTextID);

        btnMoveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = user.getText().toString();
                String password = pass.getText().toString();
                Long longId = Long.parseLong(mylongId.getText().toString());


                LoginEmbeddableType myLogin = new LoginEmbeddableType.Builder()
                        .id(longId)
                        .username(username)
                        .password(password)
                        .build();

                Intent myIntent = new Intent(v.getContext(),Main3Activity.class);
                myIntent.putExtra("LoginValue",myLogin);

                startActivity(myIntent);
            }
        });
    }
}
