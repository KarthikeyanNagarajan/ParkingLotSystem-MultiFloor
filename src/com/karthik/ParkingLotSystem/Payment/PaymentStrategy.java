package com.karthik.ParkingLotSystem.Payment;

import com.karthik.ParkingLotSystem.Service.Ticket;
import com.karthik.ParkingLotSystem.Vehicle.VehicleType;

public abstract class PaymentStrategy
{
	private double bikeCharges;
	private double carCharges;

	public abstract double calculateCost(Ticket t, long secs);

	protected double getChargeType(VehicleType type)
	{
		switch (type)
		{
		case CAR:
			return carCharges;
		case BIKE:
			return bikeCharges;
		}
		return 0;
	}

	public double getBikeCharges()
	{
		return bikeCharges;
	}

	public void setBikeCharges(double bikeCharges)
	{
		this.bikeCharges = bikeCharges;
	}

	public double getCarCharges()
	{
		return carCharges;
	}

	public void setCarCharges(double carCharges)
	{
		this.carCharges = carCharges;
	}
}
