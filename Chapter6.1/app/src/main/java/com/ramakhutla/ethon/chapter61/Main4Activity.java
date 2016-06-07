package com.ramakhutla.ethon.chapter61;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.LoginRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.LoginRepositoryImpl;

import java.util.Set;

public class Main4Activity extends AppCompatActivity {

    TableLayout tl;
    TableRow tr;
    TextView usernameTextView, passwordTextView, longIdTextView;
    Set<LoginEmbeddableType> loginEmbeddableTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tl = (TableLayout)findViewById(R.id.maintable);
        Button display = (Button)findViewById(R.id.btnDisplay);
        Button home = (Button)findViewById(R.id.btnHome);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginRepository repo = new LoginRepositoryImpl(getApplicationContext());

                //Read All
                loginEmbeddableTypes = repo.findAll();
                Toast.makeText(Main4Activity.this,loginEmbeddableTypes.toString(),Toast.LENGTH_LONG).show();
                addHeaders();
                addData();
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(myIntent,0);
            }
        });
    }
    public void addHeaders()
    {
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
        TextView usercol = new TextView(this);
        usercol.setText("USERNAME");
        usercol.setTextColor(Color.GRAY);
        usercol.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        usercol.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        usercol.setPadding(5, 5, 5, 0);
        tr.addView(usercol);  // Adding textView to tablerow.

        /** Creating another textview **/
        TextView colpass = new TextView(this);
        colpass.setText("PassWord");
        colpass.setTextColor(Color.GRAY);
        colpass.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        colpass.setPadding(5, 5, 5, 0);
        colpass.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(colpass); // Adding textView to tablerow.


        /** Creating another textview **/
        TextView persanlNo = new TextView(this);
        persanlNo.setText("LongID");
        persanlNo.setTextColor(Color.GRAY);
        persanlNo.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        persanlNo.setPadding(5, 5, 5, 0);
        persanlNo.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(persanlNo); // Adding textView to tablerow.


        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));




    }

    /** This function add the data to the table **/
    public void addData()
    {
        for (LoginEmbeddableType myLogin : loginEmbeddableTypes)
        {

            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));


            /** Creating another textview **/
            usernameTextView = new TextView(this);
            usernameTextView.setText(myLogin.getUsername().toString());
            usernameTextView.setTextColor(Color.GREEN);
            usernameTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            usernameTextView.setPadding(5, 5, 5, 5);
            usernameTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(usernameTextView); // Adding textView to tablerow.*/


            /** Creating another textview **/
            passwordTextView = new TextView(this);
            passwordTextView.setText(myLogin.getPassword().toString());
            passwordTextView.setTextColor(Color.GREEN);
            passwordTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            passwordTextView.setPadding(5, 5, 5, 5);
            passwordTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(passwordTextView); // Adding textView to tablerow.*/

            /** Creating another textview **/
            longIdTextView = new TextView(this);
            longIdTextView.setText(myLogin.getId().toString());
            longIdTextView.setTextColor(Color.GREEN);
            longIdTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            longIdTextView.setPadding(5, 5, 5, 5);
            longIdTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(longIdTextView); // Adding textView to tablerow.*/

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

        }


    }





}

