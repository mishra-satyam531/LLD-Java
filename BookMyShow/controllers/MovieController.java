package BookMyShow.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BookMyShow.enums.City;
import BookMyShow.models.Movie;

public class MovieController {
    private Map<City, List<Movie>> cityVsMovies;

    public MovieController() {
        cityVsMovies = new HashMap<>();
    }

    public List<Movie> getCityVsMovies(City city) {
        return cityVsMovies.getOrDefault(city, new ArrayList<>());
    }

    public void setCityVsMovies(City city, Movie movie) {
        if(!cityVsMovies.containsKey(city)) {
            cityVsMovies.put(city, new ArrayList<>());
        }
        cityVsMovies.get(city).add(movie);
    }

}
