package crawler.gui;

import crawler.util.DataStorage;
import crawler.util.Exporter;
import crawler.util.FileExporter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class ExportButton extends JButton {


    private static final String DEFAULT_COMPONENT_TEXT = "Save";
    private static final Dimension DEFAULT_COMPONENT_SIZE = new Dimension(100, 30);

    private JTextField filePathTextField;
    private DataStorage dataStorage;
    private Exporter exporter;

    public ExportButton(JTextField filePathTextField, DataStorage dataStorage, Exporter exporter) {
        this.setName(NamingConstants.EXPORT_BUTTON);
        this.setText(DEFAULT_COMPONENT_TEXT);
        this.setSize(DEFAULT_COMPONENT_SIZE);

        this.filePathTextField = filePathTextField;
        this.dataStorage = dataStorage;
        this.exporter = exporter;


        this.addActionListener(actionEvent -> {
            final String path = filePathTextField.getText();
            try {
                exporter.saveResults(path, dataStorage.getParsedPages());
            } catch (IOException e) {
                System.out.println("Can't export");
                e.printStackTrace();
            }

        });

    }

}
