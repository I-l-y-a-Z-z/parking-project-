package parking.refactored;

import java.io.FileWriter;
import java.io.IOException;

public class FileReceiptLog implements ReceiptLog {
    private final String fileName;
    public FileReceiptLog(String fileName) { this.fileName = fileName; }
    public void log(String receipt) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(receipt + System.lineSeparator());
        }
    }
}
