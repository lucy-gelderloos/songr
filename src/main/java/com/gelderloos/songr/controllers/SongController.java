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
import java.util.Optional;

@Controller
public class SongController {
        @Autowired
        SongRepository songRepository;
        @Autowired
        AlbumRepository albumRepository;

        @GetMapping("/songs")
        public String getAllSongs(Model model){
            List<Song> songList = songRepository.findAll();
            List<Album> albumList = albumRepository.findAll();
            model.addAttribute("songList", songList);
            model.addAttribute("albumList", albumList);
            return "songs";
        }

        @PostMapping("/add-song")
        public RedirectView addSongToAlbum(String title, Integer length, Integer trackNumber, String albumId){
            Long albumIdLong = Long.parseLong(albumId);
            Optional<Album> albumOpt = albumRepository.findById(albumIdLong);
            Album album = albumOpt.get();
            Song newSong = new Song(title,length,trackNumber,album);
            songRepository.save(newSong);

            return new RedirectView("/songs");
        }

    }

