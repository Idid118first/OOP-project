import java.util.Scanner;

// This is the menu class for the booking system and is the forefront player in the UI.
public class Menu {
    private ticketInfo info;
    private Scanner scanner;

    // This is the constructor and it initializes an object of ticketInfo to aid with displaying/sorting tickets and a Scanner object.
    public Menu() {
        info = new ticketInfo();
        scanner = new Scanner(System.in);
    }

    // This, the menu method, prompts the user with the opening menu and allows them to pick whether they would like to add a ticket, display tickets, display tickets according to specific criteria, or exit the experience.
    public void menu() {
        boolean booking = true;
        while (booking) {
            System.out.println("\n---- Ghost Airways Ticket Booking ----");
            System.out.println("1. Add New Ticket");
            System.out.println("2. Display All Tickets");
            System.out.println("3. Display tickets with Thrill Seeker upgrade");
            System.out.println("4. Display tickets with Wingman upgrade");
            System.out.println("5. Display tickets with no upgrades");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice (1-6): ");

            // This switch structure combined with if/else statements is similar in nature to the earlier chooseOption method from steerageTicket
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        tickClasses();
                        break;
                    case 2:
                        info.printTix();
                        break;
                    case 3:
                        info.printThrillTix();
                        break;
                    case 4:
                        info.printWingmanTix();
                        break;
                    case 5:
                        info.printTroublesomeTix();
                        break;
                    case 6: // This case is used when the user decides to exit the booking system.
                        booking = false;
                        System.out.println("\nThank you for flying (for the last time... EVER!) with us!");
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter 1-3.");
                }
            } else {
                System.out.println("\nInvalid input. Please enter a number.");
                scanner.next(); // Let user try inputting again.
            }
        }
        scanner.close();
    }

    // This is a helper method of menu and prompts the user into providing what class the ticket being added is. Then, the method creates a new object of that ticket type.
    private void tickClasses() {
        System.out.println("\nSelect Ticket Type (1, 2, 3, or 4):");
        System.out.println("1. First Class Ticket");
        System.out.println("2. Business Class Ticket");
        System.out.println("3. Coach Ticket");
        System.out.println("4. Steerage Ticket");
        System.out.print("Enter ticket type (1-4): ");

        if (scanner.hasNextInt()) {
            int ticketType = scanner.nextInt();
            Ticket newTicket;

            switch (ticketType) {
                case 1:
                    newTicket = new firstTicket();
                    break;
                case 2:
                    newTicket = new businessTicket();
                    break;
                case 3:
                    newTicket = new coachTicket();
                    break;
                case 4:
                    newTicket = new steerageTicket();
                    break;
                default:
                    System.out.println("Please select one of the options.");
                    return;
            }


            // These calls to the methods in the object of the specific ticket type allow the user to enter specific options and upgrades for their ticket. Note that these specific methods were covered in depth in steerageClass.
            newTicket.chooseOptions(scanner);
            newTicket.chooseUpgrades(scanner);

            // This call to addTick in ticketInfo class finally adds the completed ticket with options and upgrades to the arrayList containing all tickets.
            info.addTick(newTicket);

        } 
        else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Let user try inputting again.
        }
    }
}

