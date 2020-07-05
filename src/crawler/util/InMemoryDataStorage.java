package crawler.util;

import crawler.HtmlPage;

import java.util.ArrayList;
import java.util.List;

// Thread-safe
public class InMemoryDataStorage implements DataStorage {


    private List<HtmlPage> parsedPages = new ArrayList<>();

    @Override
    public void saveParsedPages(List<HtmlPage> pages) {
        synchronized (parsedPages) {
            parsedPages.addAll(pages);
        }
    }

    @Override
    public List<HtmlPage> getParsedPages() {
        return parsedPages;
    }
}
