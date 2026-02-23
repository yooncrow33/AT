package at.main;

import at.main.object.manager.Console;
import at.main.object.manager.GraphicsManager;
import ie.main.input.at.main.object.input.KetListener;
import scope.EmptyBase;
import scope.SideScrollBase;

import java.awt.*;

public class Main extends SideScrollBase {
    Console console = new Console(scopeEngine(),this);
    public Console getConsole() {return console;}

    KetListener ketListener = new KetListener(this,this);

    GraphicsManager gm = new GraphicsManager();
    @Override
    protected void update(double originalDeltaTime) {
        double dt = originalDeltaTime / (16.0 / 1000.0);

    }

    @Override
    protected void init() {

    }

    @Override
    protected void backGroundRender(Graphics g) {
        gm.backGroundRender(g);
    }

    @Override
    protected void render(Graphics g) {
        console.render(g);
    }

    public Main() {
        super("at",5000,5000);
        launch();
    }

    public static void main(String[] args) {
        new Main();
    }
}