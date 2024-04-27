import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private final int tileSize = 16;
    private final int scaledTile = tileSize * 3;
    private final int columns = 16;
    private final int rows = 12;
    private final int screenWidth = scaledTile * columns; // 768 pixels
    private final int screenHeight = scaledTile * rows; // 576 pixels
    Thread thread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

    }
}
