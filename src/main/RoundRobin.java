package main;

import java.util.ArrayList;

public class RoundRobin implements SequenceChange {
	private static final double HOUR_ONE = 1.0;
	private static final double HOUR_TWO = 2.0;
	private static final int[] delta = { 1, 3, 5, 6, 8 };

	@Override
	public void tryToSwitch(ArrayList<Truck> platoon, int i, int j) {
		platoon.add(platoon.get(0));
		platoon.remove(0);
	}

	@Override
	public boolean checkTimeSlot(double time) {
		return (time % HOUR_TWO == 0) ? true : false;
	}

	public String toString() {
		return String.format("Round Robin %s", toString);
	}
}