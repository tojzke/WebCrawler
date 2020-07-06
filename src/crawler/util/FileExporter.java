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
