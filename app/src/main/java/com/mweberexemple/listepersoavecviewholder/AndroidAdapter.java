package com.mweberexemple.listepersoavecviewholder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by meder on 17/01/2018.
 */


public class AndroidAdapter extends ArrayAdapter<Games> {

    private ArrayList<Games> gamesList;
    private Context context;

    private int viewRes;
    private Resources res;

    public AndroidAdapter(Context context, int textViewResourceId,
                          ArrayList<Games> versions) {
        super(context, textViewResourceId, versions);
        this.gamesList = versions;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;
        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);


        }
        final Games games = gamesList.get(position);
        if (games != null) {
            //On trouve nos view pour leurs donner des valeurs plus tard
            holder = new ViewHolder();
            holder.gameIcon = (ImageView) view.findViewById(R.id.imgJeu);
            holder.gameName = (TextView) view.findViewById(R.id.lblNom);
            holder.gameAnnee = (TextView) view.findViewById(R.id.lblJeu);

            //On place les données de l'objet dans nos view
            holder.gameIcon.setImageResource(games.getGameIcon());

            //Formatage d'un string. On lui donne notre phrase, le %s représentant la donnée, puis en deuxième parametre on lui passe la donnée pour qu'il la mette à la place du %s
            final String gameName = String.format("Nom du jeu : %s", games.getGameName());
            holder.gameName.setText(gameName);

            final String anneeSortie = String.format("Année de sortie : %s", games.getGameAnnee());
            holder.gameAnnee.setText(anneeSortie);
        }
        return view;
    }

    @Override
    public int getCount() {
        return gamesList.size();
    }

    static class ViewHolder {
        ImageView gameIcon;
        TextView gameName;
        TextView gameAnnee;
    }

}

