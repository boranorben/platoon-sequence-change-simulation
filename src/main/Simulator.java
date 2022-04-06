package main;

public class Simulator {
	private final static int NUM_TRUCK = 6;

	public static void main(String[] args) {
		Platoon simulation = new Platoon(new TravelingTime(), NUM_TRUCK);
		simulation.start();
	}
}