package railwayReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map<Integer, Train> train = new HashMap<>();
		ArrayList<Booking> bookings = new ArrayList<>();
		createTrain(train);
		while (true) {
			displayMenu();
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				bookTrain(train, bookings);
				break;
			case 2:
				ticketAvailbility(train, bookings);
				break;
			case 3:
				listTrains(train);
				break;
			case 4:
				System.out.println("Thank you for using Railway Booking App. Goodbye!");
				sc.close();
				return;
			default:
				System.out.println("Invalid option. Please try again.");
			}

		}

	}

	private static void ticketAvailbility(Map<Integer, Train> train, ArrayList<Booking> bookings) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Kindly Enter the Train No to check the seat availability");
		int trainNo = sc.nextInt();
		System.out.println("Kindly Enter the date on which you want to check: ");
		String d = sc.next();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = s.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int booked = 0;
		Train t = train.get(trainNo);
		if (t == null) {
			System.out.println("There is no Train available with that no");
			ticketAvailbility(train, bookings);
		}
		for (Booking b : bookings) {
			if (b.getTrainNo() == trainNo && b.getDateOfTravel().equals(date)) {
				booked++;
			}
		}
		int capacity = t.getCapacity();
		int output = capacity - booked;
		System.out.println("The current availability of the train is " + output);

	}

	private static void bookTrain(Map<Integer, Train> train, ArrayList<Booking> bookings) {
		// TODO Auto-generated method stub

		Booking b = new Booking();
		if (b.isAvailable(train, bookings)) {
			bookings.add(b);
			System.out.println("Your ticket has been booked successfully");
		} else {
			System.out.println("sorry, The train is not available");
			return;
		}

	}

	private static void createTrain(Map<Integer, Train> a) {
		// TODO Auto-generated method stub
		Train a1 = new Train(1, "Thanjavur Express", 2, "Chennai", "Thanjavur");
		Train b1 = new Train(2, "Nagarkovil Express", 1, "Chennai", "Nagarkovil");
		Train c1 = new Train(3, "Vaigai Express", 90, "Chennai", "vaigai");
		Train d1 = new Train(4, "Vande Bharat", 75, "Chennai", "Bangalore");

		a.put(1, a1);
		a.put(2, b1);
		a.put(3, c1);
		a.put(4, d1);
	}

	private static void listTrains(Map<Integer, Train> a) {
		// TODO Auto-generated method stub
		a.forEach((k, t) -> {
			System.out.println(t);
		});
	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome to Railway Booking App");
		System.out.println("1. Ticket Booking");
		System.out.println("2. Ticket Availability");
		System.out.println("3. List Trains");
		System.out.println("4. Exit");
		System.out.print("Kindly enter the option you want to continue: ");
		System.out.println();
	}

}
