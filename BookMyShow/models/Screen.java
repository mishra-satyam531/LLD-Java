package BookMyShow.models;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int screenId;
    private List<Seat> seats;
    private List<Show> shows;

    public Screen(int screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
        shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }
    
    public int getScreenId() {
        return screenId;
    }
    public List<Seat> getSeats() {
        return seats;
    }
    
}
