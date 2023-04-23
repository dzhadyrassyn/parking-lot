package practice.ood;

import static practice.ood.PaymentType.CASH;
import static practice.ood.VehicleType.Car;

public class Main {

  public static void main(String[] args) {

    IncomingGate incomingGate = new IncomingGate();

    Transport transport1 = new Transport();
    transport1.type = Car;
    transport1.paymentType = CASH;
    incomingGate.register(transport1);

    Transport transport2 = new Transport();
    transport2.type = Car;
    transport2.paymentType = CASH;
    incomingGate.register(transport2);

    Transport transport3 = new Transport();
    transport3.type = Car;
    transport3.paymentType = CASH;
    incomingGate.register(transport3);

    incomingGate.display();
  }
}
