package at.main.object;

public class AirportConfig {
    private final String name;
    private final double demand;
    private final double x,y;
    private final double latency;
    private final int landingFee;
    private final double FuelCost;

    public String getName() {
        return name;
    }

    public double getDemand() {
        return demand;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLatency() {
        return latency;
    }

    public int getLandingFee() {
        return landingFee;
    }

    public double getFuelCost() {
        return FuelCost;
    }

    public AirportConfig(String name, double demand, double x, double y, double latency, int landingFee, double fuelCost) {
        this.name = name;
        this.demand = demand;
        this.x = x;
        this.y = y;
        this.latency = latency;
        this.landingFee = landingFee;
        FuelCost = fuelCost;
    }
}
