package at.main.object.entity.game;

import at.main.Main;

public abstract class Aircraft {
    public double health;
    public double fuel;
    public double load;
    FlightPlan flightPlan;
    Airport nextAirport;

    public Aircraft(double health, double fuel, FlightPlan flightPlan, Main main) {
        this.health = health;
        this.fuel = fuel;
        this.flightPlan = flightPlan;
    }

    public void endFlight() {
       /* Airport currentAirport = flightPlan.plan.getFirst();
        fuel += currentAirport.getAc().getFuelCost()

        flightPlan.plan.remove(0);

        */
    }

    public double getFuelForNextAirport() {
        return 100.0;
    }

    public void update(double dt) {

    }
}
