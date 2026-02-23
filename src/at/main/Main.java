package at.main;

import at.main.object.AirportConfig;
import at.main.object.entity.View;
import at.main.object.entity.game.Airport;
import at.main.object.entity.game.DummyData;
import at.main.object.input.MouseListener;
import at.main.object.manager.AirportKey;
import at.main.object.manager.Console;
import at.main.object.manager.GraphicsManager;
import at.main.object.manager.Tab;
import ie.main.input.at.main.object.input.KetListener;
import scope.SideScrollBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends SideScrollBase {
    Console console = new Console(scopeEngine(),this);
    public Console getConsole() {return console;}

    KetListener ketListener = new KetListener(this,this);

    GraphicsManager gm = new GraphicsManager();

    View view = new View();
    public View getView() {return view;}

    MouseListener mouseListener = new MouseListener(this);

    Tab tab = new Tab();
    public Tab getTab() {return tab;}

    //변수
    final int profileId;
    int mouseX = 0;
    int mouseY = 0;
    //e.getX() - camera.getX() + VIRTUAL_X_SCREEN_CENTER,e.getY() - camera.getY() + VIRTUAL_Y_SCREEN_CENTER

    //공항
    public ArrayList<Airport> airports;
    Airport selectedAirport;


    @Override
    protected void update(double originalDeltaTime) {
        double dt = originalDeltaTime / (16.0 / 1000.0);
        getCamera().follow(view.getX(), view.getY(), 0.1);
        //mouseX = (int) (getMouseX() - (getCamera().getX() + 960));
        //mouseY = (int) (getMouseY() - (getCamera().getY() + 540));
        mouseX = (int) (getMouseX() + getCamera().getX() - 960);
        mouseY = (int) (getMouseY() + getCamera().getY() - 540);
        tab.update(dt);
    }

    @Override
    protected void init() {
        for (int i = 0; i < 20; i++) {
            addEntity(new DummyData());
        }
        airports = new ArrayList<>();
        airports.add(new Airport(AirportKey.Althara));
        airports.add(new Airport(AirportKey.Brastem));
        airports.add(new Airport(AirportKey.Caldoria));
        airports.add(new Airport(AirportKey.Eldridge));
        airports.add(new Airport(AirportKey.Fenwick));
        airports.add(new Airport(AirportKey.Korvella));
        airports.add(new Airport(AirportKey.Nivora));
        airports.add(new Airport(AirportKey.Zyphora));
        airports.add(new Airport(AirportKey.Montivar));
        airports.add(new Airport(AirportKey.Virello));
        for (Airport a : airports) {
            addEntity(a);
        }
        addEntity(view);
        this.addMouseListener(mouseListener);
        this.addMouseWheelListener(mouseListener);

        launch();
    }

    @Override
    protected void backGroundRender(Graphics g) {
        gm.backGroundRender(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    protected void render(Graphics g) {
        console.render(g);
        gm.renderMap(g,this);

        g.setColor(new Color(35,35,35));
        g.fillRect(-200,-200,4000,200);
        g.fillRect(-200,-200,200,4000);
        g.fillRect(-200,1080,4000,2000);
        g.fillRect(1920,-400,300,4000);

        tab.render(g);

    }

    public void click() {
        for (Airport air : airports) {
            air.selected = false;
            if (air.isClicked(mouseX,mouseY)) {
                air.selected = true;
                selectedAirport = air;
            }
        }
    }

    public void upScroll() {
        tab.upScroll();
    }

    public void downScroll() {
        tab.downScroll();
    }

    public Main(int profileId) {
        super("at",5000,3000);
        this.profileId = profileId;
    }

    public static void main(String[] args) {
        new Main(1);
    }
}