import window.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        BufferedImage image;
        try {
            image = ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("player/neutral.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        frame.setIconImage(image);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.startThread();
        gamePanel.run();
    }
}