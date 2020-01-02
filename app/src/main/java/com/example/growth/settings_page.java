package com.example.growth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;


public class settings_page extends AppCompatActivity {

    // For killing from another activity
    static settings_page activ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        activ = this;
    }

    public static settings_page getInstance(){
        return activ;
    }

    public void opennew(View v) {
        startActivity(new Intent(settings_page.this, setup_pass_settings.class));
    }

    public void redirect(View v){
        EditText email = (EditText)findViewById(R.id.emailtext);
        EditText phone = (EditText)findViewById(R.id.phonetext);
        EditText usern = (EditText)findViewById(R.id.userntext);

        String dataarr[] = new String[3];
        dataarr[0] = email.getText().toString();
        dataarr[1] = phone.getText().toString();
        dataarr[2] = usern.getText().toString();

        String emailpattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        String phonepattern = "[0-9]{3}-[0-9]{3}-[0-9]{4}";


        // Basic validation
        if (!dataarr[0].matches(emailpattern)){
            String txt = "Please enter a valid email.";
            updatewarningtext(txt);
        }
        else if(!dataarr[1].matches(phonepattern)){
            String txt = "Please enter your phone number in the format ###-###-####.";
            updatewarningtext(txt);
        }
        else if(dataarr[2].length() == 0){
            String txt = "Username cannot be empty.";
            updatewarningtext(txt);
        }
        else {
            // save data tmp
            opennew(v);
        }
    }

    public void updatewarningtext(String txt){
        TextView warning = findViewById(R.id.warningtext2);
        warning.setText(txt);
    }
}
