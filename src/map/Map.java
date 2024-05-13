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
    private int[][] map;

    public Map(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tiles = new ArrayList<>();
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        map = new int[gamePanel.columns][gamePanel.rows];

        try {
            tiles.get(0).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));
            tiles.get(1).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));
            tiles.get(2).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/bricks.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        load();
    }

    public void draw(Graphics2D g2D){
        int columns = 0;
        int rows = 0;
        int x = 0;
        int y = 0;

        while (columns < gamePanel.columns && rows < gamePanel.rows){
            int a = map[columns][rows];
            g2D.drawImage(tiles.get(a).image, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
            columns++;
            x += gamePanel.scaledTile;
            if (columns == gamePanel.columns){
                columns = 0;
                rows++;
                x = 0;
                y += gamePanel.scaledTile;
            }
        }
    }

    public void load (){
        int columns = 0;
        int rows = 0;
        BufferedReader reader;
        String line;

        try {
            reader = new BufferedReader(new FileReader("game/map.txt"));
            while(columns < gamePanel.columns && rows < gamePanel.rows){
                line = reader.readLine();
                while (columns < gamePanel.columns){
                    String[] numbers = line.split("\\s");
                    map[columns][rows] = Integer.parseInt(numbers[columns]);
                    columns++;
                }
                if (columns == gamePanel.columns){
                    columns = 0;
                    rows++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
