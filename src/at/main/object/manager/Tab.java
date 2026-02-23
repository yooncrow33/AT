package at.main.object.manager;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class Tab {

    public int x = 0;


    public enum State {
        store(200),
        aircraft(200),
        setting(200);

        private int scrollMax;
        private int scroll = 0;

        State(int scrollMax) {
            this.scrollMax = scrollMax;
        }

        public void upScroll() {
            if (scrollMax <= scroll) return;
            scroll ++;
        }

        public void downScroll() {
            if (scroll <= 0) return;
            scroll --;
        }

        public int getScroll() {
            return scroll;
        }
    }

    State state = State.store;

    ArrayList<String> aircraftTypes = new ArrayList<>();

    public Tab() {
        aircraftTypes.add("737");
        aircraftTypes.add("320");
        aircraftTypes.add("777");
        aircraftTypes.add("380");
    }

    public void setTabState(State state) {
        this.state = state;
    }

    public void renderStore(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int storeWidth = 400;
        int yOffset = 50;

        // 배경
        g2.setColor(new Color(30, 30, 30));
        g2.fillRect(x, 0, storeWidth, 1080);

        g2.setFont(new Font("Arial", Font.BOLD, 22));

        // 항공기 구매 버튼
        for (int i = 0; i < aircraftTypes.size(); i++) {
            int yPos = yOffset + 100 + i * 120 - state.getScroll();

            // 그림자
            RoundRectangle2D shadow = new RoundRectangle2D.Double(x + 22, yPos + 4, storeWidth - 44, 80, 20, 20);
            g2.setColor(new Color(0,0,0,100));
            g2.fill(shadow);

            // 버튼 그라데이션
            GradientPaint gp = new GradientPaint(x + 20, yPos, new Color(70,70,70),
                    x + 20, yPos + 80, new Color(90,90,90));
            g2.setPaint(gp);
            RoundRectangle2D button = new RoundRectangle2D.Double(x + 20, yPos, storeWidth - 40, 80, 20, 20);
            g2.fill(button);

            // 테두리
            g2.setColor(new Color(140,140,140));
            g2.draw(button);

            // 텍스트 중앙
            String text = "Buy " + aircraftTypes.get(i);
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getAscent();
            g2.setColor(Color.WHITE);
            g2.drawString(text, x + (storeWidth - textWidth)/2, yPos + (80 + textHeight)/2 - 4);
        }

        // 대출/업그레이드 버튼
        String[] actions = {"대출", "업그레이드", "기타"};
        for (int i = 0; i < actions.length; i++) {
            int yPos = yOffset + 100 + aircraftTypes.size() * 120 + i * 70 - state.getScroll();

            // 그림자
            RoundRectangle2D shadow = new RoundRectangle2D.Double(x + 22, yPos + 4, storeWidth - 44, 50, 15, 15);
            g2.setColor(new Color(0,0,0,100));
            g2.fill(shadow);

            // 버튼 그라데이션
            GradientPaint gp = new GradientPaint(x + 20, yPos, new Color(90,90,90),
                    x + 20, yPos + 50, new Color(110,110,110));
            g2.setPaint(gp);
            RoundRectangle2D button = new RoundRectangle2D.Double(x + 20, yPos, storeWidth - 40, 50, 15, 15);
            g2.fill(button);

            // 테두리
            g2.setColor(new Color(160,160,160));
            g2.draw(button);

            // 텍스트 중앙
            String text = actions[i];
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getAscent();
            g2.setColor(Color.WHITE);
            g2.drawString(text, x + (storeWidth - textWidth)/2, yPos + (50 + textHeight)/2 - 4);
        }
    }

    public void update(double dt) {

    }

    public void upScroll() {
        state.upScroll();
    }

    public void downScroll() {
        state.downScroll();
    }

    public void render(Graphics g) {
        g.setColor(new Color(35,35,35));
        g.fillRect(x + 0,0,400,1080);
        g.setColor(new Color(230,230,230));
        g.setFont(new Font("Impact", Font.BOLD, 56));
        g.drawString("Tab", x + 10,70);
        g.setColor(new Color(40,40,40));
        g.fillRect(x + 0,1000,400,80);
        int raw = 400/3;
        switch (state) {
            case store :
                renderStore(g);
                g.setColor(new Color(220,220,220));
                g.fillRect(x + 0, 1000,raw,80);
                break;
            case aircraft:

                g.setColor(new Color(220,220,220));
                g.fillRect(x + 0 + raw, 1000,raw,80);
                break;
            case setting:

                g.setColor(new Color(220,220,220));
                g.fillRect(x + 0 + raw + raw, 1000,raw,80);
                break;
        }

    }
}
