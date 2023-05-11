package practice.ood;

public class Admin extends Account {

  @Override
  public boolean resetPassword() {
    return false;
  }

  public boolean addParkingSpot(ParkingSpot parkingSpot) {
    return true;
  }

  public boolean addDisplayBoard(DisplayBoard displayBoard) {
    return true;
  }

  public boolean addEntrance(Entrance entrance) {
    return true;
  }

  public boolean addExit(Exit exit) {
    return true;
  }



}
