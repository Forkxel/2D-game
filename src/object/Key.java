package object;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Class for item key
 */
public class Key extends Item {

    public Key() {
        name = "key";
        collision = false;
    }

    /**
     * sets image based on the color of the key
     */
    @Override
    public void setImageBasedOnColor(){
        try {
            switch (color){
                case "red":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/key/red_key.png"));
                    break;
                case "blue":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/key/blue_key.png"));
                    break;
                case "green":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/key/green_key.png"));
                    break;
                case "yellow":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/key/key.png"));
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
