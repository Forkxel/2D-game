package window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    public boolean pressedW, pressedS, pressedA, pressedD, pressedShift;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            pressedW = true;
        }
        if (code == KeyEvent.VK_S){
            pressedS = true;
        }
        if (code == KeyEvent.VK_A){
            pressedA = true;
        }
        if (code == KeyEvent.VK_D){
            pressedD = true;
        }
        if (code == KeyEvent.VK_SHIFT){
            pressedShift = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            pressedW = false;
        }
        if (code == KeyEvent.VK_S){
            pressedS = false;
        }
        if (code == KeyEvent.VK_A){
            pressedA = false;
        }
        if (code == KeyEvent.VK_D){
            pressedD = false;
        }
        if (code == KeyEvent.VK_SHIFT){
            pressedShift = false;
        }
    }
}
