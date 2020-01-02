package com.example.growth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean authenticate(View view){
        System.out.println("Called authentication function.");
        return true;
    }

    public void sign_in(View v){
        if(authenticate(v)){
            startActivity(new Intent(MainActivity.this, main_view_account.class));
        }
        // else (sign in failed)
    }

    public void opennew(View v) {
        startActivity(new Intent(MainActivity.this, settings_page.class));
    }
}
