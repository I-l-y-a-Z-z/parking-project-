package parking.refactored;

import java.util.List;

public class TextReceiptFormatter implements ReceiptFormatter {
    public String format(Receipt receipt) {
        return receipt.getVehicle().getPlate() + " | " + receipt.getVehicle().getType()
                + " | " + receipt.getHours() + " h | " + receipt.getAmount()
                + " MAD | " + receipt.getPaymentName();
    }
    public String dailyReport(List<Receipt> receipts, double total) {
        StringBuilder text = new StringBuilder("=== Daily report ===\n");
        for (Receipt receipt : receipts) text.append(format(receipt)).append("\n");
        text.append("Total: ").append(total).append(" MAD");
        return text.toString();
    }
}
