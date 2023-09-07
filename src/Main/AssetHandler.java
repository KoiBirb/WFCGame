package Main;

import object.dynamicObjects.Chest;
import object.dynamicObjects.Key;

public class AssetHandler {

    GamePanel gp;

    public AssetHandler(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new Key();
        gp.obj[0].worldX = 14 * gp.tileSize;
        gp.obj[0].worldY = 4 * gp.tileSize;

        gp.obj[1] = new Chest();
        gp.obj[1].worldX = 15 * gp.tileSize;
        gp.obj[1].worldY = 5 * gp.tileSize;
    }
}
