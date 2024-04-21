package com.example.printfarm;

import static java.lang.Thread.sleep;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.printfarm.databinding.ActivityMainBinding;

import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int money = 0;
    private TextView moneyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        moneyTextView = findViewById(R.id.money);
        MainThreadHandler.setText(moneyTextView);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        money = sharedPreferences.getInt("money", 0);
        moneyTextView.setText(String.valueOf(money));

        ImageButton tap = findViewById(R.id.tiskranaBtn);
        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("money", sharedPreferences.getInt("money", 0) + 1 );
                myEdit.commit();
                moneyTextView.setText(sharedPreferences.getInt("money", 0) + "");
            }
        });

        ImageButton nas1 = findViewById(R.id.nastaveni);
        nas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Nastavení");
                Intent nas = new Intent(MainActivity.this, NastavActivity.class);
                startActivity(nas);
                finish();
            }
        });

        // změní scénu na scénu první tiskarny (Tiskarna1Activity)
        ImageButton tis1 = findViewById(R.id.tiskarna1);
        tis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Tiskarna 1");
                Intent oknoTiskarny1 = new Intent(MainActivity.this, Tiskarna1Activity.class);
                startActivity(oknoTiskarny1);
                finish();
            }
        });
        // změní scénu na scénu druhé tiskarny (Tiskarna2Activity)
        ImageButton tis2 = findViewById(R.id.tiskarna2);
        tis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Tiskarna 2");
                Intent oknoTiskarny2 = new Intent(MainActivity.this, Tiskarna2Activity.class);
                startActivity(oknoTiskarny2);
                finish();
            }
        });
        // změní scénu na scénu třetí tiskarny (Tiskarna3Activity)
        ImageButton tis3 = findViewById(R.id.tiskarna3);
        tis3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Tiskarna 3");
                Intent oknoTiskarny3 = new Intent(MainActivity.this, Tiskarna3Activity.class);
                startActivity(oknoTiskarny3);
                finish();
            }
        });
        // změní scénu na scénu čtvrté tiskarny (Tiskarna4Activity)
        ImageButton tis4 = findViewById(R.id.tiskarna4);
        tis4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Tiskarna 4");
                Intent oknoTiskarny4 = new Intent(MainActivity.this, Tiskarna4Activity.class);
                startActivity(oknoTiskarny4);
                finish();
            }
        });

        if (sharedPreferences.getInt("kolo", 0) >= 20) {
            tis1.setImageResource(R.drawable.printer_5);
            if(sharedPreferences.getInt("kolo", 0) >= 55) {
                tis1.setImageResource(R.drawable.printer_4);
                if(sharedPreferences.getInt("kolo", 0) >= 100) {
                    tis1.setImageResource(R.drawable.printer_3);
                    if(sharedPreferences.getInt("kolo", 0) >= 120) {
                        tis1.setImageResource(R.drawable.printer_1);
                    }
                }
            }
        }

        if (sharedPreferences.getInt("kolobezka", 0) >= 20) {
            tis2.setImageResource(R.drawable.printer_5);
            if(sharedPreferences.getInt("kolobezka", 0) >= 55) {
                tis2.setImageResource(R.drawable.printer_4);
                if(sharedPreferences.getInt("kolobezka", 0) >= 100) {
                    tis2.setImageResource(R.drawable.printer_3);
                    if(sharedPreferences.getInt("kolobezka", 0) >= 120) {
                        tis2.setImageResource(R.drawable.printer_1);
                    }
                }
            }
        }

        if (sharedPreferences.getInt("motorka", 0) >= 20) {
            tis3.setImageResource(R.drawable.printer_5);
            if(sharedPreferences.getInt("motorka", 0) >= 55) {
                tis3.setImageResource(R.drawable.printer_4);
                if(sharedPreferences.getInt("motorka", 0) >= 100) {
                    tis3.setImageResource(R.drawable.printer_3);
                    if(sharedPreferences.getInt("motorka", 0) >= 120) {
                        tis3.setImageResource(R.drawable.printer_1);
                    }
                }
            }
        }

        if (sharedPreferences.getInt("jednokolka", 0) >= 20) {
            tis4.setImageResource(R.drawable.printer_5);
            if(sharedPreferences.getInt("jednokolka", 0) >= 55) {
                tis4.setImageResource(R.drawable.printer_4);
                if(sharedPreferences.getInt("jednokolka", 0) >= 100) {
                    tis4.setImageResource(R.drawable.printer_3);
                    if(sharedPreferences.getInt("jednokolka", 0) >= 120) {
                        tis4.setImageResource(R.drawable.printer_1);
                    }
                }
            }
        }

        if (MainThreadHandler.getThread() == null) {
            MainThreadHandler.setThread(
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (true) {

                                money = sharedPreferences.getInt("money", 0);

                                money += sharedPreferences.getInt("speed1", 1);
                                money += sharedPreferences.getInt("speed2", 1);
                                money += sharedPreferences.getInt("speed3", 1);
                                money += sharedPreferences.getInt("speed4", 1);

                                money += sharedPreferences.getInt("acc1", 1);
                                money += sharedPreferences.getInt("acc2", 1);
                                money += sharedPreferences.getInt("acc3", 1);
                                money += sharedPreferences.getInt("acc4", 1);

                                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                                myEdit.putInt("money", money);
                                myEdit.commit();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        money = sharedPreferences.getInt("money", 0);
                                        String moneyStr;
                                        if (money >= 1000000) {
                                            moneyStr = (money / 1000000f) + "M";
                                        } else if (money >= 1000) {
                                            moneyStr = (money / 1000f) + "K";
                                        } else {
                                            moneyStr = String.valueOf(money);
                                        }
                                        MainThreadHandler.getText().setText(moneyStr);
                                    }
                                });
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    })
            );
            MainThreadHandler.getThread().start();

        }
    }
}