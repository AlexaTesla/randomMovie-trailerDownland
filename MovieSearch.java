package Media;

public class MovieSearch {
    downland downlander = new downland();

    String[] randomNamesMovie() {
        String url = "https://randommer.io/random-movies";
        String page = downlander.downland(url);

        String[] movies = new String[5];
        int end = 0;
        for (int i = 0; i < 5; i++) {
            int caption = page.indexOf("<div class=\"caption\"");
            int start = caption+24;
            end = page.indexOf("</p>", start);
            String movieName = page.substring(start, end);
            String nameYear = movieName.substring(0, movieName.length() - 6);
            movies[i] = nameYear;
        }
        return movies;
    }
}
