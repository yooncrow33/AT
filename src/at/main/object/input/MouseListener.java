package at.main.object.input;

import at.main.Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseListener extends MouseAdapter implements MouseWheelListener {

    Main main;

    public MouseListener(Main main) {
        this.main = main;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation(); // 음수: 위로, 양수: 아래로
        if (notches < 0) {
          //  System.out.println("스크롤 위로!");
            main.upScroll();
        } else {
         //   System.out.println("스크롤 아래로!");
            main.downScroll();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        main.click();
    }
}
