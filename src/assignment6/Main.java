package assignment6;


public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater(4, 100, "Ouija");
        theater.printTicket("BX1", theater.bestAvailableSeat(), 1);
        theater.printTicket("BX1", theater.bestAvailableSeat(), 1);
        for(Theater.Ticket t: theater.getTransactionLog()){
            System.out.println(t.toString());
        }
    }
}
