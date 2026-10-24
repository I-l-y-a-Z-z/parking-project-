package parking.refactored;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final ReceiptFormatter formatter;
    private final ReceiptLog log;
    private final List<Receipt> receipts = new ArrayList<>();
    private double total;

    public ParkingService(ReceiptFormatter formatter, ReceiptLog log) {
        this.formatter = formatter;
        this.log = log;
    }
    public double fee(Vehicle vehicle, int hours) {
        return vehicle.getTariff().fee(hours);
    }
    public void checkout(Vehicle vehicle, int hours, PaymentMethod method) throws IOException {
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total += amount;
        Receipt receipt = new Receipt(vehicle, hours, amount, method.name());
        receipts.add(receipt);
        log.log(formatter.format(receipt));
    }
    public void cancel(Vehicle vehicle, int hours, RefundablePayment method) {
        double amount = fee(vehicle, hours);
        method.refund(amount);
        registerRefund(amount);
    }
    public void registerRefund(double amount) { total -= amount; }
    public double getTotal() { return total; }
    public String dailyReport() { return formatter.dailyReport(receipts, total); }
}
