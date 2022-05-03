package main;

import java.util.ArrayList;
import java.util.Collections;

public class TravelingTime implements SequenceChange {
	private static final double HOUR_ONE = 1.0;
	private static final double HOUR_TWO = 2.0;
	private static final int[] delta = { 1, 3, 5, 6, 8 };

	@Override
	public void tryToSwitch(ArrayList<Truck> platoon, int i, int j) {
		Collections.sort(platoon);
	}

	@Override
	public boolean checkTimeSlot(double time) {
		return (time % HOUR_TWO == 0) ? true : false;
	}

	public String toString() {
		return String.format("Traveling Time %s", toString);
	}
}
