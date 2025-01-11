package railwayReservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BookingService {

	// Method to check availability and create booking
	public boolean isAvailable(Map<Integer, Train> trainMap, Map<Integer, List<Booking>> bookingsMap, int trainNo,
			Date dateOfTravel) {
		Train train = trainMap.get(trainNo);
		if (train == null) {
			System.out.println("Invalid train number.");
			return false;
		}
		List<Booking> bookings = bookingsMap.getOrDefault(trainNo, new ArrayList<>());
		int bookedSeats = 0;
		for (Booking b : bookings) {
			if (b.getDateOfTravel().equals(dateOfTravel)) {
				bookedSeats++;
			}
		}

		return bookedSeats < train.getCapacity();
	}

	// Method to create a booking
	public void createBooking(Map<Integer, Train> trainMap, Map<Integer, List<Booking>> bookingsMap,
			String passengerName, int trainNo, Date dateOfTravel) {
		if (isAvailable(trainMap, bookingsMap, trainNo, dateOfTravel)) {
			Booking newBooking = new Booking(passengerName, trainNo, dateOfTravel);
			if (!bookingsMap.containsKey(trainNo)) {
				bookingsMap.put(trainNo, new ArrayList<>());
			}
			bookingsMap.get(trainNo).add(newBooking);
			System.out.println("Booking successful for " + passengerName + " on train " + trainNo);
		} else {
			System.out.println("No available seats for this train on the given date.");
		}
	}

	// Method to cancel a booking
	public boolean cancelBooking(Map<Integer, List<Booking>> bookingsMap, String passengerName, int trainNo,
			Date dateOfTravel) {
		List<Booking> bookings = bookingsMap.getOrDefault(trainNo, new ArrayList<>());
		for (Booking booking : bookings) {
			if (booking.getPassengerName().equals(passengerName) && booking.getDateOfTravel().equals(dateOfTravel)) {
				bookings.remove(booking);
				System.out.println("Booking cancelled for " + passengerName + " on train " + trainNo);
				return true;
			}
		}
		System.out.println("Booking not found for " + passengerName);
		return false;
	}

	// Method to list all available bookings for a train
	public void listBookings(Map<Integer, List<Booking>> bookingsMap, int trainNo) {
		List<Booking> bookings = bookingsMap.getOrDefault(trainNo, new ArrayList<>());
		if (bookings.isEmpty()) {
			System.out.println("No bookings available for train number " + trainNo);
		} else {
			bookings.forEach(
					b -> System.out.println("Passenger: " + b.getPassengerName() + ", Date: " + b.getDateOfTravel()));
		}
	}
}
