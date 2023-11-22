package com.example.song.repository;

import com.example.song.model.*;
import java.util.*;


public interface SongRepository {
    ArrayList<Song> getSongs();
    Song getSongById(Integer songId);
    Song addSong(Song song);

    Song upadateSong(Integer songId, Song song);
    void deleteSong(Integer songId);
}
