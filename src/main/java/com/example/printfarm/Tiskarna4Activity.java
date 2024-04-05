package com.example.printfarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.printfarm.databinding.ActivityTiskarna4Binding;

public class Tiskarna4Activity extends AppCompatActivity {


    private ActivityTiskarna4Binding binding;
    int zirafa = 40;
    int zebra = 50;
    int jednokolka = 1;
    int rogalo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTiskarna4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if(sharedPreferences.getInt("zirafa", 0) > 40) {
            zirafa = sharedPreferences.getInt("zirafa", 0);
        }
        TextView cena1 = findViewById(R.id.price1);
        cena1.setText("" + zirafa);

        if(sharedPreferences.getInt("zebra", 0) > 50) {
            zebra = sharedPreferences.getInt("zebra", 0);
        }
        TextView cena2 = findViewById(R.id.price2);
        cena2.setText("" + zebra);

        if(sharedPreferences.getInt("jednokolka", 0) > 1) {
            jednokolka = sharedPreferences.getInt("jednokolka", 0);
        }
        TextView level1 = findViewById(R.id.lvlSpeed);
        level1.setText("" + jednokolka);

        if(sharedPreferences.getInt("rogalo", 0) > 1) {
            rogalo = sharedPreferences.getInt("rogalo", 0);
        }
        TextView level2 = findViewById(R.id.lvlAccurasy);
        level2.setText("" + rogalo);

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
                Intent zpetbtn = new Intent(Tiskarna4Activity.this, MainActivity.class);
                startActivity(zpetbtn);
            }
        });
        ImageButton left3 = findViewById(R.id.leftBtn);
        left3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("doleva");
                Intent leftnatiskarnutri = new Intent(Tiskarna4Activity.this, Tiskarna3Activity.class);
                startActivity(leftnatiskarnutri);
            }
        });
        ImageButton right0 = findViewById(R.id.rightBtn);
        right0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("doprava");
                Intent rightnatiskarnujedna = new Intent(Tiskarna4Activity.this, Tiskarna1Activity.class);
                startActivity(rightnatiskarnujedna);
            }
        });

if (jednokolka <= 150) {

    ImageButton lvlSpeed = findViewById(R.id.lvl1);
    lvlSpeed.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (sharedPreferences.getInt("money", 0) >= zirafa) {
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("money", sharedPreferences.getInt("money", 0) - zirafa);
                myEdit.commit();
                zirafa *= 2;

                SharedPreferences.Editor myzajic = sharedPreferences.edit();
                myzajic.putInt("zirafa", zirafa);
                myzajic.commit();
                TextView cena1 = findViewById(R.id.price1);
                cena1.setText("" + sharedPreferences.getInt("zirafa", 0));
                System.out.println(zirafa);

                SharedPreferences.Editor mymotorka = sharedPreferences.edit();
                jednokolka++;
                mymotorka.putInt("jednokolka", jednokolka);
                mymotorka.commit();
                TextView level1 = findViewById(R.id.lvlSpeed);
                level1.setText("" + sharedPreferences.getInt("jednokolka", 0));

                System.out.println(jednokolka);

                myEdit.putInt("speed4", sharedPreferences.getInt("speed4", 1) * 2);
                myEdit.commit();
            } else {
                System.out.println("ses broke error");
            }

        }
    });
}

if(rogalo <= 150) {

    ImageButton lvlAccuracy = findViewById(R.id.lvl2);
    lvlAccuracy.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (sharedPreferences.getInt("money", 0) >= zebra) {
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("money", sharedPreferences.getInt("money", 0) - zebra);
                myEdit.commit();
                zebra *= 3;

                SharedPreferences.Editor myzebra = sharedPreferences.edit();
                myzebra.putInt("zebra", zebra);
                myzebra.commit();
                TextView cena2 = findViewById(R.id.price2);
                cena2.setText("" + sharedPreferences.getInt("zebra", 0));
                System.out.println(zebra);

                SharedPreferences.Editor myrogalo = sharedPreferences.edit();
                rogalo++;
                myrogalo.putInt("rogalo", rogalo);
                myrogalo.commit();
                TextView level2 = findViewById(R.id.lvlAccurasy);
                level2.setText("" + sharedPreferences.getInt("rogalo", 0));

                System.out.println(rogalo);

                myEdit.putInt("acc4", sharedPreferences.getInt("acc4", 1) * 2);
                myEdit.commit();
            } else {
                System.out.println("ses broke error");
            }

        }

    });
}


    }


}