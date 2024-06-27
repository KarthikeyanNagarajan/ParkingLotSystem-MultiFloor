package com.karthik.ParkingLotSystem.ParkingFloor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.karthik.ParkingLotSystem.ParkingSpot.ParkingSpot;
import com.karthik.ParkingLotSystem.ParkingSpot.ParkingSpotType;
import com.karthik.ParkingLotSystem.Service.ParkingLot;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;
import com.karthik.ParkingLotSystem.Vehicle.VehicleType;

public class ParkingFloor
{
	private final String floorId;
	private Map<ParkingSpotType, List<ParkingSpot>> pSpaces = new HashMap<>();

	public ParkingFloor(String floorId)
	{
		this.floorId = floorId;
		pSpaces.put(ParkingSpotType.BIKE, new ArrayList<>());
		pSpaces.put(ParkingSpotType.CAR, new ArrayList<>());
	}

	public void addParkingSpace(ParkingSpot p)
	{
		pSpaces.get(p.getParkingSpotType()).add(p);
	}

	public void removeParkingSpace(ParkingSpot p)
	{
		pSpaces.get(p.getParkingSpotType()).remove(p);
	}

	public boolean canParkVehicle(VehicleType vType)
	{
		for (ParkingSpot p : pSpaces.get(getSpaceTypeForVehicle(vType)))
		{
			if (p.isSpotFree())
				return true;
		}
		return false;
	}

	private ParkingSpotType getSpaceTypeForVehicle(VehicleType vType)
	{
		switch (vType)
		{
		case CAR:
			return ParkingSpotType.CAR;
		case BIKE:
			return ParkingSpotType.BIKE;

		}
		return null;
	}

	public void getSpace(Vehicle v)
	{
		List<ParkingSpot> availableSpaces = new ArrayList<>();
		for (ParkingSpot p : pSpaces.get(getSpaceTypeForVehicle(v.getVehicleType())))
			if (p.isSpotFree())
				availableSpaces.add(p);
		// return ParkingLot.INSTANCE.getPStrategy().park(availableSpaces);

	}
}
