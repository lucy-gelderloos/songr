package com.gelderloos.songr.repositories;

import com.gelderloos.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
        // The reason we are using an interface, is so we can create CUSTOM CRUD queries

        // DARK MAGIC that we made happen with a specific function name
        public Album findByArtist(String artist);
        public Album findByTitle(String title);
    }

