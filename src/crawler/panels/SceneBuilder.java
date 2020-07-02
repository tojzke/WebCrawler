package crawler.panels;

import crawler.panels.components.WorkersLabel;
import crawler.panels.components.WorkersTextField;
import crawler.panels.header.*;
import crawler.panels.result.*;
import crawler.util.FileExporter;
import crawler.util.HtmlParser;

import javax.swing.*;
import java.awt.*;

public class SceneBuilder {


    public static JPanel buildScene() {

        var textField = new UrlTextField();
        var urlLabel = new UrlLabel();

        var workersLabel = new WorkersLabel();
        var workersTextField = new WorkersTextField();

        var titleLabel = new TitleLabel();
        var titleTextLabel = new TitleTextLabel();
        var titleTable = new TitleTable();

        JLabel exportLabel = new ExportLabel();
        JTextField exportTextField = new ExportTextField();
        JButton exportButton = new ExportButton(exportTextField, titleTable, new FileExporter());

        JPanel resultBottomPanel = new ResultBottomPanel(exportLabel, exportTextField, exportButton);
        JButton button = new ParseButton(textField, titleTextLabel, titleTable, new HtmlParser());


        JPanel urlPanel = new UrlPanel(textField, urlLabel, button);
        JPanel workersPanel = new WorkersPanel(workersLabel, workersTextField);

        return new MainPanel(urlPanel, workersPanel);
    }

}
