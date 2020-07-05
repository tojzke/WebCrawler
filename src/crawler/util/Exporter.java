package crawler.util;

import crawler.HtmlPage;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface Exporter {

    void saveResults(String path, List<HtmlPage> pages) throws IOException;

}
