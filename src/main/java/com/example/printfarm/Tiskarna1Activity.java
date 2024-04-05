package com.example.printfarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.printfarm.databinding.ActivityTiskarna1Binding;


public class Tiskarna1Activity extends AppCompatActivity {


    private ActivityTiskarna1Binding binding;
    int zralok = 40;
    int zelva = 50;
    int kolo = 1;
    int auto = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTiskarna1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if(sharedPreferences.getInt("zralok", 0) > 40) {
            zralok = sharedPreferences.getInt("zralok", 0);
        }
        TextView cena1 = findViewById(R.id.price1);
        cena1.setText("" + zralok);

        if(sharedPreferences.getInt("zelva", 0) > 50) {
            zelva = sharedPreferences.getInt("zelva", 0);
        }
        TextView cena2 = findViewById(R.id.price2);
        cena2.setText("" + zelva);

        if(sharedPreferences.getInt("kolo", 0) > 1) {
            kolo = sharedPreferences.getInt("kolo", 0);
        }
        TextView level1 = findViewById(R.id.lvlSpeed);
        level1.setText("" + kolo);

        if(sharedPreferences.getInt("auto", 0) > 1) {
            auto = sharedPreferences.getInt("auto", 0);

        }
        TextView level2 = findViewById(R.id.lvlAccurasy);
        level2.setText("" + auto);


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
                Intent zpetbtn = new Intent(Tiskarna1Activity.this, MainActivity.class);
                startActivity(zpetbtn);
            }
        });
        ImageButton right1 = findViewById(R.id.rightBtn);
        right1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("doprava");
                Intent rightnatiskarnudva = new Intent(Tiskarna1Activity.this, Tiskarna2Activity.class);
                startActivity(rightnatiskarnudva);
            }
        });
        ImageButton left0 = findViewById(R.id.leftBtn);
        left0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("doleva");
                Intent leftnatiskarnuctyri = new Intent(Tiskarna1Activity.this, Tiskarna4Activity.class);
                startActivity(leftnatiskarnuctyri);
            }
        });
 if (kolo <= 150) {

     ImageButton lvlSpeed = findViewById(R.id.lvl1);
     lvlSpeed.setOnClickListener(new View.OnClickListener() {


         @Override
         public void onClick(View view) {
             if (sharedPreferences.getInt("money", 0) >= zralok) {
                 SharedPreferences.Editor myEdit = sharedPreferences.edit();
                 myEdit.putInt("money", sharedPreferences.getInt("money", 0) - zralok);
                 myEdit.commit();
                 zralok *= 2;

                 SharedPreferences.Editor myzralok = sharedPreferences.edit();
                 myzralok.putInt("zralok", zralok);
                 myzralok.commit();
                 TextView cena1 = findViewById(R.id.price1);
                 cena1.setText("" + sharedPreferences.getInt("zralok", 0));
                 System.out.println(zralok);

                 SharedPreferences.Editor mykolo = sharedPreferences.edit();
                 kolo++;
                 mykolo.putInt("kolo", kolo);
                 mykolo.commit();
                 TextView level1 = findViewById(R.id.lvlSpeed);
                 level1.setText("" + sharedPreferences.getInt("kolo", 0));


                 myEdit.putInt("speed1", sharedPreferences.getInt("speed1", 1) * 2);
                 myEdit.commit();
             } else {
                 System.out.println("ses broke error");
             }


         }
     });
 }

if (auto <= 150) {

    ImageButton lvlAccuracy = findViewById(R.id.lvl2);
    lvlAccuracy.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (sharedPreferences.getInt("money", 0) >= zelva) {
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("money", sharedPreferences.getInt("money", 0) - zelva);
                myEdit.commit();
                zelva *= 3;

                SharedPreferences.Editor myzelva = sharedPreferences.edit();
                myzelva.putInt("zelva", zelva);
                myzelva.commit();
                TextView cena2 = findViewById(R.id.price2);
                cena2.setText("" + sharedPreferences.getInt("zelva", 0));
                System.out.println(zelva);

                SharedPreferences.Editor myauto = sharedPreferences.edit();
                auto++;
                myauto.putInt("auto", auto);
                myauto.commit();
                TextView level2 = findViewById(R.id.lvlAccurasy);
                level2.setText("" + sharedPreferences.getInt("auto", 0));

                System.out.println(auto);

                myEdit.putInt("acc1", sharedPreferences.getInt("acc1", 1) * 2);
                myEdit.commit();
            } else {
                System.out.println("ses broke error");
            }


        }

    });
}



    }


}