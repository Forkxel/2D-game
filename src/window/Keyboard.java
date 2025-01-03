package window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class for finding inputs from keyboard
 */
public class Keyboard implements KeyListener {

    private boolean pressedW, pressedS, pressedA, pressedD, pressedUp, pressedDown, pressedLeft, pressedRight, pressedShift;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Method to find what key is pressed
     * @param e the event to be processed
     */
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
        if (e.getKeyCode()  == KeyEvent.VK_UP){
            pressedUp = true;
        }
        if (e.getKeyCode()  == KeyEvent.VK_DOWN){
            pressedDown = true;
        }
        if (e.getKeyCode()  == KeyEvent.VK_LEFT){
            pressedLeft = true;
        }
        if (e.getKeyCode()  == KeyEvent.VK_RIGHT){
            pressedRight = true;
        }
    }

    /**
     * Method to find what key was released
     * @param e the event to be processed
     */
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
        if (e.getKeyCode()  == KeyEvent.VK_UP){
            pressedUp = false;
        }
        if (e.getKeyCode()  == KeyEvent.VK_DOWN){
            pressedDown = false;
        }
        if (e.getKeyCode()  == KeyEvent.VK_LEFT){
            pressedLeft = false;
        }
        if (e.getKeyCode()  == KeyEvent.VK_RIGHT){
            pressedRight = false;
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

    public boolean isPressedUp() {
        return pressedUp;
    }

    public boolean isPressedDown() {
        return pressedDown;
    }

    public boolean isPressedLeft() {
        return pressedLeft;
    }

    public boolean isPressedRight() {
        return pressedRight;
    }
}
