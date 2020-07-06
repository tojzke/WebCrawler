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

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");


    private final String buttonName = "RunButton";
    private final String buttonText = "Parse";

    private JPanel mainPanel;

    //TODO: Proper parsing
    public ParseButton(Map<String, Component> components, DataStorage dataStorage, HtmlParser htmlParser) {
        this.setName(buttonName);
        this.setText(buttonText);

        this.setPreferredSize(new Dimension(100, 30));
        this.addItemListener(itemEvent -> {

            int state = itemEvent.getStateChange();
            if (state == ItemEvent.SELECTED) {
                System.out.println("Selected");
                String startingUrl = null;

            } else {
                System.out.println("Deselected");
            }
        });
    }
}
