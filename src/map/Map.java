package map;

import window.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    private GamePanel gamePanel;
    private ArrayList<Tile> tiles;
    private Tile[][] map = new Tile[16][12];

    public Map(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tiles = new ArrayList<>();
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());

        try {
            tiles.get(0).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));
            tiles.get(1).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));
            tiles.get(2).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/bricks.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2D){
        int columns = 0;
        int rows = 0;
        int x = 0;
        int y = 0;

        BufferedReader reader;
        try {
            String line;
            reader = new BufferedReader(new FileReader("game/map.txt"));
            while((line = reader.readLine()) != null){
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        while (columns < gamePanel.screenHeight && rows < gamePanel.screenWidth){
            g2D.drawImage(tiles.get(1).image, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
            columns++;
            x += gamePanel.scaledTile;
            if (columns == gamePanel.screenHeight){
                columns = 0;
                rows++;
                x = 0;
                y += gamePanel.scaledTile;
            }
        }
    }
}
