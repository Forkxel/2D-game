package window;

import entity.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class for drawing on the panel
 */
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

    /**
     * Method that draw winning message on the panel
     * @param g2D Graphics2D for drawing
     */
    public void drawWin(Graphics2D g2D) {
        String text = "You won!";
        String text2 = "You found the treasure!";

        Font font = new Font("Montserrat", Font.PLAIN, 40);
        g2D.setFont(font);

        TextLayout layout1 = new TextLayout(text, font, g2D.getFontRenderContext());
        TextLayout layout2 = new TextLayout(text2, font, g2D.getFontRenderContext());

        Rectangle2D bounds1 = layout1.getBounds();
        Rectangle2D bounds2 = layout2.getBounds();

        int x1 = (screen.getScreenWidth() - (int) bounds1.getWidth()) / 2;
        int x2 = (screen.getScreenWidth() - (int) bounds2.getWidth()) / 2;
        int y1 = screen.getScreenHeight() / 2 - screen.getScaledTile();
        int y2 = screen.getScreenHeight() / 2;

        g2D.setColor(Color.BLACK);
        g2D.fillRect(0, 0, screen.getScreenWidth(), screen.getScreenHeight());

        g2D.setColor(Color.YELLOW);
        layout1.draw(g2D, x1, y1);
        layout2.draw(g2D, x2, y2);

        screen.setThread(null);
    }

    /**
     * Method that draw loosing message on the panel
     * @param g2D Graphics2D for drawing
     */
    public void drawLose(Graphics2D g2D) {
        String text = "You died";

        Font font = new Font("Montserrat", Font.PLAIN, 40);
        g2D.setFont(font);

        TextLayout layout = new TextLayout(text, font, g2D.getFontRenderContext());

        Rectangle2D bounds = layout.getBounds();

        int x = (screen.getScreenWidth() - (int) bounds.getWidth()) / 2;
        int y = screen.getScreenHeight() / 2;

        g2D.setColor(Color.BLACK);
        g2D.fillRect(0, 0, screen.getScreenWidth(), screen.getScreenHeight());

        g2D.setColor(Color.RED);
        layout.draw(g2D, x, y);

        screen.setThread(null);
    }

    /**
     * Method that is drawing player lives on the panel
     * @param g2D Graphics2D for drawing
     * @param player player
     */
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
