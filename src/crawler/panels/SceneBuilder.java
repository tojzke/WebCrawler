package crawler.panels;

import crawler.panels.main.TextArea;
import crawler.panels.header.*;
import crawler.panels.main.MainPanel;
import crawler.panels.main.TitleTable;
import crawler.util.HtmlParser;

import javax.swing.*;
import java.awt.*;

public class SceneBuilder {


    public static JPanel buildScene() {

        var textField = new TextField();
        var urlLabel = new UrlLabel();
        var titleLabel = new TitleLabel();
        var titleTextLabel = new TitleTextLabel();
        var titleTable = new TitleTable();

        var button = new ParseButton(textField, titleTextLabel, titleTable, new HtmlParser());
        var headerBottomPanel = new HeaderBottomPanel(titleLabel, titleTextLabel);
        var headerPanel = new HeaderPanel(textField, urlLabel, button, headerBottomPanel);

        return new MainPanel(headerPanel, titleTable);
    }

}
