package crawler.gui;

import crawler.util.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SceneBuilder {

    private static final Exporter exporter = new FileExporter();
    private static final DataStorage dataStorage = new InMemoryDataStorage();
    private static final HtmlParser htmlParser = new HtmlParser();

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

        var exportLabel = ComponentsFactory.createLabel("ExportLabel", "Export:");
        var exportTextField = ComponentsFactory.createTextField("ExportUrlTextField");
        var exportButton = new ExportButton(exportTextField,dataStorage, exporter);

        JButton button = new ParseButton(textField, dataStorage,htmlParser);

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
