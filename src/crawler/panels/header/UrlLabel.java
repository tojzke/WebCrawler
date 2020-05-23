package crawler.panels.header;

import javax.swing.*;
import java.awt.*;

public class UrlLabel extends JLabel {
    private static final String DEFAULT_NAME = "TextFieldLabel";
    private static final String DEFAULT_TEXT = "URL:";

    private static final Dimension DEFAULT_SIZE = new Dimension(30, 30);

    public UrlLabel() {
        this.setName(DEFAULT_NAME);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setText(DEFAULT_TEXT);
    }
}
