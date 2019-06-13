package edu.jenshin831.lab.songr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String artist;
    int songCount;
    long seconds;
    String imageUrl;

    public Album() {}

    public Album(String title, String artist, int songCount, long minutes, String imageUrl) {

        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.seconds = minutes;
        this.imageUrl = imageUrl;
    }
    //this doesn't work
    private void turnMinutesToSeconds(long minutes) {

        setSeconds(minutes * 60);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public long getSeconds() {
        return seconds * 60;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
