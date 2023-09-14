package object.staticObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StaticObject implements Cloneable{

    public BufferedImage image;
    public boolean collision = false;
    public Rectangle solidArea = new Rectangle(0,0,0,0);
    public int worldX, worldY;
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public Object clone() throws CloneNotSupportedException
    {
        solidArea = new Rectangle (0,0, image.getWidth() * 2, image.getHeight() * 2);
        return super.clone();
    }
}