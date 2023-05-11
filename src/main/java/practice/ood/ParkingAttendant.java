package practice.ood;

public class ParkingAttendant extends Account {

  public boolean processTicket(String ticketNumber) {
    return true;
  }

  @Override
  public boolean resetPassword() {
    return false;
  }
}
