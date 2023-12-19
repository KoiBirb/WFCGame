package Main;

import entity.Entity;
import object.staticObjects.StaticObject;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class CollisionCheck {

    GamePanel gp;

    public CollisionCheck(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity){

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        try {
            switch (entity.direction) {
                case "up":
                    entityTopRow = (entityTopWorldY - (int) entity.speed) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "down":
                    entityBottomRow = (entityBottomWorldY + (int) entity.speed) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "left":
                    entityLeftCol = (entityLeftWorldX - (int) entity.speed) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "right":
                    entityRightCol = (entityRightWorldX + (int) entity.speed) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            entity.collisionOn = true;
        }
    }
    public int checkDynamicObject(Entity entity, boolean player) {

        int index = 999;

        for (int i = 0; i < gp.obj.length; i++){
            if(gp.obj[i] != null) {
                // entity solid area pos
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                // obj solid area pos
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player){
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }

        }

        return index;
    }
    public void checkStaticObject(Entity entity) {
        int worldCol = 0;
        int worldRow = 0;
        ArrayList<StaticObject> objects = new ArrayList<>();

        while (worldCol < gp.maxWorldSize && worldRow < gp.maxWorldSize) {

            int tileNum = gp.objM.mapObjectNum[worldCol][worldRow];
            int worldX = (worldCol * gp.tileSize) - 5;
            int worldY = (worldRow * gp.tileSize) - 10;

            if (worldX + (gp.tileSize * 2) > gp.player.worldX - gp.player.screenX &&
                    worldX - (gp.tileSize * 2) < gp.player.worldX + gp.player.screenX &&
                    worldY + (gp.tileSize * 2) > gp.player.worldY - gp.player.screenY &&
                    worldY - (gp.tileSize * 2) < gp.player.worldY + gp.player.screenY) {

                if (gp.objM.object[tileNum].collision) {
                    try {
                        StaticObject currentObject = (StaticObject) gp.objM.object[tileNum].clone();
                        currentObject.worldX = worldX;
                        currentObject.worldY = worldY;
                        objects.add(currentObject);
                    } catch (CloneNotSupportedException e){}

                }
            }

            worldCol++;

            if (worldCol == gp.maxWorldSize) {
                worldCol = 0;
                worldRow++;
            }
        }

        for (StaticObject object : objects) {
            if (object != null) {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                object.solidArea.x = object.worldX + object.solidArea.x;
                object.solidArea.y = object.worldY + object.solidArea.y;

                switch (entity.direction) {
                    case "up" -> {
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(object.solidArea)) {
                            if (object.collision) {
                                entity.collisionOn = true;
                            }
                        }
                    }
                    case "down" -> {
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(object.solidArea)) {
                            if (object.collision) {
                                entity.collisionOn = true;
                            }
                        }
                    }
                    case "left" -> {
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(object.solidArea)) {
                            if (object.collision) {
                                entity.collisionOn = true;
                            }
                        }
                    }
                    case "right" -> {
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(object.solidArea)) {
                            if (object.collision) {
                                entity.collisionOn = true;
                            }
                        }
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                object.solidArea.x = object.solidAreaDefaultX;
                object.solidArea.y = object.solidAreaDefaultY;
            }
        }
    }
}
