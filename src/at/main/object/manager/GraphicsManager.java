package at.main.object.manager;

import at.main.Main;
import at.main.object.entity.View;
import at.main.object.entity.game.Airport;

import java.awt.*;

public class GraphicsManager {
    public void backGroundRender(Graphics g) {
        g.setColor(new Color(190,190,190));
        g.fillRect(-5000,-50000,4000000,4000000);
    }

    public void renderMap(Graphics g, Main main) {
        final int MAP_SCALE = 30;

        final int MINIMAP_X_START = 10;
        final int MINIMAP_Y_START = 10;
        final int MINIMAP_WIDTH = 5000 / MAP_SCALE;
        final int MINIMAP_HEIGHT = 3000 / MAP_SCALE;
        final int CAMERA_WIDTH = 1920 / MAP_SCALE;
        final int CAMERA_HEIGHT = 1080 / MAP_SCALE;

        // 미니맵 배경
        g.setColor(Color.black);
        g.fillRect(MINIMAP_X_START - 5, MINIMAP_Y_START - 5, MINIMAP_WIDTH + 10, MINIMAP_HEIGHT + 10);
        g.setColor(Color.white);
        g.fillRect(MINIMAP_X_START, MINIMAP_Y_START, MINIMAP_WIDTH, MINIMAP_HEIGHT);

        // 플레이어 좌표 계산
        // 1. 월드 좌표를 미니맵 크기로 변환
        double scaledX = main.getView().getX() / MAP_SCALE;
        double scaledY = main.getView().getY() / MAP_SCALE;

        // 2. 미니맵의 중앙을 기준으로 현재 위치를 계산 (중앙 오프셋)
        int mapCenterX = MINIMAP_WIDTH / 2;
        int mapCenterY = MINIMAP_HEIGHT / 2;
        int playerMapX = MINIMAP_X_START + mapCenterX + (int)scaledX;
        int playerMapY = MINIMAP_Y_START + mapCenterY + (int)scaledY;

        for (Airport a : main.airports) {
            double scaledX2 = a.getX() / MAP_SCALE;
            double scaledY2 = a.getY() / MAP_SCALE;

            int x = MINIMAP_X_START + mapCenterX + (int)scaledX2;
            int y = MINIMAP_Y_START + mapCenterY + (int)scaledY2;

            // 플레이어 표시
            g.setColor(new Color(240,140,30));
            g.fillRect(x - 3, y - 3, 6, 6);
        }

        // 플레이어 표시
        g.setColor(new Color(140,140,140,170));
        g.fillRect(playerMapX - CAMERA_WIDTH/2, playerMapY - CAMERA_HEIGHT/2, CAMERA_WIDTH,CAMERA_HEIGHT);
    }
}
