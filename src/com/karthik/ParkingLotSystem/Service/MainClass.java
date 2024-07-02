package com.karthik.ParkingLotSystem.Service;

import com.karthik.ParkingLotSystem.Payment.PaymentType;
import com.karthik.ParkingLotSystem.Payment.SecondsPaymentStrategy;
import com.karthik.ParkingLotSystem.Terminal.EntryGate;
import com.karthik.ParkingLotSystem.Terminal.ExitGate;
import com.karthik.ParkingLotSystem.Vehicle.Bike;
import com.karthik.ParkingLotSystem.Vehicle.Car;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class MainClass
{

	public static void main(String[] args) throws InterruptedException
	{
		ParkingLot parkingLot = ParkingLot.getInstance();

		Vehicle bike1 = new Bike("BV01XX");
		Vehicle bike2 = new Bike("BV02XX");

		EntryGate entry1 = new EntryGate(1);
		EntryGate entry2 = new EntryGate(2);

		Ticket biketicket1 = entry1.generateTicket(bike1);
		Thread.sleep(1000);
		Ticket biketicket2 = entry2.generateTicket(bike2);

		System.out.println(biketicket1);
		System.out.println(biketicket2);

		Vehicle car1 = new Car("CV01XX");
		Vehicle car2 = new Car("CV02XX");

		Ticket carticket1 = entry1.generateTicket(car1);
		Thread.sleep(1000);
		Ticket carticket2 = entry2.generateTicket(car2);

		System.out.println(carticket1);
		System.out.println(carticket2);

		ExitGate exit1 = new ExitGate(10);
		exit1.exitVehicle(carticket1, new SecondsPaymentStrategy(), PaymentType.UPI);
	}

}
