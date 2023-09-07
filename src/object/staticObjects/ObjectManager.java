package object.staticObjects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ObjectManager {

    GamePanel gp;
    public Object[] object;
    public int[][] mapObjectNum;

    public ObjectManager(GamePanel gp) {

        this.gp = gp;

        // amount of different objects
        object = new Object[7];
        mapObjectNum = new int [gp.maxWorldSize][gp.maxWorldSize];

        getTileImage();
    }

    public void getTileImage() {

        try{

            object[0] = new Object();
            object[0].image = ImageIO.read(getClass().getResourceAsStream("/Objects/blank.png"));
            // grass
            object[1] = new Object();
            object[1].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Grass/1.png"));
            object[2] = new Object();
            object[2].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Grass/2.png"));
            object[3] = new Object();
            object[3].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Grass/3.png"));
            object[4] = new Object();
            object[4].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Grass/4.png"));
            object[5] = new Object();
            object[5].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Grass/5.png"));
            object[6] = new Object();
            object[6].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Grass/6.png"));


        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String mapPath) {

        try {
            InputStream is = getClass().getResourceAsStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldSize && row < gp.maxWorldSize) {

                String line = br.readLine();

                while (col < gp.maxWorldSize) {

                    String numbers[] = line.split(" ");

                    // convert to int
                    int num = Integer.parseInt(numbers[col]);

                    mapObjectNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldSize) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < gp.maxWorldSize && worldRow < gp.maxWorldSize) {

            int tileNum = mapObjectNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(object[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldSize) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
