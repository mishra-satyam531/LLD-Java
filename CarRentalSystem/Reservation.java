package CarRentalSystem;

import java.util.Date;

public class Reservation {
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date dateBookedFrom;
    private Date dateBookedTo;
    private ReservationStatus reservationStatustatus;

    public Reservation(User user, Vehicle vehicle, Date bookingDate, Date dateBookedFrom, Date dateBookedTo, ReservationStatus reservationStatustatus) {
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = bookingDate;
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTo = dateBookedTo;
        this.reservationStatustatus = reservationStatustatus;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getDateBookedFrom() {
        return dateBookedFrom;
    }

    public Date getDateBookedTo() {
        return dateBookedTo;
    }

    public ReservationStatus getStatus() {
        return reservationStatustatus;
    }
}
