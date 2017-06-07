package gerg.letzcab;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by amarnathprasad on 06/06/17.
 */

public interface MovieApi {


    @GET("/retrofit/movies.json")
    public  void getMovies(Callback<List<Movie>> responce);



  /*  @GET("api/{email}/{password}")
    Call<Login> authenticate(@Path("email") String email, @Path("password") String password);
   *//* @POST("api/{email}/{password}")
    Call<Login> registration(@Path("email") String email, @Path("password") String password);*/

}


