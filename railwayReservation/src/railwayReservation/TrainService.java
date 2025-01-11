package railwayReservation;

import java.util.Map;

public class TrainService {

	// Add a new train to the system
	public void createTrain(Map<Integer, Train> trainMap, int trainNo, String name, int capacity, String origin,
			String destination) {
		Train train = new Train(trainNo, name, capacity, origin, destination);
		trainMap.put(trainNo, train);
		System.out.println("Train " + name + " added to the system.");
	}

	// List all available trains
	public void listTrains(Map<Integer, Train> trainMap) {
		if (trainMap.isEmpty()) {
			System.out.println("No trains available.");
		} else {
			trainMap.forEach((k, v) -> System.out.println(v));
		}
	}
}
