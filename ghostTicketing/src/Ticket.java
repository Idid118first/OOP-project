import java.util.Scanner;
import java.util.ArrayList;

// Implement the comparable interface for Ticket class as specified in instructions in order to assist in sorting of tickets while printing them.
public abstract class Ticket implements Comparable<Ticket>{
    // Declare variables to be initialized in concrete subclasses
    public Integer val; // This is the first variable used to compare tickets, this differentiates different types of tickets such as first class and business class.
    public int optionCount; // This variable is used to compare tickets of the same type to see which one has more total options + upgrades.
    public ArrayList<String> selectedOptions;
    public ArrayList<String> selectedUpgrades;
    public ArrayList<String> comp;

    // Declare abstract classes to be initialized in subclasses and be used to get the value of those classes to aid in sorting through compareTo and also to allow options/upgrades to be chosen in said classes.
    abstract Integer getVal();
    abstract void chooseOptions(Scanner scanner);
    abstract void chooseUpgrades(Scanner scanner);

    // This here is the compareTo method used to help sort tickets, first we compare val, if that is equal then the tickets are of the same type, and we must check for the number of options + upgrades to differentiate the tickets.
    @Override
    public int compareTo(Ticket otherTicket) {
        if (this.getVal() != otherTicket.getVal()){
            return Integer.compare(otherTicket.getVal(), this.getVal());
        }
        else{
            return Integer.compare(otherTicket.optionCount, this.optionCount);
        }
    }

}
