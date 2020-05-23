package crawler;

import crawler.panels.SceneBuilder;

import javax.swing.*;

public class WebCrawler extends JFrame {


    private static final int HEIGHT = 1024;
    private static final int WIDTH = 768;

    public WebCrawler() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Web crawler");
        add(SceneBuilder.buildScene());
        setVisible(true);
    }

}