package map;

import entity.Player;
import window.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Map {

    private final Screen screen;
    private final ArrayList<Tile> tiles;
    private int[][] map;

    public Map(Screen screen) {
        this.screen = screen;
        tiles = new ArrayList<>();
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        map = new int[screen.getMapColumns()][screen.getMapRows()];

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

    public void draw(Graphics2D g2D) {
        Player player = screen.getPlayer();
        int tileSize = screen.getScaledTile();
        int playerX = player.getX();
        int playerY = player.getY();
        int playerScreenX = player.getCurrentX();
        int playerScreenY = player.getCurrentY();

        for (int row = 0; row < screen.getMapRows(); row++) {
            for (int col = 0; col < screen.getMapColumns(); col++) {
                int tileIndex = map[col][row];
                int worldX = col * tileSize;
                int worldY = row * tileSize;
                int relativeX = worldX - playerX + playerScreenX;
                int relativeY = worldY - playerY + playerScreenY;

                boolean isInViewHorizontally = false;
                if (worldX + tileSize > playerX - playerScreenX && worldX - tileSize < playerX + playerScreenX){
                    isInViewHorizontally = true;
                }

                boolean isInViewVertically = false;
                if (worldY + tileSize > playerY - playerScreenY && worldY - tileSize < playerY + playerScreenY){
                    isInViewVertically = true;
                }

                if (isInViewHorizontally && isInViewVertically) {
                    g2D.drawImage(tiles.get(tileIndex).getImage(), relativeX, relativeY, tileSize, tileSize, null);
                }
            }
        }
    }

    public void load(){
        int columns = 0;
        int rows = 0;
        BufferedReader reader = null;
        String line = "";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("map.txt");

        try {
            if (inputStream != null) {
                reader = new BufferedReader(new InputStreamReader(inputStream));
            }
            while(columns < screen.getMapColumns() && rows < screen.getMapRows()){
                if (reader != null) {
                    line = reader.readLine();
                }
                while (columns < screen.getMapColumns()){
                    String[] numbers = line.split("\\s");
                    map[columns][rows] = Integer.parseInt(numbers[columns]);
                    columns++;
                }
                if (columns == screen.getMapColumns()){
                    columns = 0;
                    rows++;
                }
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int[][] getMap() {
        return map;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
