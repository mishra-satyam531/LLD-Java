package BookMyShow.services;

import java.util.ArrayList;
import java.util.List;

import BookMyShow.controllers.TheatreController;
import BookMyShow.enums.City;
import BookMyShow.models.Screen;
import BookMyShow.models.Show;
import BookMyShow.models.Theatre;

public class BookTicketService {
    private TheatreController theatreController;

    public BookTicketService(TheatreController theatreController) {
        this.theatreController = theatreController;
    }

    public List<Show> getShowsForMovie(City city, String movieName) {
        List<Show> requiresShowsList = new ArrayList<>();

        List<Theatre> theatres = theatreController.getcityVsTheatres(city);

        for(Theatre theatre : theatres) {
            List<Screen> screens = theatre.getscreens();
            for(Screen screen : screens) {
                List<Show> shows = screen.getShows();
                for(Show show : shows) {
                    if(show.getMovie().getMovieName().equals(movieName)) {
                        requiresShowsList.add(show);
                    }
                }
            }
        }

        return requiresShowsList;
    }
}
