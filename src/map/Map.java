package map;

import entity.Player;
import window.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Class for creating a map
 */
public class Map {

    private final Screen screen;
    private final ArrayList<Tile> tiles;
    private final int[][] map;

    /**
     * Constructor for Map class that is also used to load images
     * @param screen used for interacting with main game panel
     */
    public Map(Screen screen) {
        this.screen = screen;
        tiles = new ArrayList<>();
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        map = new int[50][50];

        try {
            tiles.get(0).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png")));
            tiles.get(0).setCollision(true);
            tiles.get(1).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png")));
            tiles.get(1).setCollision(false);
            tiles.get(2).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/bricks.png")));
            tiles.get(2).setCollision(true);
            tiles.get(3).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sand.png")));
            tiles.get(3).setCollision(false);
            tiles.get(4).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/tree.png")));
            tiles.get(4).setCollision(true);
            tiles.get(5).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/planks.png")));
            tiles.get(5).setCollision(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        load();
    }

    /**
     * Method for drawing tiles on the map
     * @param g2D Graphics2D for drawing
     */
    public void draw(Graphics2D g2D) {
        Player player = screen.getPlayer();
        int tileSize = screen.getScaledTile();
        int playerX = player.getX();
        int playerY = player.getY();
        int playerScreenX = player.getCurrentX();
        int playerScreenY = player.getCurrentY();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                int tileIndex = map[col][row];
                int worldX = col * tileSize;
                int worldY = row * tileSize;
                int relativeX = worldX - playerX + playerScreenX;
                int relativeY = worldY - playerY + playerScreenY;

                boolean isInViewVertically = false;
                boolean isInViewHorizontally = false;

                if (worldX + tileSize > playerX - playerScreenX && worldX - tileSize < playerX + playerScreenX){
                    isInViewHorizontally = true;
                }

                if (worldY + tileSize > playerY - playerScreenY && worldY - tileSize < playerY + playerScreenY){
                    isInViewVertically = true;
                }

                if (isInViewHorizontally && isInViewVertically) {
                    g2D.drawImage(tiles.get(tileIndex).getImage(), relativeX, relativeY, tileSize, tileSize, null);
                }
            }
        }
    }

    /**
     * Method for loading the map
     */
    public void load() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("map.txt");

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                int rows = 0;
                String line;

                while (rows < map.length && (line = reader.readLine()) != null) {
                    String[] numbers = line.split("\\s");
                    for (int i = 0; i < map.length; i++) {
                        if (i < numbers.length) {
                            map[i][rows] = Integer.parseInt(numbers[i]);
                        }
                    }
                    rows++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int[][] getMap() {
        return map;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
