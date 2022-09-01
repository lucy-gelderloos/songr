package com.gelderloos.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title = "";
    private String artist = "";
    private Integer songCount = 0;
    private Integer length = 0;
    private String imageUrl = "";
    @OneToMany(mappedBy = "album")
    private List<Song> songsOnAlbum;
    protected Album() {
    }
    public Album(String title, String artist, Integer songCount, Integer length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public List<Song> getSongsOnAlbum() {
        return songsOnAlbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(Integer songCount) {
        this.songCount = songCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSongsOnAlbum(List<Song> songsOnAlbum) {
        this.songsOnAlbum = songsOnAlbum;
    }
}
