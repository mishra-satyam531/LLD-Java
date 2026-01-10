package BookMyShow.models;

public class Movie {
    private int movieId;
    private String movieName;
    private int durationInMinutes;

    public Movie(int movieId, String movieName, int durationInMinutes) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.durationInMinutes = durationInMinutes;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    
}
