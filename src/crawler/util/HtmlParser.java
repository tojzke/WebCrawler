package crawler.util;

import java.util.regex.Pattern;

public class HtmlParser {

    public static String parseTitle(String siteText) {
        String titleRegex = "(<title>)(.+)(</title>)";
        Pattern pattern = Pattern.compile(titleRegex);
        var matcher = pattern.matcher(siteText);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return "";
    }

}
