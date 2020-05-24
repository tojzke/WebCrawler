package crawler.panels.result;

import crawler.util.FileExporter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExportButton extends JButton {

    private static final String DEFAULT_COMPONENT_NAME = "ExportButton";
    private static final String DEFAULT_COMPONENT_TEXT = "Save";
    private static final Dimension DEFAULT_COMPONENT_SIZE = new Dimension(100, 30);

    private JTextField filePathTextField;
    private JTable titleTable;
    private FileExporter exporter;

    public ExportButton(JTextField filePathTextField, JTable titleTable, FileExporter exporter) {
        this.setName(DEFAULT_COMPONENT_NAME);
        this.setText(DEFAULT_COMPONENT_TEXT);
        this.setSize(DEFAULT_COMPONENT_SIZE);

        this.filePathTextField = filePathTextField;
        this.titleTable = titleTable;
        this.exporter = exporter;

        this.addActionListener(actionEvent -> {
            final String path = filePathTextField.getText();
            final DefaultTableModel model = (DefaultTableModel)titleTable.getModel();
            try {
                exporter.exportResult(path, model);
            } catch (IOException e) {
                System.out.println("Can't export");
                e.printStackTrace();
            }

        });

    }

}
