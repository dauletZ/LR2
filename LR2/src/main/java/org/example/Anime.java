package org.example;

public class Anime {
    private String title;
    private String format;
    private String releaseDate;
    private String genre;
    private String status;

    public Anime(String title, String format, String releaseDate, String genre, String status) {
        this.title = title;
        this.format = format;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.status = status;
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}