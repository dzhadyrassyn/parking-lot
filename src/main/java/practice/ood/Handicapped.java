package practice.ood;

public class Handicapped extends ParkingSpot {

  @Override
  public boolean assignVehicle(Vehicle vehicle) {
    return false;
  }
}
