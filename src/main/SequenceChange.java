package main;

import java.util.ArrayList;

public interface SequenceChange {
	public String toString = "Sequence Change";

	public void tryToSwitch(ArrayList<Truck> platoon, int i, int j);

	public boolean checkTimeSlot(double time);

	public String toString();
}
