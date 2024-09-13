package com.karthik.ParkingLotSystem.ParkingFloor;

import java.util.ArrayList;
import java.util.List;
import com.karthik.ParkingLotSystem.ParkingSpot.BikeSpot;
import com.karthik.ParkingLotSystem.ParkingSpot.CarSpot;
import com.karthik.ParkingLotSystem.ParkingSpot.ParkingSpot;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class ParkingFloor
{
	private int floorId;
	private List<ParkingSpot> parkingSpots;

	public ParkingFloor(int floor, int numSpots)
	{
		this.floorId = floor;
		parkingSpots = new ArrayList<>(numSpots);

		initializeParkingSpots(numSpots);
	}

	private void initializeParkingSpots(int numSpots)
	{
		double spotsForBikes = 0.50;
		double spotsForCars = 0.50;

		int numBikes = (int) (numSpots * spotsForBikes);
		int numCars = (int) (numSpots * spotsForCars);

		for (int i = 1; i <= numBikes; i++)
		{
			parkingSpots.add(new BikeSpot(floorId, i));
		}

		System.out.println("Created " + numBikes +  " Bike parking spots at floor " + floorId);

		for (int i = numBikes + 1; i <= numSpots; i++)
		{
			parkingSpots.add(new CarSpot(floorId, i));
		}
		System.out.println("Created " + numCars +  " Car parking spots at floor " + floorId);
	}

	public ParkingSpot parkVehicle(Vehicle vehicle)
	{
		for (ParkingSpot spot : parkingSpots)
		{
			if (spot.isSpotFree() && spot.getSpotType().name().equals(vehicle.getVehicleType().name()))
			{
				spot.assignVehicletoSpot(vehicle);
				return spot;
			}
		}
		return null;
	}

	public boolean unparkVehicle(Vehicle vehicle)
	{
		for (ParkingSpot spot : parkingSpots)
		{
			if (!spot.isSpotFree() && spot.getVehicle().equals(vehicle))
			{
				spot.freeVehiclefromSpot();
				return true;
			}
		}
		return false;
	}

	public void displayAvailability()
	{
		System.out.println();
		System.out.println("Level " + floorId + " Display:");
		for (ParkingSpot spot : parkingSpots)
		{
			System.out.println("Spot " + spot.getSpotId() + ": "
					+ (spot.isSpotFree() ? "Available For" : "Occupied By ") + " " + spot.getSpotType().name());
		}
	}
}
