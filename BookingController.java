import java.util.ArrayList;
import java.util.List;
public class BookingController {
    private List<Event> events;
    private List<User> users;
    public BookingController() {
        this.events = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    public void createEvent(String eventName, String date, int totalSeats) {
        Event event = new Event(eventName, date, totalSeats);
        events.add(event);
    }
    public void registerUser(String username, String password, String email) {
        User user = new User(username, password, email);
        users.add(user);
    }
    public User logIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public List<Event> getAvailableEvents() {
        return events;
    }
    public void bookTicket(User user, Event event, int numberOfTickets) {
        if (event.getAvailableSeats() >= numberOfTickets) {
            event.bookTickets(numberOfTickets);
            Booking booking = new Booking(user, event, numberOfTickets);
            user.getBookings().add(booking);
        } else {
            throw new IllegalArgumentException("Not enough seats available.");
        }
    }
}
