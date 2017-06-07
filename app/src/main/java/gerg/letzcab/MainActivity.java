package gerg.letzcab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    //public static final String ROOT_URL = "http://www.delaroystudios.com/";

    public static final String ROOT_URL = "http://goldeneraproperty.com/App_test/";
   // http://goldeneraproperty.com/App_test/product.php

    public static final String KEY_MOVIE_ID    = "key_movie_id";
    public static final String KEY_MOVIE_NAME  = "key_movie_name";
    public static final String KEY_MOVIE_PRICE = "key_movie_price";
    public static final String KEY_MOVIE_STOCK = "key_movie_stock";

    private ListView listview;
    private List<Movie> movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView)findViewById(R.id.list_Retrofit);
        getMovies();
        listview.setOnItemClickListener(this);
    }

    private void getMovies() {

        final ProgressDialog loading = ProgressDialog.show
                (this,"Fetching Data","Please wait...",false,false);

        RestAdapter adater = new RestAdapter.Builder().setEndpoint(ROOT_URL).build();
        MovieApi api = adater.create(MovieApi.class);

        api.getMovies(new Callback<List<Movie>>() {

            @Override
            public void success(List<Movie> list, Response response) {
               loading.dismiss();
               movie = (List<Movie>) list;
               showList();

            }

            @Override
            public void failure(RetrofitError error) {

            }
        } );

}

    private void showList() {

        String[] items = new String[movie.size()];
        for(int i = 0; i<movie.size(); i++){
            items[i] = movie.get(i).getName();

        }

        ArrayAdapter adpter = new ArrayAdapter<String>(this,R.layout.simple_list,items);
        listview.setAdapter(adpter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent intent  = new Intent(this,ShowMovieDetails.class);
        Movie mov =   movie.get(position);

        intent.putExtra(KEY_MOVIE_ID,mov.getMovieId());
        intent.putExtra(KEY_MOVIE_NAME,mov.getName());
        intent.putExtra(KEY_MOVIE_PRICE,mov.getMovieId());
        intent.putExtra(KEY_MOVIE_STOCK,mov.getInStock());
        startActivity(intent);

    }

}
