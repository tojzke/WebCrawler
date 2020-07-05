package crawler.gui.header;

import crawler.gui.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class UrlTextField extends JTextField {

    private static final String DEFAULT_COMPONENT_NAME = "UrlTextField";

    public UrlTextField() {
        this.setName(DEFAULT_COMPONENT_NAME);
        this.setPreferredSize(new Dimension(SizeConstants.DEFAULT_LABEL_WIDTH, SizeConstants.ROW_HEIGHT));
        this.setEnabled(true);
        this.setEditable(true);
    }

}
