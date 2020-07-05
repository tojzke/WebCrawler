package crawler.gui.components;

import crawler.gui.SizeConstants;

import javax.swing.*;
import java.awt.*;

public class TimeLimitLabel extends JLabel {

    private static final String DEFAULT_NAME = "TimeLimitLabel";
    private static final String DEFAULT_TEXT = "Time limit:";

    private static final Dimension DEFAULT_SIZE = new Dimension(SizeConstants.DEFAULT_LABEL_WIDTH, SizeConstants.ROW_HEIGHT);

    public TimeLimitLabel() {
        this.setName(DEFAULT_NAME);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setText(DEFAULT_TEXT);
    }

}
