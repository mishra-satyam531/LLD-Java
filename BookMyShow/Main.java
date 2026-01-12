package BookMyShow;

import java.util.ArrayList;
import java.util.List;

import BookMyShow.controllers.MovieController;
import BookMyShow.controllers.TheatreController;
import BookMyShow.enums.City;
import BookMyShow.enums.SeatType;
import BookMyShow.models.Booking;
import BookMyShow.models.Movie;
import BookMyShow.models.Screen;
import BookMyShow.models.Seat;
import BookMyShow.models.Show;
import BookMyShow.models.Theatre;
import BookMyShow.services.BookTicketService;

public class Main {
    public static void main(String[] args) {
        MovieController movieController = new MovieController();
        TheatreController theatreController = new TheatreController();

        Movie avengersEndgame = new Movie(101, "Avengers Endgame", 183);

        Seat seat1 = new Seat(101, 'A', 5, SeatType.GOLD);
        Seat seat2 = new Seat(201, 'A', 18, SeatType.SILVER);
        Seat seat3 = new Seat(301, 'C', 3, SeatType.PLATINUM);
        List<Seat> seats = new ArrayList<>();
        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);

        Screen screen = new Screen(541, seats);
        List<Screen> screens = new ArrayList<>();
        screens.add(screen);
        
        Theatre theatre = new Theatre(947, "Vegas Mall, Dwarka", City.DELHI, screens);

        Show show = new Show(654, avengersEndgame, screen, 1700);
        screen.addShow(show);

        movieController.setCityVsMovies(City.DELHI, avengersEndgame);
        theatreController.setcityVsTheatres(City.DELHI, theatre);

        BookTicketService brokerage = new BookTicketService(theatreController);

        // User searches for "Avengers Endgame" in Delhi
        System.out.println("Searching for Avengers in Delhi...");
        List<Show> results = brokerage.getShowsForMovie(City.DELHI, "Avengers Endgame");

        if(results.isEmpty()) {
            System.out.println("No shows found!");
        } else {
            // User selects the first show found
            Show selectedShow = results.get(0);
            System.out.println("Found show: " + selectedShow.getShowId());

            // User tries to book Seat IDs 101 and 201
            List<Integer> seatsToBook = new ArrayList<>();
            seatsToBook.add(101);
            seatsToBook.add(201);

            Booking booking = brokerage.bookTicket(1, selectedShow, seatsToBook);
            if(booking != null) {
                System.out.println("Booking Successful! ID: " + booking.getBookingId());
                System.out.println("Status: " + booking.getStatus());
            } else {
                System.out.println("Booking Failed.");
            }
        }
    }
}
