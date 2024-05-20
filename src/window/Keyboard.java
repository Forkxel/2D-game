package window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean pressedW, pressedS, pressedA, pressedD, pressedShift;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()  == KeyEvent.VK_W){
            pressedW = true;
        }
        if (e.getKeyCode()  == KeyEvent.VK_S){
            pressedS = true;
        }
        if (e.getKeyCode()  == KeyEvent.VK_A){
            pressedA = true;
        }
        if (e.getKeyCode()  == KeyEvent.VK_D){
            pressedD = true;
        }
        if (e.getKeyCode()  == KeyEvent.VK_SHIFT){
            pressedShift = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            pressedW = false;
        }
        if (e.getKeyCode()  == KeyEvent.VK_S){
            pressedS = false;
        }
        if (e.getKeyCode()  == KeyEvent.VK_A){
            pressedA = false;
        }
        if (e.getKeyCode()  == KeyEvent.VK_D){
            pressedD = false;
        }
        if (e.getKeyCode()  == KeyEvent.VK_SHIFT){
            pressedShift = false;
        }
    }

    public boolean isPressedW() {
        return pressedW;
    }

    public boolean isPressedS() {
        return pressedS;
    }

    public boolean isPressedA() {
        return pressedA;
    }

    public boolean isPressedD() {
        return pressedD;
    }

    public boolean isPressedShift() {
        return pressedShift;
    }
}
