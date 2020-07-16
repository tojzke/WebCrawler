package crawler.util;

import crawler.HtmlPage;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO: Make it use concurrency
public class HtmlParser {

    private static final String TITLE_REGEX = "(<title>)(.+)(<\\/title>)";
    private static final String LINK_REGEX = "<a.+>";

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

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


    public Future<List<HtmlPage>> startParsing(String baseUrl, int timeoutInSeconds) {
        var doc = Jsoup.parse(baseUrl);
        var links = doc.getElementsByTag("a");

        for (var link : links) {
            var linkHref = link.attr("href");
            try {
                linkHref = processLink(linkHref, baseUrl);
                var linkAndTitle = List.of(linkHref, parseTitleInUrl(linkHref));
                System.out.printf("Adding %s to results...\n", linkAndTitle);
            } catch (Exception e) {
                System.out.println("Not valid ref: " + linkHref);
            }

        }
        return null;
    }

    public String getHtmlPageContent(String url) throws IOException {
        var connection = new URL(url).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String nextLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((nextLine = reader.readLine()) != null) {
            stringBuilder.append(nextLine);
            stringBuilder.append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
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

    private String processLink(String linkHref, String baseUrl) throws Exception {

        String resultedLink = linkHref;

        if (linkHref.startsWith("http://") || linkHref.startsWith("https://")) {
            resultedLink = linkHref;
        } else if (linkHref.startsWith("//")) { // without protocol
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

}
