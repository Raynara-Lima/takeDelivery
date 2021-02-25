package com.example.takedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Choose extends AppCompatActivity {
    private Switch decidir;
    private Button clique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        decidir = findViewById(R.id.switch1);
        clique = findViewById(R.id.button);

    }

    public void escolha(View v){
    if (decidir.isChecked()){
        Intent i  = new Intent(Choose.this, Business.class);
        startActivity(i);
        finish();
    }
    else{
        Intent i  = new Intent(Choose.this, Client.class);
        startActivity(i);
        finish();
    }
    }
}