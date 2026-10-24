package parking.refactored;

import java.util.List;

public interface ReceiptFormatter {
    String format(Receipt receipt);
    String dailyReport(List<Receipt> receipts, double total);
}
