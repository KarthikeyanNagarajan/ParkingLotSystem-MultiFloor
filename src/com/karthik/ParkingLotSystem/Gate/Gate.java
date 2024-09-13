package com.karthik.ParkingLotSystem.Gate;

import com.karthik.ParkingLotSystem.Payment.PaymentStrategy;
import com.karthik.ParkingLotSystem.Payment.PaymentType;
import com.karthik.ParkingLotSystem.Service.Ticket;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public abstract class Gate
{
	private int gateId;
	private GateType gateType;
	
	public abstract Ticket generateTicket(Vehicle vehicle);
	
	public abstract void exitTicket(Ticket ticket, PaymentStrategy pStrategy, PaymentType pType);

	public int getGateId()
	{
		return gateId;
	}

	public void setGateId(int gateId)
	{
		this.gateId = gateId;
	}

	public GateType getGateType()
	{
		return gateType;
	}

	public void setGateType(GateType gateType)
	{
		this.gateType = gateType;
	}
}
