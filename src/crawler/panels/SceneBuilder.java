package crawler.panels;

import crawler.panels.main.TextArea;
import crawler.panels.header.*;
import crawler.panels.main.MainPanel;

import javax.swing.*;
import java.awt.*;

public class SceneBuilder {


    public static JPanel buildScene() {

        var textField = new TextField();
        var urlLabel = new UrlLabel();
        var textArea = new TextArea();
        var titleLabel = new TitleLabel();
        var titleTextLabel = new TitleTextLabel();

        var button = new ParseButton(textField, textArea, titleTextLabel);
        var headerBottomPanel = new HeaderBottomPanel(titleLabel, titleTextLabel);
        var headerPanel = new HeaderPanel(textField, urlLabel, button, headerBottomPanel);

        return new MainPanel(headerPanel, textArea);
    }

}
