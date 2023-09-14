package object.staticObjects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class ObjectManager {

    GamePanel gp;
    public StaticObject[] object;
    public int[][] mapObjectNum;

    public ObjectManager(GamePanel gp) {

        this.gp = gp;

        // amount of different objects
        object = new StaticObject[31];
        mapObjectNum = new int [gp.maxWorldSize][gp.maxWorldSize];

        getTileImage();
    }

    public void getTileImage() {

        try{

            object[0] = new StaticObject();
            object[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/blank.png")));
            // grass
            object[1] = new StaticObject();
            object[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Grass/1.png")));
            object[2] = new StaticObject();
            object[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Grass/2.png")));
            object[3] = new StaticObject();
            object[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Grass/3.png")));
            object[4] = new StaticObject();
            object[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Grass/4.png")));
            object[5] = new StaticObject();
            object[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Grass/5.png")));
            object[6] = new StaticObject();
            object[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Grass/6.png")));
            // bush
            object[7] = new StaticObject();
            object[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Bush/1.png")));
            object[8] = new StaticObject();
            object[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Bush/2.png")));
            object[9] = new StaticObject();
            object[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Bush/3.png")));
            object[10] = new StaticObject();
            object[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Bush/4.png")));
            object[11] = new StaticObject();
            object[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Bush/5.png")));
            object[12] = new StaticObject();
            object[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Bush/6.png")));
            //camp
            object[13] = new StaticObject();
            object[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Camp/1.png")));
            object[14] = new StaticObject();
            object[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Camp/2.png")));

            object[15] = new StaticObject();
            object[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/1.png")));
            object[16] = new StaticObject();
            object[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/2.png")));
            object[17] = new StaticObject();
            object[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/3.png")));
            object[18] = new StaticObject();
            object[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/4.png")));
            object[19] = new StaticObject();
            object[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/5.png")));
            object[20] = new StaticObject();
            object[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/6.png")));
            object[21] = new StaticObject();
            object[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/7.png")));
            object[21].collision = true;
            object[22] = new StaticObject();
            object[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/8.png")));
            object[22].collision = true;
            object[23] = new StaticObject();
            object[23].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/9.png")));
            object[23].collision = true;
            object[24] = new StaticObject();
            object[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/10.png")));
            object[24].collision = true;
            object[25] = new StaticObject();
            object[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/11.png")));
            object[25].collision = true;
            object[26] = new StaticObject();
            object[26].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/12.png")));
            object[26].collision = true;
            object[27] = new StaticObject();
            object[27].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/13.png")));
            object[28] = new StaticObject();
            object[28].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/14.png")));
            object[29] = new StaticObject();
            object[29].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/15.png")));
            object[30] = new StaticObject();
            object[30].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Stone/16.png")));
            object[30].collision = true;
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String mapPath) {

        try {
            InputStream is = getClass().getResourceAsStream(mapPath);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldSize && row < gp.maxWorldSize) {

                String line = br.readLine();

                while (col < gp.maxWorldSize) {

                    String[] numbers = line.split(" ");

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

        } catch (Exception ignored) {}
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

            if (worldX + (gp.tileSize * 2) > gp.player.worldX - gp.player.screenX &&
                    worldX - (gp.tileSize * 2) < gp.player.worldX + gp.player.screenX &&
                    worldY + (gp.tileSize * 2) > gp.player.worldY - gp.player.screenY &&
                    worldY - (gp.tileSize * 2) < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(object[tileNum].image, screenX, screenY, object[tileNum].image.getWidth() * 2, object[tileNum].image.getHeight() * 2, null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldSize) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
