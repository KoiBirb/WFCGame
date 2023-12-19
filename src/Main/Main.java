package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Creates a java window
        JFrame window = new JFrame();
        // Change window settings
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Game");

        GamePanel gamePanel = new GamePanel();


        // place objects
        gamePanel.setupGame();

        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // start game
        gamePanel.startGameThread();
    }
}