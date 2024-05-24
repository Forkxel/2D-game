package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Key extends Item {

    public Key() {
        name = "key";
        collision = false;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
