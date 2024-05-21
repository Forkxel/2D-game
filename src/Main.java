import window.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        BufferedImage image;
        try {
            image = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("player/neutral_down.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        frame.setIconImage(image);
        frame.setTitle("Monsters everywhere");

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.setUpObjects();
        Thread thread = new Thread(gamePanel);
        thread.start();
    }
}