package crawler.gui.components;

import crawler.gui.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class WorkersLabel extends JLabel {

    private static final String DEFAULT_NAME = "WorkersCountLabel";
    private static final String DEFAULT_TEXT = "Workers:";

    private static final Dimension DEFAULT_SIZE = new Dimension(SizeConstants.DEFAULT_LABEL_WIDTH, SizeConstants.ROW_HEIGHT);

    public WorkersLabel() {
        this.setName(DEFAULT_NAME);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setText(DEFAULT_TEXT);
    }

}
