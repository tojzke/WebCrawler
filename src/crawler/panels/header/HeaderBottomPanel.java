package crawler.panels.header;

import javax.swing.*;
import java.awt.*;

public class HeaderBottomPanel extends JPanel {

    public HeaderBottomPanel(TitleLabel titleLabel, TitleTextLabel titleTextLabel) {
        this.setLayout(new BorderLayout(5, 10));
        this.add(titleLabel, BorderLayout.LINE_START);
        this.add(titleTextLabel, BorderLayout.CENTER);
    }

}
