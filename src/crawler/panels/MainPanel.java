package crawler.panels;


import crawler.panels.header.HeaderPanel;
import crawler.panels.result.TitleTable;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {


    public MainPanel(JPanel headerPanel, JPanel resultPanel) {
        this.setLayout(new BorderLayout(10, 10));
        this.add(headerPanel, BorderLayout.PAGE_START);
        this.add(resultPanel, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

}