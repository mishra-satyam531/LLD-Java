package BookMyShow.models;

import java.util.List;

import BookMyShow.enums.City;

public class Theatre {
    private int theatreId;
    private String address;
    private City city;
    private List<Screen> screens;
    public Theatre(int theatreId, String address, City city, List<Screen> screens) {
        this.theatreId = theatreId;
        this.address = address;
        this.city = city;
        this.screens = screens;
    }

    public int getTheatreId() {
        return theatreId;
    }
    public String getAddress() {
        return address;
    }
    public City getCity() {
        return city;
    }
    public List<Screen> getscreens() {
        return screens;
    }
    
}
