package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Doors extends Item {

    public Doors() {
        name = "doors";
        collision = false;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/doors.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
