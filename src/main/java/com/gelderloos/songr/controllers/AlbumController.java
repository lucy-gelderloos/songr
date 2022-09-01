package com.gelderloos.songr.controllers;

import com.gelderloos.songr.models.Album;
import com.gelderloos.songr.repositories.AlbumRepository;
import com.gelderloos.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    // https://www.baeldung.com/thymeleaf-arrays
    @GetMapping("/")
    public String albumsGet(Model model) {
        List<Album> albumList = albumRepository.findAll();
        model.addAttribute("albumList",albumList);
        return "albums";
    }
    // https://www.baeldung.com/java-optional
    @GetMapping("/album/{albumId}")
    public String albumGet(@PathVariable String albumId, Model model) {
        Optional<Album> albumOpt = albumRepository.findById(Long.parseLong(albumId));
        Album album = albumOpt.get();
        model.addAttribute("album",album);
        return "album";
    }

    // POST method to "/"
    // create an item in the DB
    @PostMapping("/")
    public RedirectView createAlbum(String title, String artist, Integer songCount, Integer length, String imgUrl){
        Album newAlbum = new Album(title, artist, songCount, length, imgUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/");
    }

}
