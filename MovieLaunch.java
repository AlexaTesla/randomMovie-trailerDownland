package Media;

import java.io.IOException;

public class MovieLaunch {
    public static void main(String[] args) throws IOException {
        MovieSearch move = new MovieSearch();
        String[] movies = move.randomNamesMovie();
        System.out.println(movies);
        MovieDownland player = new MovieDownland();
        player.MovieLaunch(movies[0]);
    }
}
