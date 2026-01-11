package BookMyShow.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BookMyShow.enums.City;
import BookMyShow.models.Theatre;

public class TheatreController {
    private Map<City, List<Theatre>> cityVsTheatres;

    public TheatreController() {
        cityVsTheatres = new HashMap<>();
    }

    public List<Theatre> getcityVsTheatres(City city) {
        return cityVsTheatres.get(city);
    }

    public void setcityVsTheatres(City city, Theatre Theatre) {
        if(!cityVsTheatres.containsKey(city)) {
            cityVsTheatres.put(city, new ArrayList<>());
        }
        cityVsTheatres.get(city).add(Theatre);
    }
}
