import java.io.*;
import java.util.*;

public class MainApp {
    private static Scanner input = new Scanner(System.in);
    private static double ratePerUnit = 30.0;
    private static List<Home> homes = new ArrayList<>();
    private static final String DATA_FILE = "data.txt";

    public static void main(String[] args) {
        loadData();

        while (true) {
            System.out.println("\n=== ELECTRICITY TRACKER ===");
            System.out.println("1. Manage Homes");
            System.out.println("2. Manage Devices");
            System.out.println("3. Settings");
            System.out.println("4. Save & Exit");
            System.out.print("Choose an option: ");
            String choice = input.nextLine();

            try {
                switch (choice) {
                    case "1" -> Screen.manageHomes(homes);
                    case "2" -> Screen.manageDevices(homes, ratePerUnit);
                    case "3" -> ratePerUnit = Screen.manageSettings(ratePerUnit);
                    case "4" -> {
                        saveData();
                        System.out.println("Data saved. Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice, try again.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }

    // ---------- File Handling ----------
    private static void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            writer.println(ratePerUnit);
            for (Home home : homes) {
                writer.println("HOME:" + home.getName());
                for (Device d : home.getDevices()) {
                    writer.println("DEVICE:" + d.getName() + "," + d.getWatts() + "," + d.getHours());
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) ratePerUnit = Double.parseDouble(line);

            Home currentHome = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("HOME:")) {
                    currentHome = new Home(line.substring(5));
                    homes.add(currentHome);
                } else if (line.startsWith("DEVICE:") && currentHome != null) {
                    String[] parts = line.substring(7).split(",");
                    currentHome.addDevice(new Device(parts[0],
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2])));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
