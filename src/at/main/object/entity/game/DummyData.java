package at.main.object.entity.game;

import scope.sideScroll.Entity;

import java.awt.*;

public class DummyData extends Entity {
    @Override
    public void render(Graphics graphics, double v, double v1) {

    }

    @Override
    public void update(double v) {

    }

    public DummyData() {
        super(10, 0,0, true, false, -33);
    }
}
