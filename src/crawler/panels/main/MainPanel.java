package crawler.panels.main;


import crawler.panels.header.HeaderPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {


    public MainPanel(HeaderPanel headerPanel, TitleTable titleTable) {
        this.setLayout(new BorderLayout(10, 10));
        this.add(headerPanel, BorderLayout.PAGE_START);
        this.add(new JScrollPane(titleTable), BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

}