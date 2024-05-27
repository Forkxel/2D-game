package window;

import java.awt.*;

public class WinningMessage {

    private final Screen screen;

    public WinningMessage(Screen screen) {
        this.screen = screen;
    }

    public void draw(Graphics2D g2D) {
        String text = "You won!";
        String text2 = "You found the treasure!";

        g2D.setFont(new Font("Montserrat", Font.PLAIN, 40));

        int length = (int) g2D.getFontMetrics().getStringBounds(text, g2D).getWidth();
        int length2 = (int) g2D.getFontMetrics().getStringBounds(text2, g2D).getWidth();

        g2D.setColor(Color.WHITE);
        g2D.drawString(text, screen.getScreenWidth() / 2 - length / 2, screen.getScreenHeight() / 2 - screen.getScaledTile());
        g2D.drawString(text2, screen.getScreenWidth() / 2 - length2 / 2, screen.getScreenHeight() / 2);

        screen.setThread(null);
    }
}
