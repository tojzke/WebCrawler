package crawler.panels.header;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {


    public HeaderPanel(TextField textField, UrlLabel urlLabel, ParseButton button, HeaderBottomPanel headerBottomPanel) {
        this.setLayout(new BorderLayout(5, 10));
        this.add(textField, BorderLayout.CENTER);
        this.add(urlLabel, BorderLayout.LINE_START);
        this.add(button, BorderLayout.LINE_END);
        this.add(headerBottomPanel, BorderLayout.PAGE_END);
    }

}
