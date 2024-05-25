package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Key extends Item {

    public Key() {
        name = "key";
        collision = false;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key/key.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setImageBasedOnColor(){
        try {
            switch (color){
                case "red":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key/red_key.png"));
                    break;
                case "blue":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key/blue_key.png"));
                    break;
                case "green":
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key/green_key.png"));
                    break;
                default:
                    image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key/yellow_key.png"));
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
