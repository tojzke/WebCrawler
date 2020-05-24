package crawler.util;

import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class HtmlParser {

    private static final String TITLE_REGEX = "(<title>)(.+)(<\\/title>)";
    private static final String LINK_REGEX = "<a.+>";

    private static final Pattern TITLE_PATTERN = Pattern.compile(TITLE_REGEX);
    private static final Pattern LINK_PATTERN = Pattern.compile(LINK_REGEX);

    private static final Pattern absolutePattern = Pattern.compile("/^([a-z0-9]*:|.{0})\\/\\/.*$/gmi");
    private static final Pattern relativePattern = Pattern.compile("/^[^\\/]+\\/[^\\/].*$|^\\/[^\\/].*$/gmi");

    public String parseTitle(String siteText) {

        var matcher = TITLE_PATTERN.matcher(siteText);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return "";
    }


    public String[][] parseLinks(String baseUrl, String siteText) {
        List<List<String>> linksAndTitles = new ArrayList<>();

        var doc = Jsoup.parse(siteText);
        var links = doc.getElementsByTag("a");

        for (var link : links) {
            var linkHref = link.attr("href");
            linkHref = proccessLink(linkHref, baseUrl);
            var linkTitle = link.attr("title");
            var linkAndTitle = List.of(linkHref, linkTitle);
            linksAndTitles.add(linkAndTitle);
        }
        return listTo2dArray(linksAndTitles);
    }

    private String proccessLink(String linkHref, String baseUrl) {

        if (absolutePattern.matcher(linkHref).matches()) {
            return linkHref;
        } else if (!linkHref.contains("/")) { // relative link
            var cutTo = baseUrl.lastIndexOf("/") + 1;
            return baseUrl.substring(0, cutTo) + linkHref;
        } else { // without protocol
            return "https:" + linkHref;
        }
    }

    private  String[][] listTo2dArray(List<List<String>> list) {
        String[][] array = new String[list.size()][];

        int i = 0;
        for (List<String> nestedList : list) {
            array[i++] = nestedList.toArray(new String[0]);
        }
        return array;
    }
}
