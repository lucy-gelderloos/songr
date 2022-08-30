package com.gelderloos.songr.controllers;

import com.gelderloos.songr.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {

    // https://www.baeldung.com/thymeleaf-arrays
    @GetMapping("/albums")
    public String albumsGet(Model model) {
        Album[] albumArray = new Album[3];
        albumArray[0] = new Album("How It Ends","DeVotchKa",14,3431,"https://upload.wikimedia.org/wikipedia/en/6/6c/DeVotchKa_-_How_it_Ends.jpg");
        albumArray[1] = new Album("100 Lovers","DeVotchKa",14,3431,"https://upload.wikimedia.org/wikipedia/en/1/16/100_Lovers_%28DeVotchKa_album_-_cover_art%29.jpg");
        albumArray[2] = new Album("Live with the Colorado Symphony","DeVotchKa",14,3431,"https://m.media-amazon.com/images/I/81+nwKP9vVL._SL1500_.jpg");

        model.addAttribute("albumArray",albumArray);

        return "albums";
    }
}
