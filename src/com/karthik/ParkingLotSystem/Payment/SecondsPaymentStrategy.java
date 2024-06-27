package com.karthik.ParkingLotSystem.Payment;

import com.karthik.ParkingLotSystem.Service.Ticket;

public class SecondsPaymentStrategy extends PaymentStrategy
{
	public SecondsPaymentStrategy()
	{
		this.setBikeCharges(10);
		this.setCarCharges(20);
	}

	@Override
	public double calculateCost(Ticket ticket, long secs)
	{
		return secs * getChargeType(ticket.getVehicle().getVehicleType());
	}
}
