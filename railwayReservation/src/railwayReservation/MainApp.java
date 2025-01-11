package railwayReservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Train> trainMap = new HashMap<>();
		Map<Integer, List<Booking>> bookingsMap = new HashMap<>();
		TrainService trainService = new TrainService();
		BookingService bookingService = new BookingService();

		// Sample trains creation
		trainService.createTrain(trainMap, 1, "Thanjavur Express", 2, "Chennai", "Thanjavur");
		trainService.createTrain(trainMap, 2, "Nagarkovil Express", 1, "Chennai", "Nagarkovil");

		// User menu for interaction
		while (true) {
			displayMenu();
			int choice = sc.nextInt();
			sc.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				bookTicket(sc, trainMap, bookingsMap, bookingService);
				break;
			case 2:
				checkAvailability(sc, trainMap, bookingsMap, bookingService);
				break;
			case 3:
				listTrains(trainMap, trainService);
				break;
			case 4:
				cancelBooking(sc, bookingsMap, bookingService);
				break;
			case 5:
				System.out.println("Exiting program. Goodbye!");
				sc.close();
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	// Display menu options
	private static void displayMenu() {
		System.out.println("\n1. Book a Ticket");
		System.out.println("2. Check Ticket Availability");
		System.out.println("3. List All Trains");
		System.out.println("4. Cancel a Booking");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
	}

	private static void bookTicket(Scanner sc, Map<Integer, Train> trainMap, Map<Integer, List<Booking>> bookingsMap,
			BookingService bookingService) {
		System.out.print("Enter passenger name: ");
		String passengerName = sc.nextLine();
		System.out.print("Enter train number: ");
		int trainNo = sc.nextInt();
		System.out.print("Enter travel date (dd-MM-yyyy): ");
		String dateStr = sc.next();
		try {
			Date dateOfTravel = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
			bookingService.createBooking(trainMap, bookingsMap, passengerName, trainNo, dateOfTravel);
		} catch (Exception e) {
			System.out.println("Invalid date format. Please try again.");
		}
	}

	private static void checkAvailability(Scanner sc, Map<Integer, Train> trainMap,
			Map<Integer, List<Booking>> bookingsMap, BookingService bookingService) {
		System.out.print("Enter train number: ");
		int trainNo = sc.nextInt();
		System.out.print("Enter travel date (dd-MM-yyyy): ");
		String dateStr = sc.next();
		try {
			Date dateOfTravel = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
			boolean available = bookingService.isAvailable(trainMap, bookingsMap, trainNo, dateOfTravel);
			System.out.println(available ? "Seats available." : "No seats available.");
		} catch (Exception e) {
			System.out.println("Invalid date format.");
		}
	}

	private static void listTrains(Map<Integer, Train> trainMap, TrainService trainService) {
		trainService.listTrains(trainMap);
	}

	private static void cancelBooking(Scanner sc, Map<Integer, List<Booking>> bookingsMap,
			BookingService bookingService) {
		System.out.print("Enter passenger name: ");
		String passengerName = sc.nextLine();
		System.out.print("Enter train number: ");
		int trainNo = sc.nextInt();
		System.out.print("Enter travel date (dd-MM-yyyy): ");
		String dateStr = sc.next();
		try {
			Date dateOfTravel = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
			bookingService.cancelBooking(bookingsMap, passengerName, trainNo, dateOfTravel);
		} catch (Exception e) {
			System.out.println("Invalid date format.");
		}
	}
}
