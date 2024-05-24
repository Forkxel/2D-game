package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest extends Item {

    public Chest() {
        name = "chest";
        collision = true;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/chest.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
