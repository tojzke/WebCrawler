package crawler.gui;

import crawler.util.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SceneBuilder {

    private static final Exporter exporter = new FileExporter();
    private static final DataStorage dataStorage = new InMemoryDataStorage();
    private static final HtmlParser htmlParser = new HtmlParser();

    //TODO: create map of components
    public static JPanel buildScene() {

        JPanel mainPanel = ComponentsFactory.createMainPanel();
        Map<String, Component> components = new HashMap<>();

        var urlLabel = ComponentsFactory.createLabel("TextFieldLabel", "Start URL:");
        var textField = ComponentsFactory.createTextField("UrlTextField");
        var parseButton = new ParseButton(null, dataStorage, htmlParser);
        mainPanel.add(ComponentsFactory.createPanel(NamingConstants.URL_PANEL, urlLabel, textField, parseButton));

        var workersLabel = ComponentsFactory.createLabel("WorkersCountLabel", "Workers:");
        var workersTextField = ComponentsFactory.createTextField("WorkersTextField");
        mainPanel.add(ComponentsFactory.createPanel(NamingConstants.WORKERS_PANEL, workersLabel, workersTextField));

        var depthLabel = ComponentsFactory.createLabel("DepthNumLabel", "Maximum depth:");
        var depthTextField = ComponentsFactory.createTextField("DepthTextField");
        var depthCheckBox = ComponentsFactory.createCheckBox("DepthCheckBox", "Enabled");
        mainPanel.add(ComponentsFactory.createPanel(NamingConstants.DEPTH_PANEL,depthLabel, depthTextField, depthCheckBox));

        var timeLimitLabel = ComponentsFactory.createLabel("TimeLimitLabel", "Time limit:");
        var timeLimitTextField = ComponentsFactory.createTextField("TimeLimitTextField");
        var secondsLabel = ComponentsFactory.createLabel(
                        "SecondsLabel",
                        "seconds",
                        new Dimension(SizeConstants.DEFAULT_LABEL_WIDTH - 50, SizeConstants.ROW_HEIGHT));
        var timeLimitCheckBox = ComponentsFactory.createCheckBox("TimeLimitCheckBox", "Enabled");
        mainPanel.add(ComponentsFactory.createPanel(NamingConstants.TIME_LIMIT_PANEL, timeLimitLabel, timeLimitTextField, timeLimitCheckBox));


        var elapsedTimeLabel = ComponentsFactory.createLabel("ElapsedTimeLabel", "Elapsed time: ");
        var elapsedTimeCounterLabel = ComponentsFactory.createLabel("ElapsedTimeCounterLabel", "0:00");
        mainPanel.add(ComponentsFactory.createPanel(NamingConstants.ELAPSED_TIME_PANEL, elapsedTimeLabel, elapsedTimeCounterLabel));


        var pagesLabel = ComponentsFactory.createLabel("ParsedPagesLabel", "Parsed pages: ");
        var pagesCounterLabel = ComponentsFactory.createLabel("ParsedLabel", "0");
        mainPanel.add(ComponentsFactory.createPanel(NamingConstants.PAGES_PANEL, pagesLabel, pagesCounterLabel));


        var exportLabel = ComponentsFactory.createLabel("ExportLabel", "Export:");
        var exportTextField = ComponentsFactory.createTextField("ExportUrlTextField");
        var exportButton = new ExportButton(exportTextField,dataStorage, exporter);
        mainPanel.add(ComponentsFactory.createPanel(NamingConstants.EXPORT_PANEL, exportLabel, exportTextField, exportButton));

        return mainPanel;
    }
}
