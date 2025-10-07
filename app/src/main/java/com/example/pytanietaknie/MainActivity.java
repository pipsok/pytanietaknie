package com.example.pytanietaknie;

import static android.view.View.INVISIBLE;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania = new ArrayList<>();
    private Button buttonTak;
    private Button buttonNie;
    private TextView textViewPytanie;
    private ImageView imageViewPytanie;
    private Button button4;
    private Button button3;
    private TextView textView4;
    private LinearLayout main;
    private int licznikpytan = 0;
    private int licznikpoprawnych = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pytania.add(new Pytanie(R.drawable.bryt, "Czy ten kot jest ladny 1", true,"ale on jest piekny"));
        pytania.add(new Pytanie(R.drawable.lysol, "Czy ten kot jest ladny 2", false,"fuj"));
        pytania.add(new Pytanie(R.drawable.syjamski, "Czy ten kot jest ladny 3", true,"piekniusi"));
        buttonNie = findViewById(R.id.buttonNie);
        buttonTak = findViewById(R.id.buttonTak);
        textViewPytanie = findViewById(R.id.textViewPytanie);
        imageViewPytanie = findViewById(R.id.imageViewPytanie);
        button4 = findViewById(R.id.button4);
        button3 = findViewById(R.id.button3);
        textView4 = findViewById(R.id.textView4);
        wyswietlPytanie(0);
        button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        licznikpytan++;
                        if(licznikpytan<pytania.size()){
                        wyswietlPytanie(licznikpytan);
                        }
                        if (licznikpytan == 4){
                            imageViewPytanie.setVisibility(INVISIBLE);
                            textViewPytanie.setVisibility(INVISIBLE);
                            button3.setVisibility(INVISIBLE);
                            button4.setVisibility(INVISIBLE);
                            buttonNie.setVisibility(INVISIBLE);
                            buttonTak.setVisibility(INVISIBLE);
                            textView4.setText("Koniec, wynik:"+licznikpoprawnych);
                        }

                    }
                }
        );
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzodpowiedz(licznikpytan, true);
                    }
                }
        );
        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzodpowiedz(licznikpytan, false);
                    }
                }
        );


    }

    private void wyswietlPytanie(int ktorePytanie){
        textViewPytanie.setText(pytania.get(ktorePytanie).getTrescpytania());
        imageViewPytanie.setImageResource(pytania.get(ktorePytanie).getIdobrazek());
        button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textView4.setText(pytania.get(ktorePytanie).getPodpowiedzi());
                    }
                }
        );
    }
    private void sprawdzodpowiedz(int ktorePytanie, boolean udzielonaOdpowiedz){
        if (pytania.get(ktorePytanie).isOdpowiedz() == udzielonaOdpowiedz){
            pytania.get(ktorePytanie).setCzyOdpOk(true);
            licznikpoprawnych++;
            Toast.makeText(this, "poprawna odp", Toast.LENGTH_SHORT).show();
        }
        else {
            pytania.get(ktorePytanie).setCzyOdpOk(false);
            Toast.makeText(this, "niepoprawna odp", Toast.LENGTH_SHORT).show();

        }
    }
}