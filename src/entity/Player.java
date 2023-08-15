package entity;

import Main.GamePanel;
import Main.KeyInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyInput keyI;

    public final int screenX;
    public final int screenY;
    public int keyAmount = 0;

    public Player(GamePanel gp, KeyInput keyI) {

        this.gp = gp;
        this.keyI = keyI;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    // set spawn speed and direction
    public void setDefaultValues() {
        worldX = gp.tileSize * 7;
        worldY = gp.tileSize * 4;
        speed = 4;
        direction = "down";
    }

    // load the player sprites
    public void getPlayerImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_2.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {

        if (keyI.upPressed == true || keyI.downPressed == true ||
                keyI.leftPressed == true || keyI.rightPressed == true){
            if(keyI.upPressed == true) {
                direction = "up";
            }
            else if(keyI.downPressed == true){
                direction = "down";
            }
            else if(keyI.leftPressed == true){
                direction = "left";
            }
            else if(keyI.rightPressed == true){
                direction = "right";
            }

            // collision check
            collisionOn = false;
            gp.cCheck.checkTile(this);
            int objIndex = gp.cCheck.checkObject(this, true);
            pickUpObject(objIndex);

            if(collisionOn == false) {

                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
        }

        }
    }
    public void pickUpObject(int i) {
        if(i != 999) {
            String objectName = gp.obj[i].name;
            switch (objectName) {
                case "Key":
                        gp.playSoundEffect(5);
                        keyAmount++;
                        gp.obj[i] = null;
                        gp.ui.showMessage("You got a key!");

                    break;
                case "Chest":
                    if(keyAmount > 0){
                        gp.obj[i] = null;
                        keyAmount--;
                    }
                    else{
                        gp.ui.showMessage("You need a key!");
                    }
                break;
            }
        }
    }
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
        case "up":
            if (spriteNum == 1){
                image = up1;
            }
            if (spriteNum == 2){
                image = up2;
            }
            break;
        case "down":
            if (spriteNum == 1){
                image = down1;
            }
            if (spriteNum == 2){
                image = down2;
            }
            break;
        case "left":
            if (spriteNum == 1){
                image = left1;
            }
            if (spriteNum == 2){
                image = left2;
            }
            break;
        case "right":
            if (spriteNum == 1){
                image = right1;
            }
            if (spriteNum == 2){
                image = right2;
            }
            break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
