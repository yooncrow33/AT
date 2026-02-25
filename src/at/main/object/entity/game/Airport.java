package at.main.object.entity.game;

import at.main.object.AirportConfig;
import scope.sideScroll.Entity;

import java.awt.*;

public class Airport extends Entity {
    public boolean selected = false;

    AirportConfig ac;

    public Airport(AirportConfig ac) {
        super(20, ac.getX(), ac.getY(), false,true, 0);
        this.ac = ac;
    }


    public boolean isClicked(double x,double y) {
        double dx = ac.getX() - x;
        double dy = ac.getY() - y;
        double distSq = dx * dx + dy * dy;
        double radiusSum = getRadius() + 20;

        // 제곱 비교로 먼저 충돌 여부 확인 (루트 연산 아끼기)
        return distSq < radiusSum * radiusSum;
    }

    public AirportConfig getAc() {
        return ac;
    }

    @Override
    public void render(Graphics g, double x, double y) {
        if (selected) {g.setColor(new Color(240,140,30));} else {g.setColor(new Color(70,70,70));}
        g.fillOval((int) x - getRadius()*2/2, (int) y - getRadius()*2/2, getRadius()*2,getRadius()*2);
        g.setFont(new Font("Impact", Font.PLAIN, 32));
        g.drawString(ac.getName() + " Airport", (int) (x + getRadius() + 5), (int) (y + 11));
    }

    @Override
    public void update(double v) {

    }
}
