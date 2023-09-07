package object.dynamicObjects;

import object.dynamicObjects.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Key extends SuperObject {

    public Key() {
        name = "Key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/key.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
