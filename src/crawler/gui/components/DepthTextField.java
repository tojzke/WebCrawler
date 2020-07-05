package crawler.gui.components;

import crawler.gui.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class DepthTextField extends JTextField {

    private static final String DEFAULT_NAME = "DepthTextField";
    private static final Dimension DEFAULT_SIZE = new Dimension(
            SizeConstants.WINDOW_WIDTH - SizeConstants.DEFAULT_LABEL_WIDTH,
            SizeConstants.ROW_HEIGHT);

    public DepthTextField() {
        this.setName(DEFAULT_NAME);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setEnabled(true);
        this.setEditable(true);
    }

}
