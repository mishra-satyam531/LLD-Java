package BookMyShow.models;

import java.util.List;

import BookMyShow.enums.BookingStatus;

public class Booking {
    private int bookingId;
    private Show show;
    private User user;
    private List<Seat> bookedSeats;
    private int amount;
    private BookingStatus status;
    
    public Booking(int bookingId, Show show, User user, List<Seat> bookedSeats, int amount, BookingStatus status) {
        this.bookingId = bookingId;
        this.show = show;
        this.user = user;
        this.bookedSeats = bookedSeats;
        this.amount = amount;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Show getShow() {
        return show;
    }

    public User getUser() {
        return user;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public int getAmount() {
        return amount;
    }

    public BookingStatus getStatus() {
        return status;
    }
    
}
