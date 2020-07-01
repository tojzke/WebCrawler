package crawler.util;

import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.LINE_SEPARATOR;

public class HtmlParser {

    private static final String TITLE_REGEX = "(<title>)(.+)(<\\/title>)";
    private static final String LINK_REGEX = "<a.+>";

    private static final Pattern TITLE_PATTERN = Pattern.compile(TITLE_REGEX);
    private static final Pattern LINK_PATTERN = Pattern.compile(LINK_REGEX);

    private static final Pattern absolutePattern = Pattern.compile("/^([a-z0-9]*:|.{0})\\/\\/.*$/gmi");
    private static final Pattern relativePattern = Pattern.compile("(/?)([\\w.%/-]+)");

    public String parseTitle(String siteText) {

        var matcher = TITLE_PATTERN.matcher(siteText);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return "";
    }


    public String[][] parseLinks(String baseUrl, String title, String siteText) {
        List<List<String>> linksAndTitles = new ArrayList<>();
        linksAndTitles.add(List.of(baseUrl, title));

        var doc = Jsoup.parse(siteText);
        var links = doc.getElementsByTag("a");

        for (var link : links) {
            var linkHref = link.attr("href");
            try {
                linkHref = proccessLink(linkHref, baseUrl);
                var linkTitle = link.attr("title");
                var linkAndTitle = List.of(linkHref, parseTitleInUrl(linkHref));
//                var linkAndTitle = List.of(linkHref, linkTitle);
                System.out.printf("Adding %s to results...\n", linkAndTitle);
                linksAndTitles.add(linkAndTitle);
            } catch (Exception e) {
                System.out.println("Not valid ref: " + linkHref);
            }

        }
        return listTo2dArray(linksAndTitles);
    }

    private String parseTitleInUrl(String urlLink) throws IOException {
        var connection = new URL(urlLink).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String nextLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((nextLine = reader.readLine()) != null) {
            stringBuilder.append(nextLine);
            stringBuilder.append(LINE_SEPARATOR);
        }
        Pattern patternTitle = Pattern.compile("(<title[\\w=\\-\"]*>)(.*?)(</title>)");
        Matcher matcherTitle = patternTitle.matcher(stringBuilder);
        if (matcherTitle.find()) {
            return matcherTitle.group(2);
        }
        return "No title";
    }

    private String proccessLink(String linkHref, String baseUrl) throws Exception {

        String resultedLink = linkHref;

        if (linkHref.startsWith("http://") || linkHref.startsWith("https://")) {
            resultedLink = linkHref;
        } else if (linkHref.startsWith("//")){ // without protocol
            resultedLink = "https:" + linkHref;
        } else if (relativePattern.matcher(linkHref).matches()) { // relative link
            var cutTo = baseUrl.lastIndexOf("/") + 1;
            resultedLink = baseUrl.substring(0, cutTo) + linkHref;
        }
        if (checkLink(resultedLink)) {
            return resultedLink;
        } else {
            throw new IllegalStateException("Not html page");
        }
    }

    private boolean checkLink(String resultedLink) {
        try {
            final var urlConnection = new URL(resultedLink).openConnection();
            return urlConnection.getContentType().contains("text/html");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
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
