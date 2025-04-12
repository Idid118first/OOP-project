import java.util.Scanner;
import java.util.ArrayList;

// This is the lowest tier subclass of Ticket
public class steerageTicket extends Ticket{

    // The constructor here initializes all variables and container data structures to default values but also adds the complementary perks to the xomp ArrayList collection.
    public steerageTicket(){
        val = 0;
        selectedOptions = new ArrayList<>();
        selectedUpgrades = new ArrayList<>();
        comp = new ArrayList<>();
        optionCount = 0;
        comp.add("None");
    }

    // This method, as in all other subclasses, returns the value which differentiates different types of tickets.
    @Override
    public Integer getVal(){
        return val;
    }

    // This is the overridden toString method used in every subclass of Ticket which is used to print the ticket which includes information such as ticket type, options selected, upgrades selected, and complementary perks.
    @Override
    public String toString(){
        return "Steerage Class Ticket" + "\nOptions selected: " + selectedOptions.toString() + "\nUpgrades selected: " + selectedUpgrades.toString() + "\nComplementary perks: " + comp.toString();
    }

    // This is the method used in all subclasses of Ticket where we allow users to pick which options they would like to add to their ticket and has options unique to the ticket type.
    @Override
    public void chooseOptions(Scanner scanner) {
        boolean selecting = true;  // This boolean variable helps us to know when the user is still adding options and when they are done. When adding options still, the value remains true, when done adding the value is set to false.
        while (selecting) {
            System.out.println("\n\nYou may also opt for these Steerage Class Ticket Options (for an additional price, of course): "); // This is a series of prompts for the user to get their desired options.
            System.out.println("1. Permission to sit on available cargo");
            System.out.println("2. Done selecting options");
            System.out.print("\nEnter your choice (1-2, you may also select 2 if you wish not to opt for any of these upgrades... cheapskate): "); // This here also reminds the user that they use the same input to finish their selection of options or to deny selecting options.

            if (scanner.hasNextInt()) {  // This if statement checks to see if the user has entered an int value for their input as it is the accepted data type.
                int choice = scanner.nextInt();
                switch (choice) { // This switch structure here is used to determine which option the user has chosen to add.
                    case 1:
                        selectedOptions.add("Permission to sit on available cargo"); // Here, same as you will see in the chooseUpgrades method, the user selected option is added to an ArrayList of all options for the specific ticket.
                        optionCount ++;
                        break;
                    case 2:
                        selecting = false;  // This case is used when the user is done selecting options.
                        break;
                    default:
                        System.out.println("\nInvalid choice... Sigh. Please select 1-2.");  // This is the default case for switch in the scenario that the user uses an integer input that is out of bounds and thus can not be processed, so they are prompted to pick a valid input value.
                }
            }
            else {  // This else statement is to allow the user to select a valid input value if they did not input an int.
                System.out.println("\nInvalid input... come on now. Please enter an integer number within bounds.");
                scanner.next();
            }
        }
    }

    //This is the method used to allow the user to select upgrades for their ticket and is the exact same across all subclasses of Ticket and is extremely similar to the chooseOptions method.
    @Override
    public void chooseUpgrades(Scanner scanner) {
        boolean selecting = true;
        while (selecting){
            System.out.println("\n\nYou may also opt for some of our out of this world (like you very soon...) upgrades: ");
            System.out.println("\n1. Thrill Seeker – this is for passengers that like to live dangerously! This upgrade assigns the passenger to a Boeing 737 MAX aircraft.");
            System.out.println("2. Wingman – does the typical flight experience cramp your style? With the wingman upgrade, you’ll feel invigorated, strapped to the wing of the aircraft.");
            System.out.println("3. Done selecting upgrades");
            System.out.println("\nEnter your choice (1-3, you may also choose 3 if you do not wish to opt for any upgrades... brokie)");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        selectedUpgrades.add("Thrill Seeker");
                        optionCount++;
                        break;
                    case 2:
                        selectedUpgrades.add("Wingman");
                        optionCount++;
                        System.out.println("\nWith the Wingman upgrade, you may also choose which wing you would like to be strapped to! Unless, of course, you want us to choose for you, in which case, who knows where we may strap you to :)... So, would you like to opt for this option? (y/n)"); // In the case that the user opts for the Wingman upgrade, here they are given a chance to add an option which allows them to pick which wing they would like to be strapped to.
                        if (scanner.next().equals("y")){
                            System.out.println("\nGood choice! Which wing, left or right (left/right)?: ");
                            selectedOptions.add("Wing strapped to: " + scanner.next());
                            optionCount++;
                        }
                        else{
                            System.out.println("\nBold... ;)");
                        }
                        break;
                    case 3:
                        selecting = false;
                        break;
                    default:
                        System.out.println("\nA number within bounds moron. Try again.");
                        scanner.next();
                }
            }
            else {
                System.out.println("\nInvalid input... come on now. Please enter an integer number within bounds.");
                scanner.next();
            }
        }
    }
}
