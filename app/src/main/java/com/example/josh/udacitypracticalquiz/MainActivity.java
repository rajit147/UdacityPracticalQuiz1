package com.example.josh.udacitypracticalquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText username,email,description;
Button next;
SharedPreferences preferences;
    private static final String NAME_KEY = "name";
    private static final String EMAIL_KEY = "email1";
    private static final String ABOUT_KEY = "about";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info();
        next.setOnClickListener(MainActivity.this);

        if(savedInstanceState != null){
            username.setText(savedInstanceState.getString(NAME_KEY));
            email.setText(savedInstanceState.getString(EMAIL_KEY));
            description.setText(savedInstanceState.getString(ABOUT_KEY));

        }

    }
    private void info(){
        username = (EditText)findViewById(R.id.user_name);
        email = (EditText)findViewById(R.id.email);
        description = (EditText) findViewById(R.id.details);
        next = (Button) findViewById(R.id.next);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.details_Activity){
                Intent i = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(i);
                return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        String name = username.getText().toString();
        String email1 = email.getText().toString();
        String about = description.getText().toString();

        outState.putString(NAME_KEY,name);
        outState.putString(EMAIL_KEY,email1);
        outState.putString(ABOUT_KEY,about);

    }

   /* @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        username = savedInstanceState.get();

    }*/

    private void addPreferences(){
        preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NAME_KEY,username.getText().toString());
        editor.putString(EMAIL_KEY,email.getText().toString());
        editor.putString(ABOUT_KEY,description.getText().toString());
        editor.apply();

    }

    @Override
    public void onClick(View view) {
        addPreferences();
        username.getText().clear();
        email.getText().clear();
        description.getText().clear();
   Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
   startActivity(intent);
    }

}

