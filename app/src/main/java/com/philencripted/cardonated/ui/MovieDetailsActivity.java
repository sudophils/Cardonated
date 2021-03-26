package com.philencripted.cardonated.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.philencripted.cardonated.R;


public class MovieDetailsActivity extends AppCompatActivity {

    TextView nameTv, voteTv, avgVoteTv,releaseDateTv, descTv, popTv;
    String name,vote, desc, avgVote,releaseDate, backdropPath, posterPath, popularity;
    ImageView backdrop, poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // get views
        nameTv = findViewById(R.id.movie_name);
        backdrop = findViewById(R.id.backdrop);
        poster = findViewById(R.id.posterimg);
        voteTv = findViewById(R.id.vote);
        descTv = findViewById(R.id.movie_desc);

        avgVoteTv = findViewById(R.id.avgvote);
        releaseDateTv = findViewById(R.id.date);
        popTv = findViewById(R.id.popularity);

        // setup UI
        setupUIWithData();

    }


    @SuppressLint("SetTextI18n")
    private void setupUIWithData(){
        // get data from intent for display
        Bundle intentBundle = getIntent().getExtras();




        // retrieve other values from intent
        name = intentBundle.getString("title");
        avgVote = intentBundle.getString("vote_avg");
        desc = intentBundle.getString("overview");
        vote = intentBundle.getString("vote_count");
        releaseDate = intentBundle.getString("date");
        popularity = intentBundle.getString("popularity");




        posterPath = intentBundle.getString("poster");
        backdropPath = intentBundle.getString("backdrop");



        try {

            //display views
            nameTv.setText(name);
            voteTv.setText(vote);
            descTv.setText(desc);
            avgVoteTv.setText(avgVote);
            popTv.setText(popularity);
            releaseDateTv.setText(releaseDate);
            popTv.setText(popularity);
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+backdropPath).into(backdrop);
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+posterPath).into(poster);



            //debug
            System.out.println("TESTER"+popularity);



        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}