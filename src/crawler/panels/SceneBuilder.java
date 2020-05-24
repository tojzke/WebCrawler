package crawler.panels;

import crawler.panels.header.*;
import crawler.panels.result.*;
import crawler.util.FileExporter;
import crawler.util.HtmlParser;

import javax.swing.*;

public class SceneBuilder {


    public static JPanel buildScene() {

        var textField = new UrlTextField();
        var urlLabel = new UrlLabel();
        var titleLabel = new TitleLabel();
        var titleTextLabel = new TitleTextLabel();
        var titleTable = new TitleTable();

        JLabel exportLabel = new ExportLabel();
        JTextField exportTextField = new ExportTextField();
        JButton exportButton = new ExportButton(exportTextField, titleTable, new FileExporter());

        var button = new ParseButton(textField, titleTextLabel, titleTable, new HtmlParser());
        var headerBottomPanel = new HeaderBottomPanel(titleLabel, titleTextLabel);
        var headerPanel = new HeaderPanel(textField, urlLabel, button, headerBottomPanel);
        JPanel resultBottomPanel = new ResultBottomPanel(exportLabel, exportTextField, exportButton);
        JPanel resultPanel = new ResultPanel(titleTable, resultBottomPanel);


        return new MainPanel(headerPanel, resultPanel);
    }

}
