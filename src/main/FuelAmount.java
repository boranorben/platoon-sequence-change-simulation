package main;

import java.util.ArrayList;
import java.util.Collections;

public class FuelAmount implements SequenceChange {
	private static final double FULL_RATE = 32.6; // fuel consumption rate
	private static final double HALF_RATE = 16.3; // fuel consumption rate divided by two

	@Override
	public void tryToSwitch(ArrayList<Truck> platoon, int i, int j) {
		Truck currTruck = platoon.get(i);
		Truck nextTruck = platoon.get(j);

		if (nextTruck.getCurrFuel() - currTruck.getCurrFuel() >= FULL_RATE) {
			Collections.swap(platoon, i, j);
		}
	}
	
	@Override
	public boolean checkTimeSlot(double time) {
		return false;
	}
}
