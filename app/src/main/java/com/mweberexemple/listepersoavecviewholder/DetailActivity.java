package com.mweberexemple.listepersoavecviewholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by meder on 18/02/2018.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_detail);

        //On récupère nos views
        TextView txtNom = (TextView) findViewById(R.id.lblNom);
        TextView txtAnnee = (TextView) findViewById(R.id.lblAnnee);
        TextView txtDescription = (TextView) findViewById(R.id.lblDescription);

        //On récupère l'intent
        Intent monIntent = getIntent();
        //On récupère les données de l'extra
        String gameName = String.format("Nom : %s",  monIntent.getStringExtra("extraGameName"));
        String gameAnnee = String.format("Année de sortie : %s", monIntent.getStringExtra("extraGameAnnee"));
        String gameDescription = String.format("Synopsis : %s", monIntent.getStringExtra("extraGameDescription"));

        //On les met dans les champs du layout
        txtNom.setText(gameName);
        txtAnnee.setText(gameAnnee);
        txtDescription.setText(gameDescription);


    }
}
