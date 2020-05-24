package crawler.panels.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TitleTable extends JTable {

    private static final String DEFAULT_NAME = "TitlesTable";

    private DefaultTableModel tableModel = new DefaultTableModel();

    private String[] columnNames = {"URL", "Title"};

    public TitleTable() {
        super();
        this.setName(DEFAULT_NAME);
        this.setModel(tableModel);
        this.setEnabled(false);
        this.setFillsViewportHeight(true);
    }

    public void updateTableData(String[][] data) {
        tableModel.setDataVector(data, columnNames);
    }

}
