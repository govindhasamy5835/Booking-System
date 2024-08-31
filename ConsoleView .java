import java.util.Scanner;
import java.util.List;
public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);
    private BookingController controller;
    private User currentUser;
    public ConsoleView(BookingController controller) {
        this.controller = controller;
        this.currentUser = null; 
    }
    public void displayMenu() {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Book Ticket");
            System.out.println("4. View My Bookings");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    logIn();
                    break;
                case 3:
                    bookTicket();
                    break;
                case 4:
                    viewMyBookings();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    private void registerUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        controller.registerUser(username, password, email);
        System.out.println("Registration successful!");
    }
    private void logIn() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        currentUser = controller.logIn(username, password);
        if (currentUser != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
    private void bookTicket() {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        List<Event> events = controller.getAvailableEvents();
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        System.out.println("Available Events:");
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            System.out.printf("%d. %s on %s - Available Seats: %d\n", i + 1, event.getEventName(), event.getDate(), event.getAvailableSeats());
        }
        System.out.print("Select event number: ");
        int eventIndex = scanner.nextInt() - 1;
        scanner.nextLine(); 
        if (eventIndex < 0 || eventIndex >= events.size()) {
            System.out.println("Invalid event selection.");
            return;
        }
        Event selectedEvent = events.get(eventIndex);
        System.out.print("Number of tickets: ");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine(); 
          try {
            controller.bookTicket(currentUser, selectedEvent, numberOfTickets);
            System.out.println("Booking successful!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void viewMyBookings() {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        List<Booking> bookings = currentUser.getBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        System.out.println("Your Bookings:");
        for (Booking booking : bookings) {
            System.out.printf("Event: %s on %s - Tickets: %d\n", booking.getEvent().getEventName(), booking.getEvent().getDate(), booking.getNumberOfTickets());
        }
    }
}
