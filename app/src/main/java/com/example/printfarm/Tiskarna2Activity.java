package com.example.printfarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.printfarm.databinding.ActivityTiskarna2Binding;

public class Tiskarna2Activity extends AppCompatActivity {


    private ActivityTiskarna2Binding binding;
    int zubr = 40;
    int zizala = 50;
    int kolobezka = 1;
    int skate = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTiskarna2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if(sharedPreferences.getInt("zubr", 0) > 40) {
            zubr = sharedPreferences.getInt("zubr", 0);
        }
        TextView cena1 = findViewById(R.id.price1);
        cena1.setText("" + zubr);

        if(sharedPreferences.getInt("zizala", 0) > 50) {
            zizala = sharedPreferences.getInt("zizala", 0);
        }
        TextView cena2 = findViewById(R.id.price2);
        cena2.setText("" + zizala);

        if(sharedPreferences.getInt("kolobezka", 0) > 1) {
            kolobezka = sharedPreferences.getInt("kolobezka", 0);
        }
        TextView level1 = findViewById(R.id.lvlSpeed);
        level1.setText("" + kolobezka);

        if(sharedPreferences.getInt("skate", 0) > 1) {
            skate = sharedPreferences.getInt("skate", 0);
        }
        TextView level2 = findViewById(R.id.lvlAccurasy);
        level2.setText("" + skate);

        ImageButton tap = findViewById(R.id.tiskranaBtn);

        tap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                System.out.println("ahoj");
                //dopsat klikaní rovná se 2x tolik peněz
            }
        });
        ImageButton back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("zpet");
                Intent zpetbtn = new Intent(Tiskarna2Activity.this, MainActivity.class);
                startActivity(zpetbtn);
            }
        });
        ImageButton right2 = findViewById(R.id.rightBtn);
        right2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("doprava");
                Intent rightnatiskarnutri = new Intent(Tiskarna2Activity.this, Tiskarna3Activity.class);
                startActivity(rightnatiskarnutri);
            }
        });
        ImageButton left1 = findViewById(R.id.leftBtn);
        left1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("doleva");
                Intent leftnatiskarnujedna = new Intent(Tiskarna2Activity.this, Tiskarna1Activity.class);
                startActivity(leftnatiskarnujedna);
            }
        });

if (kolobezka <= 150) {

    ImageButton lvlSpeed = findViewById(R.id.lvl1);
    lvlSpeed.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (sharedPreferences.getInt("money", 0) >= zubr) {
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("money", sharedPreferences.getInt("money", 0) - zubr);
                myEdit.commit();
                zubr *= 2;

                SharedPreferences.Editor myzajic = sharedPreferences.edit();
                myzajic.putInt("zubr", zubr);
                myzajic.commit();
                TextView cena1 = findViewById(R.id.price1);
                cena1.setText("" + sharedPreferences.getInt("zubr", 0));
                System.out.println(zubr);

                SharedPreferences.Editor mymotorka = sharedPreferences.edit();
                kolobezka++;
                mymotorka.putInt("kolobezka", kolobezka);
                mymotorka.commit();
                TextView level1 = findViewById(R.id.lvlSpeed);
                level1.setText("" + sharedPreferences.getInt("kolobezka", 0));



                myEdit.putInt("speed2", sharedPreferences.getInt("speed2", 1) * 2);
                myEdit.commit();
            } else {
                System.out.println("ses broke error");
            }

        }
    });
}

if (skate <= 150) {

    ImageButton lvlAccuracy = findViewById(R.id.lvl2);
    lvlAccuracy.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (sharedPreferences.getInt("money", 0) >= zizala) {
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("money", sharedPreferences.getInt("money", 0) - zizala);
                myEdit.commit();
                zizala *= 3;

                SharedPreferences.Editor myzizala = sharedPreferences.edit();
                myzizala.putInt("zizala", zizala);
                myzizala.commit();
                TextView cena2 = findViewById(R.id.price2);
                cena2.setText("" + sharedPreferences.getInt("zizala", 0));
                System.out.println(zizala);

                SharedPreferences.Editor myskate = sharedPreferences.edit();
                skate++;
                myskate.putInt("skate", skate);
                myskate.commit();
                TextView level2 = findViewById(R.id.lvlAccurasy);
                level2.setText("" + sharedPreferences.getInt("skate", 0));



                myEdit.putInt("acc2", sharedPreferences.getInt("acc2", 1) * 2);
                myEdit.commit();
            } else {
                System.out.println("ses broke error");
            }


        }

    });

}

    }


}