/* MULTITHREADING <Main.java>
 * EE422C Project 6 submission by
 * Amogh Agnihotri
 * aa73264
 *
 * Slip days used:
 * Spring 2018
 */
package assignment6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> office = new HashMap<String, Integer>();
        office.put("BX1", 3);
        office.put("BX2", 4);
        office.put("BX3", 3);
        office.put("BX4", 3);
        office.put("BX5", 3);

        Theater theater = new Theater(3, 5, "Ouija");

        BookingClient bc = new BookingClient(office, theater);
        bc.simulate();

    }
}
