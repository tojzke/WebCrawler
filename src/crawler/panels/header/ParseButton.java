package crawler.panels.header;

import crawler.panels.main.TextArea;
import crawler.panels.main.TitleTable;
import crawler.util.HtmlParser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ParseButton extends JButton {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");


    private final String buttonName = "RunButton";
    private final String buttonText = "Parse";

    private TextField textField;
    private TitleTable titleTable;
    private TitleTextLabel titleTextLabel;
    private HtmlParser htmlParser;

    public ParseButton(TextField textField, TitleTextLabel titleTextLabel, TitleTable titleTable, HtmlParser htmlParser) {
        this.setName(buttonName);
        this.setText(buttonText);

        this.textField = textField;
        this.titleTable = titleTable;
        this.titleTextLabel = titleTextLabel;
        this.htmlParser = htmlParser;
        this.setPreferredSize(new Dimension(100, 30));
        this.addActionListener(actionEvent -> {

            final String url = textField.getText();
            try {
                final var urlConnection = new URL(url).openConnection();
                if (!urlConnection.getContentType().equals("text/html")) {
                    throw new IllegalStateException("Can't parse not html content");
                }
                final InputStream inputStream = urlConnection.getInputStream();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                final StringBuilder stringBuilder = new StringBuilder();

                String nextLine;
                while ((nextLine = reader.readLine()) != null) {
                    stringBuilder.append(nextLine);
                    stringBuilder.append(LINE_SEPARATOR);
                }

                final String siteText = stringBuilder.toString();
                titleTextLabel.setText(htmlParser.parseTitle(siteText));
                titleTable.updateTableData(htmlParser.parseLinks(url, siteText));

            } catch (IOException e) {
                System.out.println("Can't read from url");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });

    }

}
