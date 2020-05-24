package crawler.panels.result;

import javax.swing.*;
import java.awt.*;

public class ResultBottomPanel extends JPanel {

    public ResultBottomPanel(JLabel exportLabel, JTextField exportTextField, JButton exportButton) {
        this.setLayout(new BorderLayout(5, 10));
        this.add(exportLabel, BorderLayout.LINE_START);
        this.add(exportTextField, BorderLayout.CENTER);
        this.add(exportButton, BorderLayout.LINE_END);
    }

}
