package com.karthik.ParkingLotSystem.Terminal;

import java.util.Date;

import com.karthik.ParkingLotSystem.ParkingSpot.ParkingSpot;
import com.karthik.ParkingLotSystem.Payment.Payment;
import com.karthik.ParkingLotSystem.Payment.PaymentStrategy;
import com.karthik.ParkingLotSystem.Payment.PaymentType;
import com.karthik.ParkingLotSystem.Service.ParkingLot;
import com.karthik.ParkingLotSystem.Service.Ticket;

public class ExitGate
{
	private int gateId;

	public ExitGate(int gateId)
	{
		this.gateId = gateId;
	}

	public double makePayment(Ticket ticket, PaymentStrategy pStrategy, PaymentType pType, long secs)
	{
		double amount = pStrategy.calculateCost(ticket, secs);

		Payment p = new Payment(amount, ticket, pStrategy, pType);
		p.makePayment();

		return amount;
	}

	public void exitVehicle(Ticket ticket, PaymentStrategy pStrategy, PaymentType pType)
	{
		long secs = ParkingLot.getInstance().getHoursParked(ticket.getDate(), new Date());
		double amount = makePayment(ticket, pStrategy, pType, secs);

		ParkingSpot spot = ParkingLot.getInstance().unParkFromTicket(ticket);
		spot.freeVehiclefromSpot();

		System.out.println("Vehicle with registration " + ticket.getVehicle().getRegistrationNumber() + " at spotNo "
				+ ticket.getSpotNo() + " was parked for " + secs + " secs and the total charge is " + amount
				+ " and exited from gateNo " + gateId);
	}

}
