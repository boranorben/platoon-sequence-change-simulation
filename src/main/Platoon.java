package main;

import java.util.ArrayList;

public class Platoon {
	private SequenceChange seqncChange;
	private ArrayList<Truck> platoon;
	private ArrayList<String> platoonSeqnc;
	private boolean isDriving;
	private int distance;

	private final static int CONST_VELOCITY = 85;
	private final static int CONST_INTERDIST = 6;
	private final static double[] CONSUMP_REDUCE = { 4.3, 10.0, 14.0 };

	public Platoon(SequenceChange seqncChange, int numTruck) {
		this.seqncChange = seqncChange;
		this.platoon = new ArrayList<>(numTruck);
		this.platoonSeqnc = new ArrayList<>();
		this.isDriving = true;
		this.distance = 0;

		for (int i = 0; i < numTruck; i++) {
			this.platoon.add(new Truck((i + 1), CONST_VELOCITY, CONST_INTERDIST));
		}
	}

	private void stopDriving() {
		this.isDriving = false;
	}

	private double reducedfuelConsump(int order) {
		double reducePercent = 0.0;
		switch (order) {
		case 0:
			reducePercent = CONSUMP_REDUCE[0];
			break;
		case 1:
			reducePercent = CONSUMP_REDUCE[1];
			break;
		default:
			reducePercent = CONSUMP_REDUCE[2];
			break;
		}
		return reducePercent;
	}

	private void saveSeqnc() {
		String order = "";
		for (Truck truck : platoon) {
			order += truck.getOrder();
		}
		this.platoonSeqnc.add(order);
	}

	private int getSwitchCnt() {
		int cnt = 0;
		for (int i = 0; i < this.platoonSeqnc.size() - 1; i++) {
			if (!platoonSeqnc.get(i).equals(platoonSeqnc.get(i + 1))) {
				cnt++;
			}
		}
		return cnt;
	}
	
	private void sortTimeSlot() {
		
	}

	public ArrayList<String> getPlatoonSeqnc() {
		return this.platoonSeqnc;
	}

	public double getCurrTime() {
		return (double) this.distance / (double) this.CONST_VELOCITY;
	}

	public ArrayList<Truck> getPlatoon() {
		return this.platoon;
	}

	public void printTruckStatus() {
		if (this.getCurrTime() % 1.0 == 0) {
			System.out.printf("[Hour %.0f]\n", this.getCurrTime());
			for (Truck truck : this.platoon) {
				System.out.println(truck.toString());
			}
			System.out.println("---------------------------------------------------");
		}
	}

	public String toString() {
		return String.format("Total distance: %d km / Total time: %.1f hr / Switch count: %d", this.distance,
				this.getCurrTime(), this.getSwitchCnt());
	}

	public void start() {
		while (this.isDriving) {
//			this.printTruckStatus();

			for (int i = 0; i < this.platoon.size(); i++) {
				Truck currTruck = this.platoon.get(i);

				if (currTruck.getCurrFuel() <= Truck.FUEL_CONSUMP) {
					this.stopDriving();
					break;
				}
				for (int j = i + 1; j < this.platoon.size(); j++) {

					// Sequence Change algorithm here
					if (this.seqncChange instanceof FuelAmount) {
						this.seqncChange.tryToSwitch(this.platoon, i, j);
					} else {
						if (this.getCurrTime() == Math.floor(this.getCurrTime())
								&& this.seqncChange.checkTimeSlot(this.getCurrTime())) {
							this.seqncChange.tryToSwitch(platoon, i, j);
						}
					}
				}
				currTruck.calFuel(this.reducedfuelConsump(i));
			}
			if (this.getCurrTime() == Math.floor(this.getCurrTime())) {
				this.saveSeqnc();
			}
			this.distance++;
		}

		System.out.println(this.toString());
		for (String orderString : this.platoonSeqnc) {
			System.out.println(orderString);
		}
	}
}
