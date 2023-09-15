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
    private int spriteCounter = 0;
    private int spriteNum = 1;

    public ObjectManager(GamePanel gp) {

        this.gp = gp;

        // amount of different objects
        object = new StaticObject[58];
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

            object[31] = new StaticObject();
            object[31].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/1.png")));
            object[32] = new StaticObject();
            object[32].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/2.png")));
            object[33] = new StaticObject();
            object[33].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/3.png")));
            object[34] = new StaticObject();
            object[34].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/4.png")));
            object[35] = new StaticObject();
            object[35].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/5.png")));
            object[36] = new StaticObject();
            object[36].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/6.png")));
            object[37] = new StaticObject();
            object[37].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/7.png")));
            object[38] = new StaticObject();
            object[38].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/8.png")));
            object[39] = new StaticObject();
            object[39].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/9.png")));
            object[40] = new StaticObject();
            object[40].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/10.png")));
            object[41] = new StaticObject();
            object[41].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/11.png")));
            object[42] = new StaticObject();
            object[42].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Flower/12.png")));

            object[43] = new StaticObject();
            object[43].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Box1.png")));
            object[43].collision = true;
            object[44] = new StaticObject();
            object[44].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Box2.png")));
            object[44].collision = true;
            object[45] = new StaticObject();
            object[45].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Box3.png")));
            object[45].collision = true;
            object[46] = new StaticObject();
            object[46].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Box4.png")));
            object[46].collision = true;
            object[47] = new StaticObject();
            object[47].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Lamp1.png")));
            object[48] = new StaticObject();
            object[48].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Lamp2.png")));
            object[49] = new StaticObject();
            object[49].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Lamp3.png")));
            object[50] = new StaticObject();
            object[50].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Log1.png")));
            object[51] = new StaticObject();
            object[51].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Log2.png")));
            object[52] = new StaticObject();
            object[52].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Log3.png")));
            object[53] = new StaticObject();
            object[53].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Log4.png")));
            object[54] = new StaticObject();
            object[54].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Tree1.png")));
            object[54].collision = true;
            object[55] = new StaticObject();
            object[55].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Decor/Tree2.png")));
            object[55].collision = true;
            object[56] = new StaticObject();
            object[56].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Unlit/1.png")));
            object[57] = new StaticObject();
            object[57].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Lit/1.png")));
            object[57].collision = true;
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

    public void update(){
        spriteCounter++;
        if (spriteCounter > 8) {
            try {
                if (spriteNum == 1) {
                    spriteNum = 2;
                    object[56].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Unlit/2.png")));
                    object[57].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Lit/2.png")));
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                    object[56].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Unlit/3.png")));
                    object[57].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Lit/3.png")));
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                    object[56].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Unlit/4.png")));
                    object[57].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Lit/4.png")));
                } else if (spriteNum == 4) {
                    spriteNum = 5;
                    object[56].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Unlit/5.png")));
                    object[57].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Lit/5.png")));
                } else if (spriteNum == 5) {
                    spriteNum = 6;
                    object[56].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Unlit/6.png")));
                    object[57].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Lit/6.png")));
                } else if (spriteNum == 6) {
                    spriteNum = 1;
                    object[56].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Unlit/1.png")));
                    object[57].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/AnimatedObjects/Campfire/Lit/1.png")));
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            spriteCounter = 0;
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

            if (worldX + (gp.tileSize * 3) > gp.player.worldX - gp.player.screenX &&
                    worldX - (gp.tileSize * 3) < gp.player.worldX + gp.player.screenX &&
                    worldY + (gp.tileSize * 3) > gp.player.worldY - gp.player.screenY &&
                    worldY - (gp.tileSize * 3) < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(object[tileNum].image, screenX, screenY - object[tileNum].image.getHeight(), object[tileNum].image.getWidth() * 2, object[tileNum].image.getHeight() * 2, null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldSize) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
