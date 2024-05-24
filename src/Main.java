import window.Screen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        BufferedImage image;
        try {
            image = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("player/neutral_down.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        frame.setIconImage(image);
        frame.setTitle("Very long title for game where you currently do nothing");

        Screen screen = new Screen();
        frame.add(screen);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Thread thread = new Thread(screen);
        thread.start();
    }
}