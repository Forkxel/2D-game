package object;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Class for doors
 */
public class Doors extends Item {

    public Doors() {
        name = "doors";
        collision = true;
    }

    /**
     * sets image based on the color of the doors
     */
    @Override
    protected void setImageBasedOnColor() {
        try {
            switch (color){
                case "red":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/doors/red_doors.png"));
                    break;
                case "blue":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/doors/blue_doors.png"));
                    break;
                case "green":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/doors/green_doors.png"));
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
