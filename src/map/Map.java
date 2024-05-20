package map;

import window.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Map {

    private final GamePanel gamePanel;
    private final ArrayList<Tile> tiles;
    private int[][] map;

    public Map(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tiles = new ArrayList<>();
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        tiles.add(new Tile());
        map = new int[gamePanel.getMapColumns()][gamePanel.getMapRows()];

        try {
            tiles.get(0).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png")));
            tiles.get(0).setCollision(true);
            tiles.get(1).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png")));
            tiles.get(2).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/bricks.png")));
            tiles.get(2).setCollision(true);
            tiles.get(3).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sand.png")));
            tiles.get(4).setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/tree.png")));
            tiles.get(4).setCollision(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        load();
    }

    public void draw(Graphics2D g2D) {
        for (int row = 0; row < gamePanel.getMapRows(); row++) {
            for (int col = 0; col < gamePanel.getMapColumns(); col++) {
                int tileIndex = map[col][row];
                int worldX = col * gamePanel.getScaledTile();
                int worldY = row * gamePanel.getScaledTile();
                int currentX = worldX - gamePanel.getPlayer().getX() + gamePanel.getPlayer().getCurrentX();
                int currentY = worldY - gamePanel.getPlayer().getY() + gamePanel.getPlayer().getCurrentY();
                if (worldX - gamePanel.getScaledTile() < gamePanel.getPlayer().getX() + gamePanel.getPlayer().getCurrentX() && worldY - gamePanel.getScaledTile() < gamePanel.getPlayer().getY() + gamePanel.getPlayer().getCurrentY() &&
                    worldY + gamePanel.getScaledTile() > gamePanel.getPlayer().getY() - gamePanel.getPlayer().getCurrentY() && worldX + gamePanel.getScaledTile() > gamePanel.getPlayer().getX() - gamePanel.getPlayer().getCurrentX()) {
                    g2D.drawImage(tiles.get(tileIndex).getImage(), currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
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
            while(columns < gamePanel.getMapColumns() && rows < gamePanel.getMapRows()){
                if (reader != null) {
                    line = reader.readLine();
                }
                while (columns < gamePanel.getMapColumns()){
                    String[] numbers = line.split("\\s");
                    map[columns][rows] = Integer.parseInt(numbers[columns]);
                    columns++;
                }
                if (columns == gamePanel.getMapColumns()){
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
