package com.example.growth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_view_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_account);
    }

    public void open_act(View v){
        View buttonconf = findViewById(R.id.buttonConf);
        View buttonprogress = findViewById(R.id.buttonprogress);
        View buttongoal = findViewById(R.id.buttongoal);
        if(v.getId() == buttonconf.getId()){
            startActivity(new Intent(main_view_account.this, data_page.class));
        }
        else if(v.getId() == buttonprogress.getId()){
            startActivity(new Intent(main_view_account.this, goal_progress_overview.class));
        }
        else if(v.getId() == buttongoal.getId()){
            startActivity(new Intent(main_view_account.this, create_goal.class));
        }
    }

}
