package CarRentalSystem.models;

import java.util.Date;

import CarRentalSystem.enums.ReservationStatus;

public class Reservation {
    private static int idCounter = 2024001; // Static counter to auto-generate unique IDs
    private int reservationId;
    
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date dateBookedFrom;
    private Date dateBookedTo;
    private ReservationStatus reservationStatus;

    public Reservation(User user, Vehicle vehicle, Date bookingDate, Date dateBookedFrom, Date dateBookedTo, ReservationStatus reservationStatus) {
        this.reservationId = idCounter++;
        
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = bookingDate;
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTo = dateBookedTo;
        this.reservationStatus = reservationStatus;
    }

    public int getReservationId() {
        return reservationId;
    }

    public User getUser() { return user; }
    public Vehicle getVehicle() { return vehicle; }
    public Date getBookingDate() { return bookingDate; }
    public Date getDateBookedFrom() { return dateBookedFrom; }
    public Date getDateBookedTo() { return dateBookedTo; }
    public ReservationStatus getStatus() { return reservationStatus; }
}
