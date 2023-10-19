package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Entity {

    public int worldX, worldY;
    public int speed;
    public int maxHealth, currentHealth;

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

//    public Vector<Integer> findVector (){
//
//    }
}
