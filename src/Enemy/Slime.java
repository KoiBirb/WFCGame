package Enemy;

import Main.GamePanel;
import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Slime extends Entity {

    public Slime(GamePanel gp) {
        super(gp);

        name = "Slime";
        baseSpeed = 2;
        maxHealth = 4;
        currentHealth = maxHealth;
        direction = "down";

        solidArea = new Rectangle(3, 18, 42, 30);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setAction (){

        actionLockCounter ++;

        if (actionLockCounter == 120) {

            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75){
                direction = "left";
            }
            if (i > 75 && i <= 100){
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }
}
