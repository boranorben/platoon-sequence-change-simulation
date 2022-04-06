package main;

import java.util.ArrayList;

public interface SequenceChange {
	public boolean checkTimeSlot(double time);
	public void tryToSwitch(ArrayList<Truck> platoon, int i, int j);

//	public boolean checkTimeSlot(double time);
//	public boolean canSwitch(ArrayList<Truck> platoon, int i, int j);
//	public void switchPos(ArrayList<Truck> platoon, int i, int j);
//
	
}
