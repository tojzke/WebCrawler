package crawler.gui;

import crawler.gui.header.*;
import crawler.gui.result.*;
import crawler.util.FileExporter;
import crawler.util.HtmlParser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SceneBuilder {


    public static JPanel buildScene() {

        var urlLabel = ComponentsFactory.createLabel("TextFieldLabel", "Start URL:");
        var textField = ComponentsFactory.createTextField("UrlTextField");

        var workersLabel = ComponentsFactory.createLabel("WorkersCountLabel", "Workers:");
        var workersTextField = ComponentsFactory.createTextField("WorkersTextField");

        var depthLabel = ComponentsFactory.createLabel("DepthNumLabel", "Maximum depth:");
        var depthTextField = ComponentsFactory.createTextField("DepthTextField");
        var depthCheckBox = ComponentsFactory.createCheckBox("DepthCheckBox", "Enabled");

        var timeLimitLabel = ComponentsFactory.createLabel("TimeLimitLabel", "Time limit:");
        var timeLimitTextField = ComponentsFactory.createTextField("TimeLimitTextField");
        var secondsLabel = ComponentsFactory.createLabel(
                        "SecondsLabel",
                        "seconds",
                        new Dimension(SizeConstants.DEFAULT_LABEL_WIDTH - 50, SizeConstants.ROW_HEIGHT));
        var timeLimitCheckBox = ComponentsFactory.createCheckBox("TimeLimitCheckBox", "Enabled");

        var elapsedTimeLabel = ComponentsFactory.createLabel("ElapsedTimeLabel", "Elapsed time: ");
        var elapsedTimeCounterLabel = ComponentsFactory.createLabel("ElapsedTimeCounterLabel", "0:00");

        var pagesLabel = ComponentsFactory.createLabel("PagesLabel", "Parsed pages: ");
        var pagesCounterLabel = ComponentsFactory.createLabel("PagesCounterLabel", "0");


        var titleLabel = new TitleLabel();
        var titleTextLabel = new TitleTextLabel();
        var titleTable = new TitleTable();

        var exportLabel = ComponentsFactory.createLabel("ExportLabel", "Export:");
        var exportTextField = ComponentsFactory.createTextField("ExportUrlTextField");
        var exportButton = new ExportButton(exportTextField, titleTable, new FileExporter());

        JPanel resultBottomPanel = new ResultBottomPanel(exportLabel, exportTextField, exportButton);
        JButton button = new ParseButton(textField, titleTextLabel, titleTable, new HtmlParser());

        List<JPanel> panels = new ArrayList<>();
        panels.add(ComponentsFactory.createPanel("UrlPanel", urlLabel, textField, button));
        panels.add(ComponentsFactory.createPanel("WorkersPanel", workersLabel, workersTextField));
        panels.add(ComponentsFactory.createPanel("DepthPanel",depthLabel, depthTextField, depthCheckBox));
        panels.add(ComponentsFactory.createPanel("TimeLimitPanel", timeLimitLabel, timeLimitTextField, timeLimitCheckBox));
        panels.add(ComponentsFactory.createPanel("ElapsedTimePanel", elapsedTimeLabel, elapsedTimeCounterLabel));
        panels.add(ComponentsFactory.createPanel("PagesPanel", pagesLabel, pagesCounterLabel));
        panels.add(ComponentsFactory.createPanel("ExportPanel", exportLabel, exportTextField, exportButton));

        return new MainPanel(panels);
    }

}
