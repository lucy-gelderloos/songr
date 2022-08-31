package com.gelderloos.songr.controllers;

import com.gelderloos.songr.models.Album;
import com.gelderloos.songr.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    // https://www.baeldung.com/thymeleaf-arrays
    @GetMapping("/")
    public String albumsGet(Model model) {

        List<Album> albumList = albumRepository.findAll();

        model.addAttribute("albumList",albumList);

        return "albums";
    }

    // POST method to "/"
    // create an item in the DB
    @PostMapping("/")
    public RedirectView createAlbum(String title, String artist, int songCount, int length, String imgUrl){
        Album newAlbum = new Album(title, artist, songCount, length, imgUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/");
    }
}
