public class Booking {
    private User user;
    private Event event;
    private int numberOfTickets;
    public Booking(User user, Event event, int numberOfTickets) {
        this.user = user;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
    }
    public User getUser() {
        return user;
    }
    public Event getEvent() {
        return event;
    }
    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
