package com.example.pytanietaknie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PodpowiedzActivity2 extends AppCompatActivity {
    TextView textViewpo;
    ImageView imageViewPodpowiedz;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_podpowiedz2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<Pytanie> pytania = Repozytorium.zwrocWszystkiePytania();
        int numerPytania = getIntent().getIntExtra("numerpytania", 0);
        textViewpo = findViewById(R.id.textViewpo);
        imageViewPodpowiedz = findViewById(R.id.imageViewPodpowiedz);
        textViewpo.setText("Podpowiedz do pytania "+(numerPytania + 1)+" "+pytania.get(numerPytania).getPodpowiedzi());
        imageViewPodpowiedz.setImageResource(pytania.get(numerPytania).getIdobrazek());
    }
}