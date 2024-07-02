package com.karthik.ParkingLotSystem.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.karthik.ParkingLotSystem.Exception.InvalidRegistrationNumberException;
import com.karthik.ParkingLotSystem.Exception.ParkingFullException;
import com.karthik.ParkingLotSystem.ParkingSpot.BikeSpot;
import com.karthik.ParkingLotSystem.ParkingSpot.CarSpot;
import com.karthik.ParkingLotSystem.ParkingSpot.ParkingSpot;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;
import com.karthik.ParkingLotSystem.Vehicle.VehicleType;

public class ParkingLot
{
	private final List<BikeSpot> bikeSpots;
	private final List<CarSpot> carSpots;

	private static ParkingLot instance;

	public static ParkingLot getInstance()
	{
		if (instance == null)
			instance = new ParkingLot(10, 10);
		return instance;
	}

	private ParkingLot(int numberOfBikeParkingSpots, int numberOfCarParkingSpots)
	{
		this.bikeSpots = new ArrayList<>();
		this.carSpots = new ArrayList<>();
		initializeParkingSpots(numberOfBikeParkingSpots, numberOfCarParkingSpots);
	}

	private void initializeParkingSpots(int numberOfBikeParkingSpots, int numberOfCarParkingSpots)
	{

		for (int i = 1; i <= numberOfBikeParkingSpots; i++)
		{
			this.bikeSpots.add(new BikeSpot(i));
		}

		System.out.printf("Created a two wheeler parking lot with %s slots %n", numberOfBikeParkingSpots);

		for (int i = numberOfBikeParkingSpots + 1; i <= numberOfBikeParkingSpots + numberOfCarParkingSpots; i++)
		{
			this.carSpots.add(new CarSpot(i));
		}

		System.out.printf("Created a four wheeler parking lot with %s slots %n", numberOfCarParkingSpots);
	}

	public ParkingSpot findParkingSpot(Vehicle vehicle) throws ParkingFullException
	{
		ParkingSpot spot;
		if (vehicle.getVehicleType().name().equals(VehicleType.CAR.name()))
		{
			spot = getNextAvailableCarSpot();
		}
		else
		{
			spot = getNextAvailableBikeSpot();
		}
		return spot;
	}

	private ParkingSpot getNextAvailableCarSpot() throws ParkingFullException
	{
		for (ParkingSpot spot : carSpots)
		{
			if (spot.isSpotFree())
			{
				return spot;
			}
		}
		throw new ParkingFullException("No Empty Slot available");
	}

	private ParkingSpot getNextAvailableBikeSpot() throws ParkingFullException
	{
		for (ParkingSpot spot : bikeSpots)
		{
			if (spot.isSpotFree())
			{
				return spot;
			}
		}
		throw new ParkingFullException("No Empty Slot available");
	}

	public ParkingSpot getCarSpotByRegistrationNumber(String registrationNumber)
			throws InvalidRegistrationNumberException
	{
		for (ParkingSpot spot : carSpots)
		{
			Vehicle vehicle = spot.getVehicle();
			if (vehicle != null && vehicle.getRegistrationNumber().equals(registrationNumber))
			{
				return spot;
			}
		}
		throw new InvalidRegistrationNumberException(
				"Bike with registration number " + registrationNumber + " not found");
	}

	public ParkingSpot getBikeSpotByRegistrationNumber(String registrationNumber)
			throws InvalidRegistrationNumberException
	{
		for (ParkingSpot spot : bikeSpots)
		{
			Vehicle vehicle = spot.getVehicle();
			if (vehicle != null && vehicle.getRegistrationNumber().equals(registrationNumber))
			{
				return spot;
			}
		}
		throw new InvalidRegistrationNumberException(
				"Car with registration number " + registrationNumber + " not found");
	}

	public ParkingSpot unParkFromTicket(Ticket ticket)
	{
		ParkingSpot spot;
		if (ticket.getVehicle().getVehicleType().name().equals(VehicleType.CAR.name()))
		{
			spot = getCarSpotByRegistrationNumber(ticket.getVehicle().getRegistrationNumber());
		}
		else
		{
			spot = getBikeSpotByRegistrationNumber(ticket.getVehicle().getRegistrationNumber());
		}
		return spot;
	}

	public long getHoursParked(Date startDate, Date endDate)
	{
		long secs = (endDate.getTime() - startDate.getTime()) / 1000;
		// int hours = (int) (secs / 3600);
		// return hours;
		return secs;
	}

}
