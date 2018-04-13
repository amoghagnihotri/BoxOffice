// insert header here
package assignment6;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    /*
     * Represents a seat in the theater
     * A1, A2, A3, ... B1, B2, B3 ...
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

    /*
       * Represents a ticket purchased by a client
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
            // TODO: Implement this method to return a string that resembles a ticket
            return "";
        }
    }

    public Theater(int numRows, int seatsPerRow, String show) {
        // TODO: Implement this constructor
    }

    /*
     * Calculates the best seat not yet reserved
     *
      * @return the best seat or null if theater is full
   */
    public Seat bestAvailableSeat() {
        //TODO: Implement this method
        return new Seat(0, 0);
    }

    /*
     * Prints a ticket for the client after they reserve a seat
   * Also prints the ticket to the console
     *
   * @param seat a particular seat in the theater
   * @return a ticket or null if a box office failed to reserve the seat
   */
    public Ticket printTicket(String boxOfficeId, Seat seat, int client) {
        //TODO: Implement this method
        return new Ticket("", "", new Seat(0, 0), 0);
    }

    /*
     * Lists all tickets sold for this theater in order of purchase
     *
   * @return list of tickets sold
   */
    public List<Ticket> getTransactionLog() {
        //TODO: Implement this method
        return new ArrayList<Ticket>();
    }
}
