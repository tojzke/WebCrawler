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

        var urlLabel = ComponentsFactory.createLabel(NamingConstants.TEXT_FIELD_LABEL, "Start URL:");
        components.put(NamingConstants.TEXT_FIELD_LABEL, urlLabel);
        var textField = ComponentsFactory.createTextField(NamingConstants.URL_TEXT_FIELD);
        components.put(NamingConstants.URL_TEXT_FIELD, textField);
        var parseButton = new ParseButton(components, dataStorage, htmlParser);
        components.put(NamingConstants.PARSE_BUTTON, parseButton);
        var urlPanel = ComponentsFactory.createPanel(NamingConstants.URL_PANEL, urlLabel, textField, parseButton);
        mainPanel.add(urlPanel);
        components.put(NamingConstants.URL_PANEL, urlPanel);

        var workersLabel = ComponentsFactory.createLabel(NamingConstants.WORKERS_COUNT_LABEL, "Workers:");
        components.put(NamingConstants.WORKERS_COUNT_LABEL, workersLabel);
        var workersTextField = ComponentsFactory.createTextField(NamingConstants.WORKERS_TEXT_FIELD);
        components.put(NamingConstants.WORKERS_TEXT_FIELD, workersTextField);
        var workersPanel = ComponentsFactory.createPanel(NamingConstants.WORKERS_PANEL, workersLabel, workersTextField);
        mainPanel.add(workersPanel);
        components.put(NamingConstants.WORKERS_PANEL, workersPanel);

        var depthLabel = ComponentsFactory.createLabel(NamingConstants.DEPTH_NUM_LABEL, "Maximum depth:");
        components.put(NamingConstants.DEPTH_NUM_LABEL, depthLabel);
        var depthTextField = ComponentsFactory.createTextField(NamingConstants.DEPTH_TEXT_FIELD);
        components.put(NamingConstants.DEPTH_TEXT_FIELD, depthTextField);
        var depthCheckBox = ComponentsFactory.createCheckBox(NamingConstants.DEPTH_CHECK_BOX, "Enabled");
        components.put(NamingConstants.DEPTH_CHECK_BOX, depthCheckBox);
        var depthPanel = ComponentsFactory.createPanel(NamingConstants.DEPTH_PANEL, depthLabel, depthTextField, depthCheckBox);
        mainPanel.add(depthPanel);
        components.put(NamingConstants.DEPTH_PANEL, depthPanel);

        var timeLimitLabel = ComponentsFactory.createLabel(NamingConstants.TIME_LIMIT_LABEL, "Time limit:");
        components.put(NamingConstants.TIME_LIMIT_LABEL, timeLimitLabel);
        var timeLimitTextField = ComponentsFactory.createTextField(NamingConstants.TIME_LIMIT_TEXT_FIELD);
        components.put(NamingConstants.TIME_LIMIT_LABEL, timeLimitTextField);
        var secondsLabel = ComponentsFactory.createLabel(
                NamingConstants.SECONDS_LABEL,
                        "seconds",
                        new Dimension(SizeConstants.DEFAULT_LABEL_WIDTH - 50, SizeConstants.ROW_HEIGHT));
        components.put(NamingConstants.SECONDS_LABEL, secondsLabel);
        var timeLimitCheckBox = ComponentsFactory.createCheckBox(NamingConstants.TIME_LIMIT_CHECK_BOX, "Enabled");
        components.put(NamingConstants.TIME_LIMIT_CHECK_BOX, timeLimitCheckBox);
        var timeLimitPanel = ComponentsFactory.createPanel(NamingConstants.TIME_LIMIT_PANEL, timeLimitLabel, timeLimitTextField, timeLimitCheckBox);
        mainPanel.add(timeLimitPanel);
        components.put(NamingConstants.TIME_LIMIT_PANEL, timeLimitPanel);

        var elapsedTimeLabel = ComponentsFactory.createLabel(NamingConstants.ELAPSED_TIME_LABEL, "Elapsed time: ");
        components.put(NamingConstants.ELAPSED_TIME_LABEL, elapsedTimeLabel);
        var elapsedTimeCounterLabel = ComponentsFactory.createLabel(NamingConstants.ELAPSED_TIME_COUNTER_LABEL, "0:00");
        components.put(NamingConstants.ELAPSED_TIME_COUNTER_LABEL, elapsedTimeCounterLabel);
        var elapsedTimePanel = ComponentsFactory.createPanel(NamingConstants.ELAPSED_TIME_PANEL, elapsedTimeLabel, elapsedTimeCounterLabel);
        mainPanel.add(elapsedTimePanel);
        components.put(NamingConstants.ELAPSED_TIME_PANEL, elapsedTimePanel);

        var pagesLabel = ComponentsFactory.createLabel(NamingConstants.PARSED_PAGES_LABEL, "Parsed pages: ");
        components.put(NamingConstants.PARSED_PAGES_LABEL, pagesLabel);
        var pagesCounterLabel = ComponentsFactory.createLabel(NamingConstants.PARSED_LABEL, "0");
        components.put(NamingConstants.PARSED_LABEL, pagesCounterLabel);
        var pagesPanel = ComponentsFactory.createPanel(NamingConstants.PAGES_PANEL, pagesLabel, pagesCounterLabel);
        mainPanel.add(NamingConstants.PAGES_PANEL, pagesPanel);
        components.put(NamingConstants.PAGES_PANEL, pagesPanel);

        var exportLabel = ComponentsFactory.createLabel(NamingConstants.EXPORT_LABEL, "Export:");
        components.put(NamingConstants.EXPORT_LABEL, exportLabel);
        var exportTextField = ComponentsFactory.createTextField(NamingConstants.EXPORT_URL_TEXT_FIELD);
        components.put(NamingConstants.EXPORT_URL_TEXT_FIELD, exportTextField);
        var exportButton = new ExportButton(exportTextField, dataStorage, exporter);
        components.put(NamingConstants.EXPORT_BUTTON, exportButton);
        var exportPanel = ComponentsFactory.createPanel(NamingConstants.EXPORT_PANEL, exportLabel, exportTextField, exportButton);
        mainPanel.add(NamingConstants.EXPORT_PANEL, exportPanel);

        return mainPanel;
    }
}
