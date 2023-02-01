import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MovieDownland {
    downland downlander = new downland();

    void MovieLaunch (String search) throws IOException {
        String url = buildUrl(search);
        String page = downlander.downland(url);

        String movieName = getTag(page, "trackName");
        String previewUrl = getTag(page, "previewUrl");
        System.out.println(movieName);
        String fileEx = previewUrl.substring(previewUrl.length() - 3);
        String fileName = movieName + "." + fileEx;
        try (InputStream in = new URL(previewUrl).openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
        System.out.println("Сохранено!");

        if (!Desktop.isDesktopSupported()) {
            System.out.println("Not sup");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File file = new File(fileName);
        desktop.open(file);
    }

    private String getTag(String page, String tagName) {
        int start = page.indexOf(tagName) + tagName.length() + 3;
        int end = page.indexOf("\"", start);
        String value = page.substring(start, end);
        return value;
    }

    private String buildUrl(String search) {
        int limit = 50;
        String term = search.replaceAll(" ", "+");
        String urll = "https://itunes.apple.com/search?term=";
        String lim = "&limit=" + limit;
        String media = "&media=movie";
        StringBuilder builder = new StringBuilder();
        builder.append(urll);
        builder.append(term);
        builder.append(lim);
        builder.append(media);
        return builder.toString();
    }
}
