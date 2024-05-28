package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Potion extends Item{

    public Potion() {
        name = "potion";
        collision = false;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("items/potion.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void setImageBasedOnColor(){
    }
}
