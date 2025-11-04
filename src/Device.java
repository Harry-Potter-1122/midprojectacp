public class Device {
    private String name;
    private double watts;
    private double hours;

    public Device(String name, double watts, double hours) {
        this.name = name;
        this.watts = watts;
        this.hours = hours;
    }

    public String getName() { return name; }
    public double getWatts() { return watts; }
    public double getHours() { return hours; }
}
