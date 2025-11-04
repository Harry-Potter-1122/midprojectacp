import java.util.*;

public class Home {
    private String name;
    private List<Device> devices;

    public Home(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Device> getDevices() { return devices; }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(int index) {
        if (index >= 0 && index < devices.size()) {
            devices.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public double calculateMonthlyBill(double ratePerUnit) {
        double totalKwh = 0;
        for (Device d : devices) {
            totalKwh += (d.getWatts() * d.getHours() * 30) / 1000;
        }
        return totalKwh * ratePerUnit;
    }
}
