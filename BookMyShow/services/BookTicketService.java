package BookMyShow.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import BookMyShow.controllers.TheatreController;
import BookMyShow.enums.BookingStatus;
import BookMyShow.enums.City;
import BookMyShow.models.Booking;
import BookMyShow.models.Screen;
import BookMyShow.models.Seat;
import BookMyShow.models.Show;
import BookMyShow.models.Theatre;
import BookMyShow.models.User;
import BookMyShow.strategies.PaymentStrategy;

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

    public Booking bookTicket(int userId, Show show, List<Integer> seatIds) {
        List<Integer> alreadyBookedSeats = show.getBookedSeatIds();
        Set<Integer> alreadyBookedSeatsSet = new HashSet<>(alreadyBookedSeats);
        for(int id : seatIds) {
            if(alreadyBookedSeatsSet.contains(id)) {
                System.out.println("Booking Failed: Seat " + id + " is already booked.");
                return null;
            }
        }

        show.addBookedSeats(seatIds);

        List<Seat> myBookedSeats = new ArrayList<>();
        for(Seat seat : show.getScreen().getSeats()) {
            if(seatIds.contains(seat.getSeatId())) {
                myBookedSeats.add(seat);
            }
        }

        User user = new User("Guest User", 25, userId);

        Booking booking = new Booking(1234, show, user, myBookedSeats,  550 * seatIds.size(), BookingStatus.PENDING);

        return booking;
    }

    public void makeBookingPayment(Booking booking, PaymentStrategy paymentMethod) {
        paymentMethod.pay(booking.getAmount());
        booking.setStatus(BookingStatus.CONFIRMED);
        System.out.println("Congratulations, you ticket is booked!");
    }
}
