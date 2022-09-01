package com.gelderloos.songr.repositories;

import com.gelderloos.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

        public Album findByArtist(String artist);
        public Album findByTitle(String title);
    }

