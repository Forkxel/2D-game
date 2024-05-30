package window;

import entity.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {

    private final Screen screen;
    private final BufferedImage heart;
    private final BufferedImage emptyHeart;

    public UI(Screen screen) {
        this.screen = screen;

        try {
            emptyHeart = ImageIO.read(getClass().getClassLoader().getResourceAsStream("heart/empty_heart.png"));
            heart = ImageIO.read(getClass().getClassLoader().getResourceAsStream("heart/heart.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawWin(Graphics2D g2D) {
        String text = "You won!";
        String text2 = "You found the treasure!";

        g2D.setFont(new Font("Montserrat", Font.PLAIN, 40));

        int length = (int) g2D.getFontMetrics().getStringBounds(text, g2D).getWidth();
        int length2 = (int) g2D.getFontMetrics().getStringBounds(text2, g2D).getWidth();

        g2D.setColor(Color.BLACK);
        g2D.fillRect(0, 0, screen.getScreenWidth(), screen.getScreenHeight());

        g2D.setColor(Color.YELLOW);
        g2D.drawString(text, screen.getScreenWidth() / 2 - length / 2, screen.getScreenHeight() / 2 - screen.getScaledTile());
        g2D.drawString(text2, screen.getScreenWidth() / 2 - length2 / 2, screen.getScreenHeight() / 2);

        screen.setThread(null);
    }

    public void drawLose(Graphics2D g2D) {
        String text = "You died";

        g2D.setFont(new Font("Montserrat", Font.PLAIN, 40));

        int length = (int) g2D.getFontMetrics().getStringBounds(text, g2D).getWidth();

        g2D.setColor(Color.BLACK);
        g2D.fillRect(0, 0, screen.getScreenWidth(), screen.getScreenHeight());

        g2D.setColor(Color.RED);
        g2D.drawString(text, screen.getScreenWidth() / 2 - length / 2, screen.getScreenHeight() / 2);

        screen.setThread(null);
    }

    public void drawHearts(Graphics2D g2D, Player player) {
        int x = screen.getScaledTile()/2;
        int y = screen.getScaledTile()/2;
        for (int i = 0; i < player.getLife();i++){
            g2D.drawImage(heart, x, y,16*3,16*3, null);
            x += screen.getScaledTile();
        }
        if (player.getMaxLife() != player.getLife()){
            for (int i = 0; i < player.getHit();i++){
                g2D.drawImage(emptyHeart, x, y,16*3,16*3, null);
                x += screen.getScaledTile();
            }
        }
    }
}
