import java.io.*;
import java.util.*;

/**
 * Handles CSV file input/output for the system.
 */
public class CSVHandler {
    /**
     * Read data from a CSV file and return as a list of string arrays.
     */
    public static List<String[]> readCSV(String filePath) {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath + " - " + e.getMessage());
        }
        return rows;
    }

    /**
     * Write data to a CSV file.
     */
    public static void writeCSV(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filePath + " - " + e.getMessage());
        }
    }
}
