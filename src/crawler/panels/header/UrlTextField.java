package crawler.panels.header;

import javax.swing.*;

public class UrlTextField extends JTextField {

    private static final String DEFAULT_COMPONENT_NAME = "UrlTextField";

    public UrlTextField() {
        this.setName(DEFAULT_COMPONENT_NAME);
        this.setEnabled(true);
        this.setEditable(true);
    }

}
