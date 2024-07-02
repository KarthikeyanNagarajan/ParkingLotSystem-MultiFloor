package com.karthik.ParkingLotSystem.Terminal;

import com.karthik.ParkingLotSystem.ParkingSpot.ParkingSpot;
import com.karthik.ParkingLotSystem.Service.ParkingLot;
import com.karthik.ParkingLotSystem.Service.Ticket;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class EntryGate
{
	private int gateId;

	public EntryGate(int gateId)
	{
		this.gateId = gateId;
	}

	public Ticket generateTicket(Vehicle vehicle)
	{
		ParkingSpot spot = ParkingLot.getInstance().findParkingSpot(vehicle);
		spot.assignVehicletoSpot(vehicle);
		return new Ticket(gateId, spot.getParkingSpotId(), vehicle, new java.util.Date());
	}

}
