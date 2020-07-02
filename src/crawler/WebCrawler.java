package crawler;

import crawler.panels.SceneBuilder;
import crawler.panels.SizeConstants;

import javax.swing.JFrame;

public class WebCrawler extends JFrame {


    public WebCrawler() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SizeConstants.WINDOW_WIDTH, SizeConstants.WINDOW_HEIGHT);
        setTitle("Web crawler");
        add(SceneBuilder.buildScene());
        setVisible(true);
    }

}