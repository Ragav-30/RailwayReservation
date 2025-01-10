package railwayReservation;

import java.util.ArrayList;
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
//				bookTrain();
				break;
			case 2:
//				ticketAvailbility();
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

	private static void createTrain(Map<Integer, Train> a) {
		// TODO Auto-generated method stub
		Train a1 = new Train(1, "Thanjavur Express", 60, "Chennai", "Thanjavur");
		Train b1 = new Train(2, "Nagarkovil Express", 70, "Chennai", "Nagarkovil");
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
