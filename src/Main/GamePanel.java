package Main;
import entity.Entity;
import entity.Player;
import object.dynamicObjects.SuperObject;
import object.staticObjects.ObjectManager;
import tiles.TileManager;
import WaveFunctionCollapse.tiles.TileWFCController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // More screen settings
    final int originalTileSize = 32; // 32x32 tile size
    public final int scale = 2;

    public final int tileSize = originalTileSize * scale; // real tile size
    public final int maxScreenCol = 16; // tiles per col
    public final int maxScreenRow = 12; // tiles per row
    public final int screenWidth = tileSize * maxScreenCol; // game screen width
    public final int screenHeight = tileSize * maxScreenRow; // game screen height

    // world map settings
    TileWFCController tileWFCC = new TileWFCController();
    public static final int maxWorldSize = 40;

    int FPS = 60; // frames per second

    // initiate classes
    TileManager tileM = new TileManager(this);
    ObjectManager objM = new ObjectManager(this);
    public AssetHandler aHandler = new AssetHandler(this);

    KeyInput keyI = new KeyInput(this);

    Sound music = new Sound();
    Sound effect = new Sound();

    Thread gameThread;

    public UI ui = new UI(this);

    public CollisionCheck cCheck = new CollisionCheck(this);
    public Player player = new Player(this,keyI);
    public SuperObject[] obj = new SuperObject[10];
    public Entity enemy[] = new Entity[20];

    // game state
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int loadingState = 3;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.decode("#A6B04F"));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyI);
        this.setFocusable(true);
    }



    public void setupGame() {
        aHandler.setObject();
        aHandler.setEnemy();
        tileM.loadMap("/Maps/tileMap.txt");
        objM.loadMap("/Maps/objectMap.txt");
        playMusic(0);
    }
    public void loadMap(){
        gameState = loadingState;
        double baseLoadTime = System.currentTimeMillis();
        tileWFCC.initialize();
        double currentLoadTime = (System.currentTimeMillis() - baseLoadTime)/1000.0;
        System.out.println("Load Time: " + currentLoadTime + "s");
        gameState = playState;
    }

    public void startGameThread() {
        // initiate thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        // Delta method FPS clock
        double drawInterval = 1000000000.0/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {

        if(gameState == playState) {
            player.update();
            objM.update();
            for(int i = 0; i < enemy.length; i++) {
                if (enemy[i] != null){
                    enemy[i].update();
                }
            }
        }
        if(gameState == pauseState){

        }
    }

    public void paintComponent(Graphics g){

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            if (gameState == loadingState) {
                tileWFCC.draw(g2);
            } else {

                tileM.draw(g2);
                objM.draw(g2);
                for (SuperObject superObject : obj) {
                    if (superObject != null) {
                        superObject.draw(g2, this);
                    }

                    for (Entity entity : enemy) {
                        if (entity != null) {
                            entity.draw(g2, this);
                        }
                    }

                }
                player.draw(g2);
                objM.drawTree(g2);
                ui.draw(g2);
            }

            g2.dispose();
        }
        public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();
        }
        public void stopMusic(){
            music.stop();
        }
        public void playSoundEffect(int i) {
            effect.setFile(i);
            effect.play();
        }
}
