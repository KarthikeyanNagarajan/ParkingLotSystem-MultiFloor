package com.karthik.ParkingLotSystem.Service;

import java.util.ArrayList;
import java.util.List;
import com.karthik.ParkingLotSystem.ParkingFloor.ParkingFloor;
import com.karthik.ParkingLotSystem.ParkingSpot.ParkingSpot;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class ParkingLot
{
	private final List<ParkingFloor> floors;

	private ParkingLot()
	{
		this.floors = new ArrayList<>();
	}

	private static ParkingLot instance;

	public static ParkingLot getInstance()
	{
		if (instance == null)
			instance = new ParkingLot();
		return instance;
	}

	public void addFloor(ParkingFloor floor)
	{
		floors.add(floor);
	}

	public ParkingSpot parkVehicle(Vehicle vehicle)
	{
		for (ParkingFloor floor : floors)
		{
			ParkingSpot spot = floor.parkVehicle(vehicle);
			if (spot != null)
			{
				System.out.println("Vehicle parked successfully.");
				return spot;
			}
		}
		System.out.println("Could not park vehicle.");
		return null;
	}

	public boolean unparkVehicle(Ticket ticket)
	{
		for (ParkingFloor floor : floors)
		{
			if (floor.unparkVehicle(ticket.getVehicle()))
			{
				return true;
			}
		}
		return false;
	}

	public void displayAvailability()
	{
		for (ParkingFloor floor : floors)
		{
			floor.displayAvailability();
		}
		System.out.println();
	}
}
