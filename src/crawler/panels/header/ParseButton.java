package crawler.panels.header;

import crawler.panels.main.TextArea;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static crawler.util.HtmlParser.parseTitle;

public class ParseButton extends JButton {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");


    private final String buttonName = "RunButton";
    private final String buttonText = "Get text!";

    private TextField textField;
    private TextArea textArea;
    private TitleTextLabel titleTextLabel;

    public ParseButton(TextField textField, TextArea textArea, TitleTextLabel titleTextLabel) {
        this.setName(buttonName);
        this.setText(buttonText);

        this.textField = textField;
        this.textArea = textArea;
        this.titleTextLabel = titleTextLabel;
        this.setPreferredSize(new Dimension(100, 30));
        this.addActionListener(actionEvent -> {

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

}
