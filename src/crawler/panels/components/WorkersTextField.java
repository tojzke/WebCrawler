package crawler.panels.components;

import crawler.panels.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class WorkersTextField extends JTextField {

    private static final String DEFAULT_NAME = "WorkersTextField";
    private static final Dimension DEFAULT_SIZE = new Dimension(
            SizeConstants.WINDOW_WIDTH - SizeConstants.DEFAULT_LABEL_WIDTH,
            SizeConstants.ROW_HEIGHT);

    public WorkersTextField() {
        this.setName(DEFAULT_NAME);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setEnabled(true);
        this.setEditable(true);
    }


}
