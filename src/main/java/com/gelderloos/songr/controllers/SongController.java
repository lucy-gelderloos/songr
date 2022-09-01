package com.gelderloos.songr.controllers;

import com.gelderloos.songr.models.Album;
import com.gelderloos.songr.models.Song;
import com.gelderloos.songr.repositories.AlbumRepository;
import com.gelderloos.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public class SongController {
    @Controller
    public class EmployeeController {

        @Autowired
        SongRepository songRepository;
        @Autowired
        AlbumRepository albumRepository;

        @GetMapping("/songs")
        public String getAllSongs(Model model){
            List<Song> songList = songRepository.findAll();
            // then send to thymeleaf through the model
            model.addAttribute("songList", songList);
            return "songs";
        }

        @PostMapping("/add-song")
        public RedirectView addSongToAlbum(String title, Integer length, Integer trackNumber, String albumTitle){
            Album thisAlbum = albumRepository.findByTitle(albumTitle);
            Song newSong = new Song(title,length,trackNumber,thisAlbum);
            songRepository.save(newSong);

            return new RedirectView("/");
        }

    }
}
