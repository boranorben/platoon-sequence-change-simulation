package main;

public class Simulator {
	private final static SequenceChange[] ALGOS = { new FuelAmount(), new TravelingTime(), new RoundRobin() };
	private final static int[] NUM_TRUCK = { 2, 3, 4, 5, 6 };

	public static void main(String[] args) {
		for (int i = 0; i < ALGOS.length; i++) {
			System.out.println(String.format("[%s]", ALGOS[i].toString()));
			for (int j = 0; j < NUM_TRUCK.length; j++) {
				Platoon simulation = new Platoon(ALGOS[i], NUM_TRUCK[j]);
				simulation.start();

				System.out.println(String.format("Number of truck: %d \n%s \n", NUM_TRUCK[j], simulation.toString()));
			}
		}

//		Platoon simulation = new Platoon(new RoundRobin(), 6);
//		simulation.start();
//		System.out.println(simulation.toString());
	}
}