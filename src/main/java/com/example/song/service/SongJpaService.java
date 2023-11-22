/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

package com.example.song.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.song.repository.*;
import com.example.song.model.*;
import java.util.*;

import com.sun.xml.bind.annotation.OverrideAnnotationOf;


@Service 
public class SongJpaService implements SongRepository {
    @Autowired
    public SongJpaRepository songJpaRepository;

    @Override 
    public ArrayList<Song> getSongs() {
        List<Song> songsList = songJpaRepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(songsList);

        return songs;
    }

    @Override
    public Song getSongById(Integer songId) {
        try {
            Song song = songJpaRepository.findById(songId).get();
            return song; 
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song) {
        
        songJpaRepository.save(song);
        return song;
    }

    @Override
    public Song upadateSong(Integer songId, Song song) {
        try {
            Song newSong = songJpaRepository.findById(songId).get();
            if(song.getSongName() != null) {
                newSong.setSongName(song.getSongName());
            }

            if(song.getLyricist() != null) {
                newSong.setLyricist(song.getLyricist());
            }

            if(song.getSinger() != null) {
                newSong.setSinger(song.getSinger());
            }

            if(song.getMusicDirector() != null) {
                newSong.setMusicDirector(song.getMusicDirector());
            }

            songJpaRepository.save(newSong);

            return newSong;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        
    
    }

    @Override 
    public void deleteSong(Integer songId) {
        try {
            songJpaRepository.deleteById(songId);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}