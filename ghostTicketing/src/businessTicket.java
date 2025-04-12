import java.util.ArrayList;
import java.util.Scanner;

// This is the second in line subclass of Ticket and has methods identical to steerageTicket (another subclass of Ticket); please refer to that class for specific comments regarding implementation details.
public class businessTicket extends Ticket{

    public businessTicket(){
        val = 2;
        selectedOptions = new ArrayList<>();
        selectedUpgrades = new ArrayList<>();
        comp = new ArrayList<>();
        optionCount = 0;
        comp.add("1 carry-on bag");
        comp.add("1 bathroom pass");
    }

    @Override
    public Integer getVal(){
        return val;
    }

    @Override
    public String toString(){
        return "Business Class Ticket" + "\nOptions selected: " + selectedOptions.toString() + "\nUpgrades selected: " + selectedUpgrades.toString() + "\nComplementary perks: " + comp.toString();
    }

    @Override
    public void chooseOptions(Scanner scanner) {
        boolean selecting = true;
        while (selecting) {
            System.out.println("\n\nYou may opt for these Business Class Ticket Options (for an additional price, of course): ");
            System.out.println("1. Overhead bin storage");
            System.out.println("2. Window seat");
            System.out.println("3. Aisle seat");
            System.out.println("4. Done selecting options");
            System.out.print("\nEnter your choice (1-4, you may also select 4 if you wish not to opt for any of these upgrades... cheapskate): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        selectedOptions.add("Overhead bin storage");
                        optionCount ++;
                        break;
                    case 2:
                        selectedOptions.add("Window seat");
                        optionCount ++;
                        break;
                    case 3:
                        selectedOptions.add("Aisle seat");
                        optionCount ++;
                        break;
                    case 4:
                        selecting = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice... really dude? Please select 1-4.");
                }
            }
            else {
                System.out.println("\nInvalid input... one more chance for you or this may be your last flight... EVER. Please enter an integer number within bounds.");
                scanner.next();
            }
        }
    }

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
                        System.out.println("\nWith the Wingman upgrade, you may also choose which wing you would like to be strapped to! Unless, of course, you want us to choose for you, in which case, who knows where we may strap you to :)... So, would you like to opt for this option? (y/n)");
                        if (scanner.next().equals("y")){
                            System.out.println("\nGood choice! Which wing, left or right (left/right)?: ");
                            selectedOptions.add("Wing strapped to: " + scanner.next());
                            optionCount++;
                        }
                        else {
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
