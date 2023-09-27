package practice.ood;

public class Slot {

    public int slotNumber;
    public boolean isAvailable;
    public Vehicle parkVehicle;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        isAvailable = true;
    }

    public void occupySlot(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
        this.isAvailable = false;
    }

    public void vacateSlot() {
        isAvailable = true;
        parkVehicle = null;
    }
}
