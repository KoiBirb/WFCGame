package Main;

import entity.Player;
import object.SuperObject;
import tiles.TileManager;
import WaveFunctionCollapse.WFCController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // More screen settings
    final int originalTileSize = 32; // 32x32 tile size
    final int scale = 2;

    public final int tileSize = originalTileSize * scale; // real tile size
    public final int maxScreenCol = 16; // tiles per col
    public final int maxScreenRow = 12; // tiles per row
    public final int screenWidth = tileSize * maxScreenCol; // game screen width
    public final int screenHeight = tileSize * maxScreenRow; // game screen height

    // world map settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    int FPS = 60; // frames per second

    // initiate classes
    TileManager tileM = new TileManager(this);
    KeyInput keyI = new KeyInput(this);
    Sound music = new Sound();
    Sound effect = new Sound();
    Thread gameThread;
    WFCController wfcC = new WFCController();
    public CollisionCheck cCheck = new CollisionCheck(this);
    public AssetHandler aHandler = new AssetHandler(this);
    public UI ui = new UI(this);

    public Player player = new Player(this,keyI);
    public SuperObject obj[] = new SuperObject[10];

    // game state
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyI);
        this.setFocusable(true);
    }

    public void setupGame() {
        wfcC.initialize();
        aHandler.setObject();
        playMusic(0);
        gameState = playState;
        tileM.loadMap("/Map/map.txt");
    }

    public void startGameThread() {
        // initiate thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        // Delta method FPS clock
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        // while game exists update and draw screen
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
        }
        if(gameState == pauseState){

        }
    }

    public void paintComponent(Graphics g){

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            tileM.draw(g2);
            for(int i = 0; i < obj.length; i++) {
                if(obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }
            player.draw(g2);
            ui.draw(g2);

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
