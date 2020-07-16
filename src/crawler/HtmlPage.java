package crawler;

public class HtmlPage {
    private String link;
    private String title;

    public HtmlPage(String link, String title) {
        this.link = link;
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }
}
