package crawler.panels;

import javax.swing.*;

public class WorkersPanel extends JPanel {

    JLabel workersLabel;
    JTextField workersTextField;

    public WorkersPanel(JLabel workersLabel, JTextField workersTextField) {
        this.workersLabel = workersLabel;
        this.workersTextField = workersTextField;

        this.add(workersLabel);
        this.add(workersTextField);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    }


}
