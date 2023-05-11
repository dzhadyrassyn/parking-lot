package practice.ood;

import java.util.HashMap;

public class ParkingLot {

  private int id;
  private String name;
  private String address;
  private ParkingRate parkingRate;

  private HashMap<String, Entrance> entrance;
  private HashMap<String, Exit> exit;

  private HashMap<String, ParkingTicket> tickets;
  private static ParkingLot parkingLot = null;

  private ParkingLot() {

  }

  public static ParkingLot getInstance() {
    if (parkingLot == null) {
      parkingLot = new ParkingLot();
    }
    return parkingLot;
  }

  public boolean addEntrance(Entrance entrance) {
    return true;
  }

  public boolean addExit(Exit exit) {
    return true;
  }

  public ParkingTicket getParkingTicket(Vehicle vehicle) {
    return null;
  }

  public boolean isFull(ParkingSpot type){
    return true;
  }
}
