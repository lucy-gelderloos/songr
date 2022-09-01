package com.gelderloos.songr.repositories;

import com.gelderloos.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
