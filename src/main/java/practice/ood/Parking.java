package practice.ood;

public interface Parking {

    Ticket park(Vehicle vehicle) throws ParkingFullException;

    int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;
}
