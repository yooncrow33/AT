package at.main.object.entity;

import scope.sideScroll.Entity;

import java.awt.*;

public class View extends Entity {
    final double speed = 10.0;

    boolean moveUp = false;
    boolean moveLeft = false;
    boolean moveDown = false;
    boolean moveRight = false;

    public View() {
        super(2, 0, 0, false,true,-21);
    }

    public void moveTrueW() {
        moveUp = true;
    }
    public void moveTrueA() {
        moveLeft = true;
    }
    public void moveTrueS() {
        moveDown = true;
    }
    public void moveTrueD() {
        moveRight = true;
    }

    public void moveFalseW() {
        moveUp = false;
    }
    public void moveFalseA() {
        moveLeft = false;
    }
    public void moveFalseS() {
        moveDown = false;
    }
    public void moveFalseD() {
        moveRight = false;
    }

    @Override
    public void render(Graphics g, double x, double y) {
    }

    public void update(double delta) {
        double dt = delta / (16.0 / 1000.0);
        if (moveUp) { addY(- speed * dt); }
        if (moveDown) { addY(+ speed * dt); }
        if (moveLeft) { addX(- speed * dt); }
        if (moveRight) { addX(+ speed * dt); }
    }
}
