package practice.ood;

import static practice.ood.VehicleType.*;

public class IncomingGate {

  public int MAX_THRESHOLD = 8;
  public int cars = 2;
  public int trucks = 2;
  public int vans = 2;
  public int motorcycles = 2;
  public int cnt = 0;

  public void register(Transport transport) {
    System.out.println("Registering a new transport for slot..");
    if (transport.type == Car &&  cars - 1 >= 0) {
      cars -= 1;
      cnt += 1;
    } else if (transport.type == Truck && trucks - 1 >= 0) {
      trucks -= 1;
      cnt += 1;
    } else if (transport.type == Van && vans - 1 >= 0) {
      vans -= 1;
      cnt += 1;
    } else if (transport.type == Motorcycle && motorcycles - 1 >= 0) {
      motorcycles -= 1;
      cnt += 1;
    } else {
      System.out.println("Cannot register " + transport.type.name() + ". No free slots are available");
    }
  }

  public void unregister(Transport transport) {
    System.out.println("Unregistering a transport...");

  }

  public void display() {
    System.out.println("Amount of free slots: " + (MAX_THRESHOLD - cnt));
    System.out.println("Car slots available: " + cars);
    System.out.println("Truck slots available: " + trucks);
    System.out.println("Van slots available: " + vans);
    System.out.println("Motorcycle slots available: " + motorcycles);

  }
}
