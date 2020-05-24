package crawler.util;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;
import java.util.StringJoiner;

public class FileExporter {

    public void exportResult(String filePath, DefaultTableModel model) throws IOException {
        var path = Paths.get(filePath);

        var stringBuilder = new StringBuilder();

        var data = model.getDataVector();
        for (int i = 0; i < data.size(); ++i) {
            var row = data.get(i);
            for (int j = 0; j < row.size(); ++j) {
                stringBuilder.append(row.get(j));
                stringBuilder.append('\n');
            }
        }
        Files.writeString(path, stringBuilder.toString());
    }

}
