package com.karthik.ParkingLotSystem.Gate;

import com.karthik.ParkingLotSystem.ParkingSpot.ParkingSpot;
import com.karthik.ParkingLotSystem.Payment.PaymentStrategy;
import com.karthik.ParkingLotSystem.Payment.PaymentType;
import com.karthik.ParkingLotSystem.Service.ParkingLot;
import com.karthik.ParkingLotSystem.Service.Ticket;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class EntryGate extends Gate
{
	public EntryGate(int gateId)
	{
		this.setGateId(gateId);
		this.setGateType(GateType.ENTRY);
	}

	@Override
	public Ticket generateTicket(Vehicle vehicle)
	{
		ParkingSpot spot = ParkingLot.getInstance().parkVehicle(vehicle);
		if(spot != null)
			return new Ticket(this.getGateId(), spot.getFloorId(), spot.getSpotId(), vehicle, new java.util.Date());
		return null;
	}

	@Override
	public void exitTicket(Ticket ticket, PaymentStrategy pStrategy, PaymentType pType)
	{
		System.out.println("This is an Entry Gate and cannot Exit Ticket !!!");
	}
}
