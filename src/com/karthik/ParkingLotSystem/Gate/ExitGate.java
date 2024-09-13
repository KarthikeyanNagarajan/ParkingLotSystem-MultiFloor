package com.karthik.ParkingLotSystem.Gate;

import java.util.Date;
import com.karthik.ParkingLotSystem.Payment.Payment;
import com.karthik.ParkingLotSystem.Payment.PaymentStrategy;
import com.karthik.ParkingLotSystem.Payment.PaymentType;
import com.karthik.ParkingLotSystem.Service.ParkingLot;
import com.karthik.ParkingLotSystem.Service.Ticket;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class ExitGate extends Gate
{
	public ExitGate(int gateId)
	{
		this.setGateId(gateId);
		this.setGateType(GateType.EXIT);
	}

	@Override
	public Ticket generateTicket(Vehicle vehicle)
	{
		System.out.println("This is an Exit Gate and cannot Generate Ticket !!!");
		return null;
	}

	@Override
	public void exitTicket(Ticket ticket, PaymentStrategy pStrategy, PaymentType pType)
	{
		long secs = getTotalParkedTime(ticket.getDate(), new Date());
		double amount = makePayment(ticket, pStrategy, pType, secs);

		ParkingLot.getInstance().unparkVehicle(ticket);

		System.out.println("Vehicle Registration No: " + ticket.getVehicle().getRegistrationNumber() + " at FloorNo: "
				+ ticket.getFloorNo() + " and SpotNo: " + ticket.getSpotNo() + " was parked for " + secs
				+ " secs. Total amount: " + amount + ". Exited from GateNo: " + this.getGateId());
	}

	public double makePayment(Ticket ticket, PaymentStrategy pStrategy, PaymentType pType, long secs)
	{
		double amount = pStrategy.calculateCost(ticket, secs);

		Payment p = new Payment(amount, ticket, pStrategy, pType);
		p.makePayment();

		return amount;
	}

	public long getTotalParkedTime(Date startDate, Date endDate)
	{
		long secs = (endDate.getTime() - startDate.getTime()) / 1000;
		return secs;
	}
}
