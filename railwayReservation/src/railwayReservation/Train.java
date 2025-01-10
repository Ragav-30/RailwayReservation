package railwayReservation;

public class Train {
	private int trainNo;
	private String trainName;
	private int capacity;
	private String startPlace;
	private String endPlace;

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public Train(int trainNo, String trainName, int capacity, String startPlace, String endPlace) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.capacity = capacity;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String toString() {
		return getTrainName() + "[TrainNo = " + trainNo + ", TrainName = " + trainName + ", Capacity = " + capacity
				+ ", StartPlace = " + startPlace + ", EndPlace = " + endPlace + "]";
	}
}
