package crawler.gui;


import javax.swing.*;

import java.util.List;

public class MainPanel extends JPanel {

    public MainPanel(List<JPanel> panels) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        panels.forEach(this::add);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

}