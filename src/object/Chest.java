package object;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Class for chest object
 */
public class Chest extends Item {

    public Chest() {
        name = "chest";
        collision = true;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/chest.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void setImageBasedOnColor() {
    }
}
