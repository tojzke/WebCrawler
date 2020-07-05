package crawler.gui.components;

import crawler.gui.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class DepthCheckBox extends JCheckBox {

    private static final String DEFAULT_NAME = "DepthCheckBox";
    private static final Dimension DEFAULT_SIZE = new Dimension(
            SizeConstants.WINDOW_WIDTH - SizeConstants.DEFAULT_LABEL_WIDTH,
            SizeConstants.ROW_HEIGHT);

    public DepthCheckBox() {
        this.setName(DEFAULT_NAME);
        this.setText("Enabled");

    }

}
