package com.example.printfarm;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

import com.example.printfarm.databinding.ActivityTiskarna1Binding;


public class NastavActivity extends AppCompatActivity {


    private ActivityTiskarna1Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTiskarna1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("zpet");
                Intent zpetbtn = new Intent(NastavActivity.this, MainActivity.class);
                startActivity(zpetbtn);
            }
        });
    }
}