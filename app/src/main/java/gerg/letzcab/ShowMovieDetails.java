package gerg.letzcab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by amarnathprasad on 06/06/17.
 */

public class ShowMovieDetails extends AppCompatActivity{

    TextView txtViewMovieId;
    TextView txtViewMovieName;
    TextView txtViewMoviePrice;
    TextView txtViewMovieStock;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmov_details);

        txtViewMovieId = (TextView)findViewById(R.id.txtViewMovieId);
        txtViewMovieName = (TextView)findViewById(R.id.txtViewMovieName);
        txtViewMoviePrice = (TextView)findViewById(R.id.txtViewMoviePrice);
        txtViewMovieStock = (TextView)findViewById(R.id.txtViewMovieStock);

        Intent intent  = getIntent();

        txtViewMovieId.setText(String.valueOf(intent.getIntExtra(MainActivity.KEY_MOVIE_ID,0)));
        txtViewMovieName.setText(intent.getStringExtra(MainActivity.KEY_MOVIE_NAME));
        txtViewMoviePrice.setText(intent.getStringExtra(MainActivity.KEY_MOVIE_PRICE));
        txtViewMovieStock.setText(String.valueOf(intent.getIntExtra(MainActivity.KEY_MOVIE_STOCK,0)));
    }
}
