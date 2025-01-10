package railwayReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Booking {

	private String passengerName;
	private int trainNo;
	private Date dateOfTravel;

	public Booking() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Passenger name:");
		passengerName = sc.next();
		System.out.println("Enter TrainNo:");
		trainNo = sc.nextInt();
		System.out.println("Enter Date:(dd-MM-yyy)");
		String date = sc.next();
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");

		try {
			dateOfTravel = d.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public Date getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(Date dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public boolean isAvailable(Map<Integer, Train> train, ArrayList<Booking> bookings) {
		// TODO Auto-generated method stub

		Train t = train.get(trainNo);
		if (t == null) {
			return false;
		}
		int capacity = t.getCapacity();
		int booked = 0;
		for (Booking b : bookings) {
			if (b.getTrainNo() == trainNo && b.getDateOfTravel().equals(dateOfTravel)) {
				booked++;

				if (booked >= capacity) {
					return false;
				}
			}
		}

		return booked < capacity;
	}

}
