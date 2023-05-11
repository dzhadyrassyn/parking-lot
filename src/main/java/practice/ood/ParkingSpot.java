package practice.ood;

public abstract class ParkingSpot {
  private int id;
  private boolean isFree;
  private Vehicle vehicle;

  public boolean getIsFree() {
    return true;
  }
  public abstract boolean assignVehicle(Vehicle vehicle);
  public boolean removeVehicle() {
    return true;
  }
}
