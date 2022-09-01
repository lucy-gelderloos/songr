package com.gelderloos.songr.models;

import javax.persistence.*;

@Entity
public class Song {
    private String title;
    private Integer length;
    private Integer trackNumber;

    @ManyToOne
    Album thisAlbum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    protected Song() {
    }

    public Song(String title, Integer length, Integer trackNumber, Album album) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.thisAlbum = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getAlbum() {
        return thisAlbum;
    }

    public void setAlbum(Album album) {
        this.thisAlbum = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
