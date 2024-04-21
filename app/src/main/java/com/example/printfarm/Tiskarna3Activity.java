package com.example.printfarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.printfarm.databinding.ActivityTiskarna3Binding;

public class Tiskarna3Activity extends AppCompatActivity {


    private ActivityTiskarna3Binding binding;

    int zajic = 40;
    int kralik = 50;
    int motorka = 1;
    int motorovka = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTiskarna3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if(sharedPreferences.getInt("zajic", 0) > 40) {
            zajic = sharedPreferences.getInt("zajic", 0);
        }
        TextView cena1 = findViewById(R.id.price1);
        cena1.setText("" + zajic);

        if(sharedPreferences.getInt("kralik", 0) > 50) {
            kralik = sharedPreferences.getInt("kralik", 0);
        }
        TextView cena2 = findViewById(R.id.price2);
        cena2.setText("" + kralik);

        if(sharedPreferences.getInt("motorka", 0) > 1) {
            motorka = sharedPreferences.getInt("motorka", 0);
        }
        TextView level1 = findViewById(R.id.lvlSpeed);
        level1.setText("" + motorka);

        if(sharedPreferences.getInt("motorovka", 0) > 1) {
            motorovka = sharedPreferences.getInt("motorovka", 0);
        }
        TextView level2 = findViewById(R.id.lvlAccurasy);
        level2.setText("" + motorovka);


        ImageButton tap = findViewById(R.id.tiskranaBtn);
        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ImageButton back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("zpet");
                Intent zpetbtn = new Intent(Tiskarna3Activity.this, MainActivity.class);
                startActivity(zpetbtn);
            }
        });
        ImageButton right3 = findViewById(R.id.rightBtn);
        right3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("doprava");
                Intent rightnatiskarnuctyri = new Intent(Tiskarna3Activity.this, Tiskarna4Activity.class);
                startActivity(rightnatiskarnuctyri);
            }
        });
        ImageButton left2 = findViewById(R.id.leftBtn);
        left2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("doleva");
                Intent leftnatiskarnudva = new Intent(Tiskarna3Activity.this, Tiskarna2Activity.class);
                startActivity(leftnatiskarnudva);
            }
        });

if(motorka <= 150) {

    ImageButton lvlSpeed = findViewById(R.id.lvl1);
    lvlSpeed.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (sharedPreferences.getInt("money", 0) >= zajic) {
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("money", sharedPreferences.getInt("money", 0) - zajic);
                myEdit.commit();
                zajic *= 2;

                SharedPreferences.Editor myzajic = sharedPreferences.edit();
                myzajic.putInt("zajic", zajic);
                myzajic.commit();
                TextView cena1 = findViewById(R.id.price1);
                cena1.setText("" + sharedPreferences.getInt("zajic", 0));
                System.out.println(zajic);

                SharedPreferences.Editor mymotorka = sharedPreferences.edit();
                motorka++;
                mymotorka.putInt("motorka", motorka);
                mymotorka.commit();
                TextView level1 = findViewById(R.id.lvlSpeed);
                level1.setText("" + sharedPreferences.getInt("motorka", 0));

                System.out.println(motorka);

                myEdit.putInt("speed3", sharedPreferences.getInt("speed3", 1) * 2);
                myEdit.commit();
            } else {
                System.out.println("ses broke error");
            }


        }
    });
}
if (motorovka <= 150) {

    ImageButton lvlAccuracy = findViewById(R.id.lvl2);
    lvlAccuracy.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (sharedPreferences.getInt("money", 0) >= kralik) {
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("money", sharedPreferences.getInt("money", 0) - kralik);
                myEdit.commit();
                kralik *= 3;

                SharedPreferences.Editor mykralik = sharedPreferences.edit();
                mykralik.putInt("kralik", kralik);
                mykralik.commit();
                TextView cena2 = findViewById(R.id.price2);
                cena2.setText("" + sharedPreferences.getInt("kralik", 0));
                System.out.println(kralik);

                SharedPreferences.Editor mymotorvka = sharedPreferences.edit();
                motorovka++;
                mymotorvka.putInt("motorovka", motorovka);
                mymotorvka.commit();
                TextView level2 = findViewById(R.id.lvlAccurasy);
                level2.setText("" + sharedPreferences.getInt("motorovka", 0));

                System.out.println(motorovka);

                myEdit.putInt("acc3", sharedPreferences.getInt("acc3", 1) * 2);
                myEdit.commit();
            } else {
                System.out.println("ses broke error");
            }


        }
    });
}


    }


}