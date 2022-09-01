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
            List<Song> songs = songRepository.findAll();
            // then send to thymeleaf through the model
            model.addAttribute("songs", songs);
            return "salmon-cookies/employees";
        }

        @PostMapping("/add-song")
        public RedirectView addSongToAlbum(String title, Integer length, Integer trackNumber, Album album){
//            Album thisAlbum = albumRepository.findByName(albumName);
            Song newSong = new Song(title,length,trackNumber,album);
            songRepository.save(newSong);

            return new RedirectView("/");
        }

    }
}
