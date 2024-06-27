package com.karthik.ParkingLotSystem.Payment;

import java.util.UUID;
import com.karthik.ParkingLotSystem.Service.Ticket;

public class Payment
{
	private final String paymentId;
	private final double amount;
	private final Ticket ticket;
	private PaymentType pType;
	private final PaymentStrategy pStrategy;

	public Payment(double amount, Ticket ticket, PaymentStrategy pStrategy, PaymentType pType)
	{
		this.paymentId = UUID.randomUUID().toString();
		this.amount = amount;
		this.pStrategy = pStrategy;
		this.ticket = ticket;
		this.pType = pType;
	}

	public void makePayment()
	{
		System.out.println(ticket.getVehicle().getRegistrationNumber() + " Successfully Paid ");
	}

	public PaymentType getpType()
	{
		return pType;
	}

	public String getPaymentId()
	{
		return paymentId;
	}

	public double getAmount()
	{
		return amount;
	}

	public Ticket getTicket()
	{
		return ticket;
	}

	public PaymentStrategy getpStrategy()
	{
		return pStrategy;
	}
}
