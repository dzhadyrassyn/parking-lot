package practice.ood;

import java.util.Date;

public class Ticket {

    public int slotNumber;
    public String vehicleNumber;
    public Date date;
    public VehicleSize vehicleSize;

    public Ticket(int slotNumber, String vehicleNumber, VehicleSize vehicleSize, Date date) {
        this.slotNumber = slotNumber;
        this.vehicleNumber = vehicleNumber;
        this.date = date;
        this.vehicleSize = vehicleSize;
    }
}
