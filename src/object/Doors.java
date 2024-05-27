package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Doors extends Item {

    public Doors() {
        name = "doors";
        collision = true;
    }

    @Override
    protected void setImageBasedOnColor() {
        try {
            switch (color){
                case "red":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/doors/red_doors.png"));
                    break;
                case "blue":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/doors/blue_doors.png"));
                    break;
                case "green":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/doors/green_doors.png"));
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
