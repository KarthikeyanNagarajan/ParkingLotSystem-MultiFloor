package com.karthik.ParkingLotSystem.Service;

import java.util.Date;

import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class Ticket
{
	private int gateNo;
	private int spotNo;
	private Vehicle vehicle;
	private Date date;

	public Ticket(int gateNo, int spotNo, Vehicle vehicle, Date date)
	{
		this.gateNo = gateNo;
		this.spotNo = spotNo;
		this.vehicle = vehicle;
		this.date = date;
	}

	public int getGateNo()
	{
		return gateNo;
	}

	public int getSpotNo()
	{
		return spotNo;
	}

	public Vehicle getVehicle()
	{
		return vehicle;
	}

	public Date getDate()
	{
		return date;
	}

	@Override
	public String toString()
	{
		return "Ticket [gateNo=" + gateNo + ", spotNo=" + spotNo + ", date=" + date + ", " + vehicle + " ]";
	}
}
