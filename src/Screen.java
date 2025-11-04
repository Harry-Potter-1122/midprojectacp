import java.util.*;

public class Screen {
    private static Scanner input = new Scanner(System.in);

    // ---------- HOME MANAGEMENT ----------
    public static void manageHomes(List<Home> homes) {
        while (true) {
            System.out.println("\n--- Home Management ---");
            for (int i = 0; i < homes.size(); i++) {
                System.out.println((i + 1) + ". " + homes.get(i).getName());
            }
            System.out.println("A. Add Home");
            System.out.println("D. Delete Home");
            System.out.println("B. Back");
            System.out.print("Choose: ");
            String choice = input.nextLine();

            switch (choice.toUpperCase()) {
                case "A" -> {
                    System.out.print("Enter home name: ");
                    String name = input.nextLine();
                    homes.add(new Home(name));
                    System.out.println("Home added successfully.");
                }
                case "D" -> {
                    System.out.print("Enter home number to delete: ");
                    int index = Integer.parseInt(input.nextLine()) - 1;
                    if (index >= 0 && index < homes.size()) {
                        homes.remove(index);
                        System.out.println("Home deleted.");
                    } else {
                        System.out.println("Invalid selection.");
                    }
                }
                case "B" -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ---------- DEVICE MANAGEMENT ----------
    public static void manageDevices(List<Home> homes, double ratePerUnit) {
        if (homes.isEmpty()) {
            System.out.println("No homes available. Add one first.");
            return;
        }

        System.out.println("\nSelect Home:");
        for (int i = 0; i < homes.size(); i++) {
            System.out.println((i + 1) + ". " + homes.get(i).getName());
        }
        System.out.print("Enter home number: ");
        int homeIndex = Integer.parseInt(input.nextLine()) - 1;

        if (homeIndex < 0 || homeIndex >= homes.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Home selectedHome = homes.get(homeIndex);

        while (true) {
            System.out.println("\n--- Devices for " + selectedHome.getName() + " ---");
            List<Device> devices = selectedHome.getDevices();
            if (devices.isEmpty()) System.out.println("No devices added yet.");
            else {
                for (int i = 0; i < devices.size(); i++) {
                    Device d = devices.get(i);
                    double monthlyKwh = (d.getWatts() * d.getHours() * 30) / 1000;
                    System.out.printf("%d. %s - %.1fW, %.1fh/day, %.2f kWh/month\n",
                            i + 1, d.getName(), d.getWatts(), d.getHours(), monthlyKwh);
                }
                System.out.printf("Total Monthly Bill: Rs. %.2f\n", selectedHome.calculateMonthlyBill(ratePerUnit));
            }

            System.out.println("A. Add Device");
            System.out.println("D. Delete Device");
            System.out.println("B. Back");
            System.out.print("Choose: ");
            String choice = input.nextLine();

            switch (choice.toUpperCase()) {
                case "A" -> addDevice(selectedHome);
                case "D" -> deleteDevice(selectedHome);
                case "B" -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addDevice(Home home) {
        try {
            System.out.print("Enter device name: ");
            String name = input.nextLine();
            System.out.print("Enter power (watts): ");
            double watts = Double.parseDouble(input.nextLine());
            System.out.print("Enter hours per day: ");
            double hours = Double.parseDouble(input.nextLine());

            home.addDevice(new Device(name, watts, hours));
            System.out.println("Device added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter numbers correctly.");
        }
    }

    private static void deleteDevice(Home home) {
        System.out.print("Enter device number to delete: ");
        int index = Integer.parseInt(input.nextLine()) - 1;
        home.removeDevice(index);
    }

    // ---------- SETTINGS ----------
    public static double manageSettings(double ratePerUnit) {
        System.out.println("\n--- Settings ---");
        System.out.printf("Current Rate: Rs. %.2f per kWh\n", ratePerUnit);
        System.out.print("Enter new rate (or press Enter to keep same): ");
        String newRateStr = input.nextLine();

        if (!newRateStr.isEmpty()) {
            try {
                double newRate = Double.parseDouble(newRateStr);
                System.out.println("Rate updated successfully.");
                return newRate;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, rate not changed.");
            }
        } else {
            System.out.println("No changes made.");
        }
        return ratePerUnit;
    }
}
