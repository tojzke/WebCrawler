package crawler.gui.result;

import javax.swing.*;
import java.awt.*;

public class ExportLabel extends JLabel {
    private static final String DEFAULT_NAME = "ExportLabel";
    private static final String DEFAULT_TEXT = "Export:";
    private static final Dimension DEFAULT_SIZE = new Dimension(50, 30);


    public ExportLabel() {
        this.setName(DEFAULT_NAME);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setText(DEFAULT_TEXT);
    }

}
