package crawler.gui.result;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    public ResultPanel(JTable titleTable, JPanel resultBottomPanel) {
        this.setLayout(new BorderLayout(5, 10));
        this.add(new JScrollPane(titleTable), BorderLayout.CENTER);
        this.add(resultBottomPanel, BorderLayout.PAGE_END);
    }

}
