package crawler.panels.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TitleTable extends JTable {

    private DefaultTableModel tableModel = new DefaultTableModel();

    private String[] columnNames = {"Title", "URL"};
    private String[][] sampleData = {
            {"Dodo", "dodopizza.ri"},
            {"MIS&S", "misis.ru"}
    };


    public TitleTable() {
        super();
        tableModel.setDataVector(sampleData, columnNames);
        this.setModel(tableModel);
        this.setFillsViewportHeight(true);
    }

    public void updateTableData(String[][] data) {
        tableModel.setDataVector(data, columnNames);
    }

}
