package object.staticObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

public class StaticObject implements Cloneable{

    public BufferedImage image;
    public boolean collision = false;
    public Rectangle solidArea;
    public int worldX, worldY;
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    private final SecureRandom random = new SecureRandom();
    final int randomOffsetX = random.nextInt(0, 20);
    final int randomOffsetY = random.nextInt(0, 20);
    public Object clone() throws CloneNotSupportedException
    {
        solidArea = new Rectangle(randomOffsetX, randomOffsetY, image.getWidth() * 2, image.getHeight() * 2);
        return super.clone();
    }
}