package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Slime extends Entity{

    GamePanel gp;

    public Slime(GamePanel gp, int X, int Y) {

        this.gp = gp;

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        worldX = X;
        worldY = Y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        maxHealth = 50;
        speed = 3;
        direction = "up";
        currentHealth = maxHealth;
    }

    public void getPlayerImage(){

        try{
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up2.png")));
            up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up3.png")));
            up4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up4.png")));
            up5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up5.png")));
            up6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up6.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up2.png")));
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up3.png")));
            down4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up4.png")));
            down5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up5.png")));
            down6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up6.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up2.png")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up3.png")));
            left4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up4.png")));
            left5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up5.png")));
            left6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up6.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up2.png")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up3.png")));
            right4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up4.png")));
            right5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up5.png")));
            right6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/up6.png")));

//            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/down1.png")));
//            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/down2.png")));
//            down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/down3.png")));
//            down4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/down4.png")));
//            down5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/down5.png")));
//            down6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/down6.png")));
//            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/left1.png")));
//            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/left2.png")));
//            left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/left3.png")));
//            left4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/left4.png")));
//            left5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/left5.png")));
//            left6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/left6.png")));
//            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/right1.png")));
//            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/right2.png")));
//            right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/right3.png")));
//            right4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/right4.png")));
//            right5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/right5.png")));
//            right6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemy/Slime/Walk/right6.png")));

        }catch(IOException e) {
            e.printStackTrace();
        }
   }

   public double findAngle(){
        double run = gp.player.worldX - worldX ;
        double rise = worldY - gp.player.worldY;
        int initialAngle = 0;

        if (run > 0 && rise < 0){
            initialAngle = 90;
        } else if(run < 0 && rise < 0){
            initialAngle = 180;
        } else if (run < 0 && rise > 0) {
            initialAngle = 270;
        }
       System.out.println("run: " + run + " " + "rise" + rise);

       System.out.println(initialAngle);

        double slope = run / rise;
        return (int) ((Math.tanh(slope) * 100) + initialAngle);
   }

    public void update(){
        System.out.println(findAngle());
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
                if (spriteNum == 3){
                    image = up3;
                }
                if (spriteNum == 4){
                    image = up4;
                }
                if (spriteNum == 5){
                    image = up5;
                }
                if (spriteNum == 6){
                    image = up6;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                if (spriteNum == 3){
                    image = down3;
                }
                if (spriteNum == 4){
                    image = down4;
                }
                if (spriteNum == 5){
                    image = down5;
                }
                if (spriteNum == 6){
                    image = down6;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                if (spriteNum == 3){
                    image = left3;
                }
                if (spriteNum == 4){
                    image = left4;
                }
                if (spriteNum == 5){
                    image = left5;
                }
                if (spriteNum == 6){
                    image = left6;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right3;
                }
                if (spriteNum == 4){
                    image = right4;
                }
                if (spriteNum == 5){
                    image = right5;
                }
                if (spriteNum == 6){
                    image = right6;
                }
                break;
        }

        collisionOn = false;
        gp.cCheck.checkTile(this);

        if(!collisionOn) {
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

        int screenX = worldX - gp.player.worldX;
        int screenY = worldY - gp.player.worldY;

        g2.drawImage(image, screenX, screenY, (gp.tileSize*2), (gp.tileSize*2), null);

    }

}
