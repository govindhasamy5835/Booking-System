public class Event {
    private String eventName;
    private String date;
    private int totalSeats;
    private int availableSeats;
    public Event(String eventName, String date, int totalSeats) {
        this.eventName = eventName;
        this.date = date;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
    public String getEventName() {
        return eventName;
    }
    public String getDate() {
        return date;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public void bookTickets(int numberOfTickets) {
        if (numberOfTickets <= availableSeats) {
            availableSeats -= numberOfTickets;
        } else {
            throw new IllegalArgumentException("Not enough seats available.");
        }
    }
}
