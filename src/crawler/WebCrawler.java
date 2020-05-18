package crawler;

import javax.swing.*;
import java.awt.*;

public class WebCrawler extends JFrame {
    public WebCrawler() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setTitle("Web crawler");
        var panel = initPanel();
        add(panel);
        setVisible(true);
    }

    private JPanel initPanel() {
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        var textArea = initTextArea();

        listPane.add(textArea);
        listPane.add(Box.createRigidArea(new Dimension(50 , 10)));
        listPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        return listPane;
    }

    private JTextArea initTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setName("TextArea");
        textArea.setText("HTML code?");
        textArea.setEnabled(false);
        return textArea;
    }
}