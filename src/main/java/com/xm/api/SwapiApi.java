package com.xm.api;


import com.xm.api.pojo.films.Film;
import com.xm.api.pojo.films.FilmsList;
import com.xm.api.pojo.people.People;
import com.xm.api.pojo.starships.Starship;
import com.xm.core.utility.JsonParser;

import java.util.List;

public class SwapiApi {

    private static final String FILMS_ENDPOINT = "/films";

    public List<Film> getFilms() {
        String response = ApiManager.get(FILMS_ENDPOINT).getBody().asString();
        return JsonParser.fromJsonViaJackson(response, FilmsList.class).getResults();
    }

    public People getPeople(String url) {
        String response = ApiManager.get(url).getBody().asString();
        return JsonParser.fromJsonViaJackson(response, People.class);
    }

    public Starship getStarship(String url) {
        String response = ApiManager.get(url).getBody().asString();
        return JsonParser.fromJsonViaJackson(response, Starship.class);
    }
}
