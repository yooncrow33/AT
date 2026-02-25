package at.main.object.entity.game;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class FlightPlan {
    public ArrayList<Airport> plan = new ArrayList<>();
    final Aircraft ac;
    public FlightPlan(Aircraft ac) {
        this.ac = ac;
    }
    public void addPlan(Airport ap) {
        plan.add(ap);
    }
    public void removePlan() {
        plan.clear();
    }
    public Airport getNextAirport(int index) {
        if (index >= plan.size()) {
            System.out.println("return plan error");
            return plan.get(0);
        }
        return plan.get(index);
    }
}
