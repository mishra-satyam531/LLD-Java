package BookMyShow.models;

import BookMyShow.enums.SeatType;

public class Seat {
    private int seatId;
    private char seatRow;
    private int seatNo;
    private SeatType seatType;
    
    public Seat(int seatId, char seatRow, int seatNo, SeatType seatType) {
        this.seatId = seatId;
        this.seatRow = seatRow;
        this.seatNo = seatNo;
        this.seatType = seatType;
    }

    public int getSeatId() {
        return seatId;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }
    
}
