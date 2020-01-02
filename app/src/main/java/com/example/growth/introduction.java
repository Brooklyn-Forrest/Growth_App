package com.example.growth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

public class introduction extends AppCompatActivity {

    // For iteration through introduction images
    private int image;
    private int index;
    private View[] buttonlist = new View[3];
    private int amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        // Buttons to allow scrolling through preview images
        buttonlist[0] = findViewById(R.id.imagescroll1);
        buttonlist[1] = findViewById(R.id.imagescroll2);
        buttonlist[2] = findViewById(R.id.imagescroll3);

        // Preview images themselves
        int[] imagelist = new int[3];
        imagelist[0] = getResources().getIdentifier("growthappwhite", "drawable","com.example.growth");
        imagelist[1] = getResources().getIdentifier("growthapp", "drawable","com.example.growth");
        imagelist[2] = getResources().getIdentifier("blackback", "drawable","com.example.growth");


        for(int i=1; i<imagelist.length;i++){
            System.out.println("For iteration called.");
            System.out.println(i);
            // "Global" vars within the class in order to avoid using final for subclasses
            image = imagelist[i];
            index = i;

            if(i == 1){
                amount = 3000;
            }
            else if(i == 2){
                amount = 6000;
            }

            // Taking local copy values of class vars to pass at time of instantiation through for loop
            final int imagecopy = image;
            final int indexcopy = index;
            new CountDownTimer(amount, amount) {

                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    changeimage(buttonlist, imagecopy, indexcopy);
                }
            }.start();
        }
    }

    public void changeimage(View buttonlist[], int image, int index){
        ImageView img = (ImageView) findViewById(R.id.prevImage);
        img.setImageResource(image);

        // If button is in position of new image index, turn gray. Else, turn white.
        for(int v=0; v<buttonlist.length; v++){
            if(v == index){
                buttonlist[v].setBackgroundColor(getResources().getColor(android.R.color.black));
            }
            else{
                buttonlist[v].setBackgroundColor(getResources().getColor(android.R.color.white));
            }
        }
    }

    public void opennew(View v) {
        startActivity(new Intent(introduction.this, MainActivity.class));
        finish();
    }
}
