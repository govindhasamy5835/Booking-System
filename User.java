import java.util.ArrayList;
import java.util.List;
public class User {
    private String username;
    private String password;
    private String email;
    private List<Booking> bookings;
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.bookings = new ArrayList<>();
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
}
