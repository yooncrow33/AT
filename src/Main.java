import scope.SideScrollBase;

public class Main extends SideScrollBase {
    @Override
    protected void update(double v) {

    }

    @Override
    protected void init() {

    }

    public Main() {
        super("at", 5000,5000);
    }

    public static void main(String[] args) {
        new Main();
    }
}