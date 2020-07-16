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

    //TODO: Proper parsing
    public ParseButton(Map<String, Component> components, DataStorage dataStorage, HtmlParser htmlParser) {
        this.setName(NamingConstants.PARSE_BUTTON);
        this.setText(buttonText);

        this.setPreferredSize(new Dimension(100, 30));
        this.addItemListener(itemEvent -> {

            int state = itemEvent.getStateChange();
            if (state == ItemEvent.SELECTED) {
                System.out.println("Selected");
                Thread testThread = new Thread(() -> {
                    System.out.println("Loopin...");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException exc) {
                        System.out.println("Can't sleep thread!");
                        exc.printStackTrace();
                    }
                });
            } else {
                System.out.println("Deselected");
            }
        });
    }
}
