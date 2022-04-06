package main;

import java.util.ArrayList;

public class RoundRobin implements SequenceChange {

	@Override
	public void tryToSwitch(ArrayList<Truck> platoon, int i, int j) {
		platoon.add(platoon.get(0));
		platoon.remove(0);
	}

	@Override
	public boolean checkTimeSlot(double time) {
		return true;
	}

	public String toString() {
		return "Round Robin Sequence Change";
	}
}