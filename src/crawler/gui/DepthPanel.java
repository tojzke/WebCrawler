package crawler.gui;

import javax.swing.*;

public class DepthPanel extends JPanel {

    private JLabel depthLabel;
    private JTextField depthTextField;
    private JCheckBox depthCheckBox;

    public DepthPanel(JLabel depthLabel, JTextField depthTextField, JCheckBox depthCheckBox) {
        this.depthLabel = depthLabel;
        this.depthTextField = depthTextField;
        this.depthCheckBox = depthCheckBox;

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(depthLabel);
        this.add(depthTextField);
        this.add(depthCheckBox);
    }



}
