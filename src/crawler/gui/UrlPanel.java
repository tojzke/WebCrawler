package crawler.gui;

import javax.swing.*;

public class UrlPanel extends JPanel {

    JTextField urlTextField;
    JLabel urlLabel;
    JButton urlButton;

    public UrlPanel(JTextField urlTextField, JLabel urlLabel, JButton urlButton) {
        this.urlTextField = urlTextField;
        this.urlLabel = urlLabel;
        this.urlButton = urlButton;

        this.add(urlLabel);
        this.add(urlTextField);
        this.add(urlButton);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    }


}
