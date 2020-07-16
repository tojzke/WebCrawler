package crawler.gui;

import crawler.util.DataStorage;
import crawler.util.HtmlParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.util.concurrent.Future;

public class ParseButton extends JToggleButton {

    private final String buttonText = "Parse";
    private JPanel mainPanel;
    private Map<String, Component> components;

    //TODO: Proper parsing
    public ParseButton(Map<String, Component> components, DataStorage dataStorage, HtmlParser htmlParser) {
        this.components = components;
        this.setName(NamingConstants.PARSE_BUTTON);
        this.setText(buttonText);

        this.setPreferredSize(new Dimension(100, 30));
        this.addItemListener(itemEvent -> {

            int state = itemEvent.getStateChange();
            if (state == ItemEvent.SELECTED) {
                System.out.println("Selected");
                var baseUrl = getBaseUrl();
                System.out.println("Getting results!");
                var results = htmlParser.startParsing(baseUrl, 10);
                System.out.println("Done!");
                System.out.println(results);
            } else {
                System.out.println("Deselected!");
            }
        });
    }


    private String getBaseUrl() {
        var urlTextField = components.get(NamingConstants.URL_TEXT_FIELD);
        if (urlTextField instanceof JTextField) {
            return ((JTextField) urlTextField).getText();
        } else {
            throw new IllegalStateException("No component for url text input!");
        }
    }
}
