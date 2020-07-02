package crawler.panels.header;

import javax.swing.*;
import java.awt.*;

public class TitleLabel extends JLabel {

    private static final String DEFAULT_NAME = "Title";
    private static final String DEFAULT_TEXT = "Title:";
    private static final Dimension DEFAULT_SIZE = new Dimension(100, 30);

    public TitleLabel() {
        this.setName(DEFAULT_NAME);
        this.setText(DEFAULT_TEXT);
        this.setPreferredSize(DEFAULT_SIZE);
    }

}
