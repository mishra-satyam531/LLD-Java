package BookMyShow.models;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private int startTime;
    private List<Integer> bookedSeatIds;

    public Show(int showId, Movie movie, Screen screen, int startTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        bookedSeatIds = new ArrayList<>();
    }

    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void addBookedSeats(List<Integer> bookedSeats) {
        bookedSeatIds.addAll(bookedSeats);
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }
    
}
