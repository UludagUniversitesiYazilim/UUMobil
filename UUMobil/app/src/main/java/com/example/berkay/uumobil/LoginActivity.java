package com.example.berkay.uumobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void log_in(View button){
        /*
         * =====--- LogIn button onclick event function  ---=====
         *
         *      This methods starts new activity. At least now
         *      TODO: Kullanici adi ve parolayi ve checkbox'i kontrol et!
         */

        String user_name;
        String user_password;
        EditText u_edit_text;
        EditText p_edit_text;

        u_edit_text   = (EditText) findViewById(R.id.username);
        p_edit_text   = (EditText) findViewById(R.id.password);
        user_name     = u_edit_text.getText().toString();
        user_password = p_edit_text.getText().toString();

        Intent goMain = new Intent(LoginActivity.this, MainActivity.class);

        goMain.putExtra("Username", user_name);
        goMain.putExtra("Password", user_password);

        startActivity(goMain);
        this.finish();


    }
}
