package crawler.util;

import crawler.HtmlPage;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class FileExporter implements Exporter {

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

    @Override
    public void saveResults(String path, List<HtmlPage> pages) {
        try {
            var filePath = Paths.get(path);

            var result = new StringBuilder();
            for (var page : pages) {
                result.append(page.toString());
                result.append('\n');
            }

            Files.writeString(filePath, result.toString());
        } catch (IOException e) {
            System.out.println("Can't export");
            e.printStackTrace();
        }
    }
}
