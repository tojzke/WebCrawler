package crawler.util;

import crawler.HtmlPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Should be thread safe
public class InMemoryDataStorage implements DataStorage {

    private List<HtmlPage> parsedPages = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void saveParsedPages(List<HtmlPage> pages) {
        parsedPages.addAll(pages);
    }

    @Override
    public List<HtmlPage> getParsedPages() {
        return parsedPages;
    }
}
