// insert header here
package assignment6;

import java.util.ArrayList;

import java.util.List;
import java.util.Vector;

public class Theater {
    private String show;
    private Vector<Seat> available;
    private Vector<Ticket> printed;

    /**
     * represents a seat in the theater
     * i.e A1, A2 etc.
     */
    static class Seat {
        private int rowNum;
        private int seatNum;

        public Seat(int rowNum, int seatNum) {
            this.rowNum = rowNum;
            this.seatNum = seatNum;
        }

        public int getSeatNum() {
            return seatNum;
        }

        public int getRowNum() {
            return rowNum;
        }

        @Override
        public String toString() {
            StringBuilder ret = new StringBuilder();
            int remainder = getRowNum() % 26;
            int rowMult = getRowNum()/27;
            for(int i = 0; i < rowMult; i++) {
                ret.append("A");
            }
            char last = (remainder == 0)? 'Z': (char) ('A' + (remainder-1));
            ret.append(last);
            ret.append(getSeatNum());
            return ret.toString();
        }
    }

    /**
     * represents the ticket purchased by a customer
     */
    static class Ticket {
        private String show;
        private String boxOfficeId;
        private Seat seat;
        private int client;

        public Ticket(String show, String boxOfficeId, Seat seat, int client) {
            this.show = show;
            this.boxOfficeId = boxOfficeId;
            this.seat = seat;
            this.client = client;
        }

        public Seat getSeat() {
            return seat;
        }

        public String getShow() {
            return show;
        }

        public String getBoxOfficeId() {
            return boxOfficeId;
        }

        public int getClient() {
            return client;
        }

        @Override
        public String toString() {
            StringBuilder ret = new StringBuilder();
            ret.append("-------------------------------\n");
            ret.append("| Show: " + getShow());
            for(int i = 0; i < (22-getShow().length()); i++) ret.append(" ");
            ret.append("|\n");
            ret.append("| Box Office ID: " + getBoxOfficeId());
            for(int i = 0; i < (13-getBoxOfficeId().length()); i++) ret.append(" ");
            ret.append("|\n");
            ret.append("| Seat: " + getSeat().toString());
            for(int i = 0; i < (22-getSeat().toString().length()); i++) ret.append(" ");
            ret.append("|\n");
            ret.append("| Client: " + getClient());
            for(int i = 0; i < (20-getClient()); i++) ret.append(" ");
            ret.append("|\n");
            ret.append("-------------------------------\n");
            return ret.toString();
        }
    }

    /**
     * Theater constructor to make a theater object
     */
    public Theater(int numRows, int seatsPerRow, String show) {
        this.show = show;
        printed = new Vector<Ticket>();
        available = new Vector<Seat>();
        for(int i = 1; i <= numRows; i++){
            for(int j = 1; j <= seatsPerRow; j++){
                Seat temp = new Seat(i, j);
                available.add(temp);
            }
        }
    }

    /**
     * returns the best available seat in the theater
     * @return null if already taken or the best seat
     */
    public Seat bestAvailableSeat() {
        if(available.isEmpty()) return null;
        return available.remove(0);
    }

    /**
     * Prints a ticket for the client after they reserve a seat
     * Also prints the ticket to the console
     * @param boxOfficeId
     * @param seat a particular seat in the theater
     * @return a ticket or null if a box office failed to reserve the seat
     */
    public Ticket printTicket(String boxOfficeId, Seat seat, int client) {
        if(seat == null) return null;
        Ticket temp = new Ticket(show, boxOfficeId, seat, client);
        printed.add(temp);
        return temp;
    }

    /**
     * returns list of tickets in the printed order
     * @return list of printed tickets
     */
    public List<Ticket> getTransactionLog() {
        return new ArrayList<Ticket>(printed);
    }

    /*
    public Vector<Seat> orderedSeats(){
        return available;
    }*/
}
