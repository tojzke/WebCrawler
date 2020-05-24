package crawler.panels.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TitleTable extends JTable {

    private static final String DEFAULT_NAME = "TitlesTable";

    private DefaultTableModel tableModel = new DefaultTableModel();

    private String[] columnNames = {"URL", "Title"};
    private String[][] sampleData = {
            {"Dodo", "dodopizza.ri"},
            {"MIS&S", "misis.ru"}
    };


    public TitleTable() {
        super();
        this.setName(DEFAULT_NAME);
        tableModel.setDataVector(sampleData, columnNames);
        this.setModel(tableModel);
        this.setEnabled(false);
        this.setFillsViewportHeight(true);
    }

    public void updateTableData(String[][] data) {
        tableModel.setDataVector(data, columnNames);
    }

}
