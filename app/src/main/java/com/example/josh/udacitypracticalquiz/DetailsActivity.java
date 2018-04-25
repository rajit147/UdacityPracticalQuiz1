package com.example.josh.udacitypracticalquiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView username,Email,About;
    SharedPreferences preferences ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        setUpvariables();
     /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/
        getDataFromSharedPreferences();
    }

    private void setUpvariables(){
        username = (TextView) findViewById(R.id.details_username);
        Email = (TextView) findViewById(R.id.details_email);
        About = (TextView) findViewById(R.id.details_description);
        toolbar = findViewById(R.id.toolbar);
    }

    private void getDataFromSharedPreferences(){
        preferences = PreferenceManager.getDefaultSharedPreferences(DetailsActivity.this);
        String name = preferences.getString("name","USER");
        String email = preferences.getString("email1","user@domain.com");
        String about  = preferences.getString("about",getResources().getString(R.string.user_info));

        username.setText(name);
        Email.setText(email);
        About.setText(about);

    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return false;
    }
}
