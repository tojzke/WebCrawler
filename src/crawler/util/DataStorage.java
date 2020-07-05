package crawler.util;

import crawler.HtmlPage;

import java.util.List;

public interface DataStorage {

    void saveParsedPages(List<HtmlPage> pages);
    List<HtmlPage> getParsedPages();

}
