package com.karthik.ParkingLotSystem.ParkingSpot;

import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class ParkingSpot
{
	private int floorId;
	private int spotId;
	private boolean spotFree;
	private Vehicle vehicle;
	private ParkingSpotType spotType;

	public ParkingSpot(int floorId, int spotId, ParkingSpotType spotType)
	{
		this.floorId = floorId;
		this.spotId = spotId;
		this.spotType =spotType;
		this.spotFree = true;
	}

	public int getFloorId()
	{
		return floorId;
	}

	public int getSpotId()
	{
		return spotId;
	}

	public boolean isSpotFree()
	{
		return spotFree;
	}

	public Vehicle getVehicle()
	{
		return vehicle;
	}

	public void assignVehicletoSpot(Vehicle vehicle)
	{
		this.vehicle = vehicle;
		this.spotFree = false;
	}

	public ParkingSpotType getSpotType()
	{
		return spotType;
	}

	public void freeVehiclefromSpot()
	{
		this.vehicle = null;
		this.spotFree = true;
	}
}