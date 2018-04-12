package com.mweberexemple.listepersoavecviewholder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by meder on 20/12/2017.
 */

public class MainActivity extends Activity {

    //private String[] VersionArray = new String[] {};
    //private ListView monListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Création d'un nouveau tableau pour notre liste
        ArrayList<Games> gameList = new ArrayList<Games>();
        //Initialisation des données dans le tableau
        initList(gameList);

        //Instantiation de notre adapter pour créer la liste à partir du tableau
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.list_perso, gameList);
        //création de "list" qui permet de savoir où on va mettre les données
        final ListView list = (ListView) findViewById(R.id.lstJeux);
        //On met les données dans la liste
        list.setAdapter(adapter); //On applique l'adapter
        //On installe un onClick pour récupérer le clique sur élément
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            //Quand onclique sur un item :
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id)
            {
                //On crée un intent
                Intent gameIntent = new Intent(MainActivity.this, DetailActivity.class);
                //On retrouve quel item a été cliqué
                Games selectedItem = (Games) adapter.getItemAtPosition(position);
                //On récupère les données de l'item
                gameIntent.putExtra("extraGameName", selectedItem.getGameName());
                gameIntent.putExtra("extraGameAnnee", selectedItem.getGameAnnee());
                gameIntent.putExtra("extraGameDescription", selectedItem.getGameDescription());
                //On va sur sa page de détail en envoyant l'intent
                goToDetails(gameIntent);
            }
        });

    }

    private void goToDetails(Intent monIntent){
        startActivity(monIntent);
    }


    //Methode d'initialisation
    private void initList(ArrayList<Games> gameList){
        //Création d'un objet
        Games MarioGalaxy = new Games();
        //On met les valeurs
        MarioGalaxy.setGameIcon(R.drawable.mario_galaxy);
        MarioGalaxy.setGameName("Super Mario Galaxy");
        MarioGalaxy.setGameAnnee("2007");
        MarioGalaxy.setGameDescription("Mario doit parcourir l'univers pour sauver la princesse");
        //On ajoute l'objet à notre liste
        gameList.add(MarioGalaxy);

        Games GrowHome = new Games();
        GrowHome.setGameIcon(R.drawable.grow_home);
        GrowHome.setGameName("Grow Home.jpg");
        GrowHome.setGameAnnee("2015");
        GrowHome.setGameDescription("Le petit Robot BUD doit faire pousser la plante étoile afin de sauver sa planette");
        gameList.add(GrowHome);

        Games Secret = new Games();
        Secret.setGameIcon(R.drawable.card_sorcery);
        Secret.setGameName("Card Sorcery");
        Secret.setGameAnnee("2018");
        Secret.setGameDescription("ERROR : GAME NOT FOUND");
        gameList.add(Secret);

        Games DarkSouls = new Games();
        DarkSouls.setGameIcon(R.drawable.dark_souls_iii);
        DarkSouls.setGameName("Dark Souls 3");
        DarkSouls.setGameAnnee("2016");
        DarkSouls.setGameDescription("Le porte braise doit raviver la flamme dans une aventure des plus risquée");
        gameList.add(DarkSouls);

    }

}
