package parking.refactored;

public class Receipt {
    private final Vehicle vehicle;
    private final int hours;
    private final double amount;
    private final String paymentName;

    public Receipt(Vehicle vehicle, int hours, double amount, String paymentName) {
        this.vehicle = vehicle;
        this.hours = hours;
        this.amount = amount;
        this.paymentName = paymentName;
    }
    public Vehicle getVehicle() { return vehicle; }
    public int getHours() { return hours; }
    public double getAmount() { return amount; }
    public String getPaymentName() { return paymentName; }
}
