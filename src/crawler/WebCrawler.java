package crawler;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class WebCrawler extends JFrame {


    private static final int HEIGHT = 1024;
    private static final int WIDTH = 768;

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    JPanel mainPanel = new JPanel();

    JPanel headerPanel = new JPanel();

    JTextArea textArea = new JTextArea();
    private final String textAreaName = "HtmlTextArea";

    JTextField textField = new JTextField();
    private final String textFieldName = "UrlTextField";

    JLabel textFieldLabel = new JLabel();
    private final String textFieldLabelName = "TextFieldLabel";
    private final String textFieldLabelText = "URL:";


    JButton button = new JButton();
    private final String buttonName = "RunButton";
    private final String buttonText = "Get text!";

    JLabel titleLabel = new JLabel();
    private final String labelName = "Title";
    private final String labelText = "Title:";

    JLabel titleTextLabel = new JLabel();
    private final String titleTextLabelName = "TitleLabel";

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
        headerPanel.add(textField, BorderLayout.CENTER);
        initTextFieldLabel();
        headerPanel.add(textFieldLabel, BorderLayout.LINE_START);
        initButton();
        headerPanel.add(button, BorderLayout.LINE_END);
        initTitleLabel();

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout(5, 10));
        footerPanel.add(titleLabel, BorderLayout.LINE_START);
        footerPanel.add(titleTextLabel, BorderLayout.CENTER);

        headerPanel.add(footerPanel, BorderLayout.PAGE_END);

    }

    private void initTextFieldLabel() {
        textFieldLabel.setName(textFieldLabelName);
        textFieldLabel.setPreferredSize(new Dimension(30, 30));
        textFieldLabel.setText(textFieldLabelText);
    }

    private void initTitleLabel() {
        titleLabel.setName(labelName);
        titleLabel.setText(labelText);
        titleLabel.setPreferredSize(new Dimension(30, 30));

        titleTextLabel.setName(titleTextLabelName);
    }

    private void initTextArea() {
        textArea.setName(textAreaName);
        textArea.setEnabled(false);
    }

    private void initTextField() {
        textField.setName(textFieldName);
        textField.setEnabled(true);
        textField.setEditable(true);

    }

    private void initButton() {
        button.setName(buttonName);
        button.setText(buttonText);
        button.setPreferredSize(new Dimension(100, 30));
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
                titleTextLabel.setText(parseTitle(siteText));
            } catch (IOException e) {
                System.out.println("Can't read from url");
                e.printStackTrace();
            }

        });

    }

    private String parseTitle(String siteText) {
        String titleRegex = "(<title>)(.+)(<\\/title>)";
        Pattern pattern = Pattern.compile(titleRegex);
        var matcher = pattern.matcher(siteText);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return "";
    }
}