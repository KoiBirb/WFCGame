package entity;

import Main.GamePanel;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Vector;

public class Entity {

    GamePanel gp;

    public int worldX, worldY;
    public double speed;
    public double baseSpeed;
    public int maxHealth, currentHealth;
    public String name;

    public BufferedImage up1, up2, up3, up4, up5, up6,
            down1, down2, down3, down4, down5, down6,
            left1, left2, left3, left4, left5, left6,
            right1, right2, right3, right4, right5, right6;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public int actionLockCounter = 0;

    public Entity (GamePanel gp){
        this.gp = gp;
    }
    public void setAction() {}

    public void update() {

        setAction();

        collisionOn = false;
        gp.cCheck.checkTile(this);

        if (!collisionOn) {

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
        if (spriteCounter > 8) {
            if (spriteNum == 1) {
                spriteNum = 2;
                speed = baseSpeed * 0.2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
                speed = baseSpeed * 2;
            } else if (spriteNum == 3) {
                spriteNum = 4;
                speed = baseSpeed;
            } else if (spriteNum == 4) {
                spriteNum = 5;
            } else if (spriteNum == 5) {
                spriteNum = 6;
                speed = baseSpeed * 0.5;
            } else if (spriteNum == 6) {
                spriteNum = 1;
                speed = baseSpeed * 1.2;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2, GamePanel gp) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up4;
                }
                if (spriteNum == 5) {
                    image = up5;
                }
                if (spriteNum == 6) {
                    image = up6;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down4;
                }
                if (spriteNum == 5) {
                    image = down5;
                }
                if (spriteNum == 6) {
                    image = down6;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                if (spriteNum == 4) {
                    image = left4;
                }
                if (spriteNum == 5) {
                    image = left5;
                }
                if (spriteNum == 6) {
                    image = left6;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                if (spriteNum == 4) {
                    image = right4;
                }
                if (spriteNum == 5) {
                    image = right5;
                }
                if (spriteNum == 6) {
                    image = right6;
                }
                break;
        }

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            g2.drawImage(image, screenX, screenY, gp.tileSize * gp.scale, gp.tileSize * gp.scale, null);
        }
    }
}
