import java.util.ArrayList;
import java.util.Collections;

// This is the ticketInfo class which helps manage tickets, how they are stored, how and when they are sorted, and how they are printed.
public class ticketInfo{
    private ArrayList<Ticket> tix; // This is the collection of all added tickets.

    public ticketInfo() {
        tix = new ArrayList<>();
    }

    //This method adds tickets to the collection.
    public void addTick(Ticket someTicket) {
        tix.add(someTicket);
    }

    //This method is not used but can be used to sort tickets based on the implementation of Comparable in ticket.
    public void sortTix() {
        Collections.sort(tix);
    }

    // This method prints and sorts befrehand all tickets in collection
    public void printTix() {
        if (tix.size() == 0) {
            System.out.println("\nNo tickets added.");
        }
        else{
            Collections.sort(tix);
            System.out.println("\nCurrent Tickets:");
            //Here we use a regular for loop to print all tickets
            for (int i = 0; i < tix.size(); i++) {
                System.out.println("\n_________________________\n");
                System.out.println((i +1) + ". " + tix.get(i));
            }
        }
    }

    // This method prints only the tickets with the Thrill Seeker upgrade.
    public void printThrillTix() {
        ArrayList<Ticket> ts = new ArrayList<>();
        System.out.println("\nTickets with Thrill Seeker upgrade:");

        //Here I tried something different with a for each loop which adds tickets to a new collection if they contain the "Thrill Seeker" upgrade.
        for (Ticket tick: tix){
            if (tick.selectedUpgrades.contains("Thrill Seeker")){
                ts.add(tick);
            }
        }

        Collections.sort(ts); //Here is an instance of the tickets being sorted based on the compareTo method in Ticket class.

        if (!ts.isEmpty()){
            for (Ticket tsTick: ts) {
                System.out.println("\n----------------\n");
                System.out.println(tsTick);
            }
        }
        else{
            System.out.println("\nNo tickets match the specified search criteria.");
        }
    }

    // This method is pretty much identical to the printThrillTix method except for the fact that it sorts and prints only those tickets with the Wingman upgrade.
    public void printWingmanTix() {
        ArrayList<Ticket> ws = new ArrayList<>();
        System.out.println("\nTickets with Wingman upgrade:");

        for (Ticket tick: tix){
            if (tick.selectedUpgrades.contains("Wingman")){
                ws.add(tick);
            }
        }

        Collections.sort(ws);

        if (!ws.isEmpty()){
            for (Ticket wsTick: ws) {
                System.out.println("\n----------------\n");
                System.out.println(wsTick);
            }
        }
        else{
            System.out.println("\nNo tickets match the specified search criteria");
        }
    }

    // this method is similar to the previous two except for the fact that it prints only those tickets with no options or upgrades by looking at the optionsCount variable.
    public void printTroublesomeTix() {
        ArrayList<Ticket> tsm = new ArrayList<>();
        System.out.println("\nTickets with no options or upgrades:");

        for (Ticket tick: tix){
            if (tick.optionCount == 0){
                tsm.add(tick);
            }
        }

        Collections.sort(tsm);

        if (!tsm.isEmpty()){
            for (Ticket tsmTick: tsm) {
                System.out.println("\n----------------\n");
                System.out.println(tsmTick);
            }
        }
        else{
            System.out.println("\nNo tickets match the specified search criteria.");
        }
    }

}
