package practice.ood;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot implements Parking {

    private static ParkingLot parkingLot;
    private final List<Slot> twoWheelerSlots;
    private final List<Slot> fourWheelerSlots;

    private ParkingLot() {
        twoWheelerSlots = new ArrayList<>();
        fourWheelerSlots = new ArrayList<>();
    }

    public static ParkingLot getParkingLot() {
        if (parkingLot == null) {
            return new ParkingLot();
        }
        return parkingLot;
    }

    public boolean initializeParkingSlots(int numberOfTwoWheelerParkingSlots, int numberOfFourWheelerParkingSlots) {
        for (int i = 1; i <= numberOfTwoWheelerParkingSlots; i++) {
            twoWheelerSlots.add(new Slot(i));
        }

        System.out.printf("Created a two wheeler parking lot with %s slots %n", numberOfTwoWheelerParkingSlots);

        for (int i = 1; i <= numberOfFourWheelerParkingSlots; i++) {
            fourWheelerSlots.add(new Slot(i));
        }

        System.out.printf("Created a four wheeler parking lot with %s slots %n", numberOfFourWheelerParkingSlots);
        return true;
    }

    private Slot getNextAvailableFourWheelerSlot() throws ParkingFullException {
        for (Slot fourWheelerSlot : fourWheelerSlots) {
            if (fourWheelerSlot.isAvailable) {
                return fourWheelerSlot;
            }
        }

        throw new ParkingFullException("No Empty Slot available");
    }

    private Slot getNextAvailableTwoWheelerSlot() throws ParkingFullException {
        for (Slot twoWheelerSlot : twoWheelerSlots) {
            if (twoWheelerSlot.isAvailable) {
                return twoWheelerSlot;
            }
        }

        throw new ParkingFullException("No Empty Slot available");
    }


    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        Slot availableSlot = vehicle.vehicleSize == VehicleSize.FOURWHEELER ? getNextAvailableFourWheelerSlot() : getNextAvailableTwoWheelerSlot();
        availableSlot.occupySlot(vehicle);
        System.out.printf("Allocated slot number: %d \n", availableSlot.slotNumber);
        Ticket ticket = new Ticket(availableSlot.slotNumber, vehicle.vehicleNumber,
                vehicle.vehicleSize, new Date());
        return ticket;
    }

    @Override
    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException {
        int costByHours;
        Slot slot;
        try {
            if (ticket.vehicleSize == VehicleSize.FOURWHEELER) {
                slot = getFourWheelerSlotByVehicleNumber(ticket.vehicleNumber);
            } else {
                slot = getTwoWheelerSlotByVehicleNumber(ticket.vehicleNumber);
            }
            slot.vacateSlot();
            int hours = getHoursParked(ticket.date, new Date());
            costByHours = parkingCostStrategy.getCharge(hours);
            System.out.println(
                    "Vehicle with registration " + ticket.vehicleNumber + " at slot number " + slot.slotNumber
                            + " was parked for " + hours + " hours and the total charge is " + costByHours);
        } catch (InvalidVehicleNumberException invalidVehicleNumber) {
            System.out.println(invalidVehicleNumber.getMessage());
            throw invalidVehicleNumber;
        }
        return costByHours;
    }


    private int getHoursParked(Date startDate, Date endDate) {
        long secs = (endDate.getTime() - startDate.getTime()) / 1000;
        int hours = (int) (secs / 3600);
        return hours;

    }


    private Slot getTwoWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException {
        for (Slot twoWheelerSlot : twoWheelerSlots) {
            Vehicle parkVehicle = twoWheelerSlot.parkVehicle;
            if (parkVehicle != null && vehicleNumber.equals(parkVehicle.vehicleNumber)) {
                return twoWheelerSlot;
            }
        }

        throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
    }

    private Slot getFourWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException {
        for (Slot fourWheelerSlot : fourWheelerSlots) {
            Vehicle parkVehicle = fourWheelerSlot.parkVehicle;
            if (parkVehicle != null && vehicleNumber.equals(parkVehicle.vehicleNumber)) {
                return fourWheelerSlot;
            }
        }

        throw new InvalidVehicleNumberException("Four wheeler with registration number " + vehicleNumber + " not found");
    }

}
