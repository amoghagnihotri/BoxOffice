/* MULTITHREADING <BookingClient.java>
 * EE422C Project 6 submission by
 * Amogh Agnihotri
 * aa73264
 *
 * Slip days used:
 * Spring 2018
 */
package assignment6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.Thread;

/**
 * BookingClient class for managing different box offices in one theater
 */
public class BookingClient {
    private Map<String, Integer> office;
    private Theater theater;

    /**
     *
     * @param office maps box office id to number of customers in line
     * @param theater the theater where the show is playing
     */
    public BookingClient(Map<String, Integer> office, Theater theater) {
        this.office = office;
        this.theater = theater;
    }

    /**
     * Starts the box office simulation by creating (and starting) threads
     * for each box office to sell tickets for the given theater
     * @return list of threads used in the simulation,
     *         should have as many threads as there are box offices
     */
    public List<Thread> simulate() {
        List<Thread> threads = new ArrayList<Thread>();

        for(Map.Entry<String, Integer> entry: office.entrySet()){
            BoxOffice temp = new BoxOffice(entry.getValue(), entry.getKey(), theater);
            threads.add(new Thread(temp));
        }

        for(Thread t: threads) t.start();

        return new ArrayList<Thread>();
    }
}
