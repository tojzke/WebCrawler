package crawler.gui.result;

import javax.swing.*;

public class ExportTextField extends JTextField {

    private static final String DEFAULT_COMPONENT_NAME = "ExportUrlTextField";

    public ExportTextField() {
        this.setName(DEFAULT_COMPONENT_NAME);
        this.setEnabled(true);
        this.setEditable(true);
    }

}
