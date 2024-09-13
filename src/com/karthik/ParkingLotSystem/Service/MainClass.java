package com.karthik.ParkingLotSystem.Service;

import com.karthik.ParkingLotSystem.Gate.EntryGate;
import com.karthik.ParkingLotSystem.Gate.ExitGate;
import com.karthik.ParkingLotSystem.Gate.Gate;
import com.karthik.ParkingLotSystem.ParkingFloor.ParkingFloor;
import com.karthik.ParkingLotSystem.Payment.PaymentType;
import com.karthik.ParkingLotSystem.Payment.SecondsPaymentStrategy;
import com.karthik.ParkingLotSystem.Vehicle.Bike;
import com.karthik.ParkingLotSystem.Vehicle.Car;
import com.karthik.ParkingLotSystem.Vehicle.Vehicle;

public class MainClass
{

	public static void main(String[] args) throws InterruptedException
	{
		ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addFloor(new ParkingFloor(1, 2));
        parkingLot.addFloor(new ParkingFloor(2, 4));

		Vehicle bike1 = new Bike("BV01XX");
		Vehicle bike2 = new Bike("BV02XX");
		Vehicle car1 = new Car("CV01XX");
		Vehicle car2 = new Car("CV02XX");

		Gate entryGate = new EntryGate(1);
		ExitGate exitGate = new ExitGate(2);

		Ticket biketicket1 = entryGate.generateTicket(bike1);
		Thread.sleep(1000);
		Ticket biketicket2 = entryGate.generateTicket(bike2);
		Thread.sleep(1000);
		Ticket carticket1 = entryGate.generateTicket(car1);
		Thread.sleep(1000);
		Ticket carticket2 = entryGate.generateTicket(car2);
		Thread.sleep(1000);
		
		parkingLot.displayAvailability();

		System.out.println(biketicket1);
		System.out.println(biketicket2);
		System.out.println(carticket1);
		System.out.println(carticket2);

		
		exitGate.exitTicket(carticket1, new SecondsPaymentStrategy(), PaymentType.UPI);
		
		parkingLot.displayAvailability();
	}

}
