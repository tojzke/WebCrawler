package crawler.panels.main;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea {

    private static final String textAreaName = "HtmlTextArea";

    public TextArea() {
        this.setName(textAreaName);
        this.setEnabled(false);
        this.setDisabledTextColor(Color.BLACK);
    }

}
