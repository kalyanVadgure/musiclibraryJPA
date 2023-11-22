/*
 * 
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

package com.example.song.model;

import javax.persistence.*;


@Entity
@Table(name="playlist")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="songid")
    private Integer songId;

    @Column(name="songname")
    private String songName;

    @Column(name="lyricist")
    private String lyricist;

    @Column(name="singer")
    private String singer;

    @Column(name="musicdirector")
    private String musicDirector;

    public Song() {
        
    }

    public Song(Integer songId, String songName, String lyricist, String singer, String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    public Integer getSongId() {
        return this.songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return this.songName;
    }
    
    public void setSongName(String songName) {
        this.songName = songName;
    }
    
    public String getLyricist() {
        return this.lyricist;
    }
    
    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getSinger() {
        return this.singer;
    }
    
    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicDirector() {
        return this.musicDirector;
    }
    
    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

}
