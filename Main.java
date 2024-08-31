public class Main {
    public static void main(String[] args) {
        BookingController controller = new BookingController();
        ConsoleView view = new ConsoleView(controller);
        controller.createEvent("The Greatest Of All Time", "2024-09-05", 500);
        view.displayMenu();
    }
}
