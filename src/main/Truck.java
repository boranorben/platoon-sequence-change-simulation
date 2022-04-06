package main;

public class Truck implements Comparable<Truck> {
	private int order;

	private final static double INIT_FUEL = 1135.62; // 300 gallon = 1135.62l
	protected final static double FUEL_CONSUMP = 0.326; // 32.6l/100km
	private double currFuel;

	private int velocity;
	private int interDist;

	private int constVelocity;
	private int constInterDist;

	public Truck(int order, int constVelocity, int constInterDist) {
		this.order = order;

		this.constVelocity = constVelocity;
		this.constInterDist = constInterDist;

		this.currFuel = this.INIT_FUEL;
		this.velocity = 0;
		this.interDist = 0;
	}

	public int getOrder() {
		return this.order;
	}

	public double getCurrFuel() {
		return this.currFuel;
	}

	public int getVelocity() {
		return this.velocity;
	}

	public int getInterDist() {
		return this.interDist;
	}

	public void calFuel(double reducedFuelConsump) {
		this.currFuel += (this.FUEL_CONSUMP * reducedFuelConsump / 100) - this.FUEL_CONSUMP;
	}

	public String toString() {
		return String.format("Truck %d has current fuel at %.2f l", this.order, this.currFuel);
	}

	@Override
	public int compareTo(Truck o) {
		return (this.getCurrFuel() < o.getCurrFuel()) ? 1 : (this.getCurrFuel() > o.getCurrFuel()) ? -1 : 0;
	}
}
