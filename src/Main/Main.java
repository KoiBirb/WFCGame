package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Creates a java window
        JFrame window = new JFrame();
        // Change window settings
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window .setResizable(false);
        window.setTitle("2D Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        // Allows the window to be resized
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // place objects
        gamePanel.setupGame();
        // start game
        gamePanel.startGameThread();
    }
}