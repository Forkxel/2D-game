import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private final int tileSize = 16;
    private final int scaledTile = tileSize * 3;
    private final int columns = 16;
    private final int rows = 12;
    private final int screenWidth = scaledTile * columns; // 768 pixels
    private final int screenHeight = scaledTile * rows; // 576 pixels
    private Keyboard keyboard = new Keyboard();
    private Thread thread;
    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 4;
    private int fps = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.setFocusable(true);
    }

    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (thread != null) {

            update();

            repaint();
        }
    }

    public void update(){
        if (keyboard.pressedW){
            playerY -= playerSpeed;
        } else if (keyboard.pressedS){
            playerY += playerSpeed;
        } else if (keyboard.pressedA){
            playerX -= playerSpeed;
        } else if (keyboard.pressedD){
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.white);
        g2D.fillRect(playerX,playerY,scaledTile,scaledTile);
        g2D.dispose();
    }
}
