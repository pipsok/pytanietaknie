package com.example.pytanietaknie;

import java.util.ArrayList;

public class Repozytorium {
    public static ArrayList<Pytanie>zwrocWszystkiePytania(){
        ArrayList<Pytanie> pytania = new ArrayList<>();
        pytania.add(new Pytanie(R.drawable.bryt, "Czy ten kot jest ladny 1", true,"ale on jest piekny"));
        pytania.add(new Pytanie(R.drawable.lysol, "Czy ten kot jest ladny 2", false,"fuj"));
        pytania.add(new Pytanie(R.drawable.syjamski, "Czy ten kot jest ladny 3", true,"piekniusi"));
        return pytania;
    }
}
