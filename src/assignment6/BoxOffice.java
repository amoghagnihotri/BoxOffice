/* MULTITHREADING <BoxOffice.java>
 * EE422C Project 6 submission by
 * Amogh Agnihotri
 * aa73264
 *
 * Slip days used:
 * Spring 2018
 */
package assignment6;

/**
 * Class for each BoxOffice, which has its own clients
 * and services them separately
 */
public class BoxOffice implements Runnable {
    private int numClients;
    private String BOID;
    private Theater theater;

    /**
     * BoxOffice Constructor
     * @param numClients number of clients in line
     * @param BOID ID
     * @param theater theater for the box office
     */
    public BoxOffice(int numClients, String BOID, Theater theater){
        this.numClients = numClients;
        this.BOID = BOID;
        this.theater = theater;
    }

    /**
     * thread run function for each box office:
     *      1) checks for bestAvailable seat
     *          if none, sold out
     *      2) reserves seat and prints ticket
     */
    @Override
    public void run(){
        Theater.Seat tempSeat;
        boolean printed = false;
        for(int i = 0; i < numClients; i++){
            synchronized (theater) {
                tempSeat = theater.bestAvailableSeat();
                if (tempSeat != null) {
                    theater.reserveSeat(tempSeat);
                    Theater.Ticket tempTicket = theater.printTicket(BOID, tempSeat, theater.getClientNum());
                } else {
                    if(!printed) {
                        System.out.println("Sorry, we are sold out!");
                        printed = true;
                    }
                    i = numClients;
                }
            }
        }
    }
}
