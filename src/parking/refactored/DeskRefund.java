package parking.refactored;

public class DeskRefund {
    private final ParkingService service;
    public DeskRefund(ParkingService service) { this.service = service; }

    public void refund(Vehicle vehicle, int hours) {
        double amount = service.fee(vehicle, hours);
        System.out.println("Refund " + amount + " MAD at the desk for " + vehicle.getPlate());
        service.registerRefund(amount);
    }
}
