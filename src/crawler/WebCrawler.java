package crawler;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WebCrawler extends JFrame {


    private static final int WIDTH = 400;
    private static final int HEIGHT = 700;

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();

    JTextArea textArea = new JTextArea();
    private final String textAreaName = "HtmlTextArea";

    JTextField textField = new JTextField();
    private final String textFieldName = "UrlTextField";

    JButton button = new JButton();
    private final String buttonName = "RunButton";
    private final String buttonText = "Get text!";

    public WebCrawler() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Web crawler");
        initPanel();
        add(mainPanel);
        setVisible(true);
    }

    private void initPanel() {
        mainPanel.setLayout(new BorderLayout(10, 10));
        initHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.PAGE_START);

        initTextArea();
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    private void initHeaderPanel() {
        headerPanel.setLayout(new BorderLayout(5, 10));
        initTextField();
        headerPanel.add(textField, BorderLayout.LINE_START);
        initButton();
        headerPanel.add(button, BorderLayout.LINE_END);
    }

    private void initTextArea() {
        textArea.setName(textAreaName);
        textArea.setEnabled(false);
    }

    private void initTextField() {
        textField.setName(textFieldName);
        textField.setEnabled(true);
        textField.setEditable(true);
        textField.setPreferredSize(new Dimension(250, 30));

    }

    private void initButton() {
        button.setName(buttonName);
        button.setText(buttonText);
        button.addActionListener(actionEvent -> {

            final String url = textField.getText();
            try {
                final InputStream inputStream = new URL(url).openStream();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                final StringBuilder stringBuilder = new StringBuilder();

                String nextLine;
                while ((nextLine = reader.readLine()) != null) {
                    stringBuilder.append(nextLine);
                    stringBuilder.append(LINE_SEPARATOR);
                }

                final String siteText = stringBuilder.toString();
                textArea.setText(siteText);
            } catch (IOException e) {
                System.out.println("Can't read from url");
                e.printStackTrace();
            }

        });

    }
}