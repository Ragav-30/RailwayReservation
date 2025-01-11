package railwayReservation;

import java.util.Date;

public class Booking {
	private String passengerName;
	private int trainNo;
	private Date dateOfTravel;

	// Constructor
	public Booking(String passengerName, int trainNo, Date dateOfTravel) {
		this.passengerName = passengerName;
		this.trainNo = trainNo;
		this.dateOfTravel = dateOfTravel;
	}

	// Getters and Setters
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
}
