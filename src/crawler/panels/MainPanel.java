package crawler.panels;


import crawler.panels.result.TitleTable;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MainPanel extends JPanel {


    public MainPanel(JPanel... panels) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Arrays.stream(panels)
                .forEach(this::add);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

}