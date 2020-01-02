package com.example.growth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class setup_pass_settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_pass_settings);
    }

    public void cont(View v){
        String pinpattern = "[a-zA-Z0-9]{8,16}";
        EditText pininit = (EditText)findViewById(R.id.editText);
        String pinval = pininit.getText().toString();
        EditText pincheck = (EditText)findViewById(R.id.editText2);
        String pincheckval = pincheck.getText().toString();

        if(!pinval.matches(pinpattern)){
            String txt = "Invalid pin.";
            updatewarningtext(txt);
        }
        else if(!(pinval.equals(pincheckval))){
            String txt = "Pins do not match.";
            updatewarningtext(txt);
        }
        else{
            // Save data

            opennew(v);
        }
    }

    public void opennew(View v) {
        startActivity(new Intent(setup_pass_settings.this, main_view_account.class));
        settings_page.getInstance().finish();
        finish();
    }

    public void updatewarningtext(String txt){
        TextView warning = findViewById(R.id.warningpass);
        warning.setText(txt);
    }
}
