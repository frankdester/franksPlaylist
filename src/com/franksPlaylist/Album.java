package com.franksPlaylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name,String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public boolean addSong(String titleOfSong,double duration){
        if(findSong(titleOfSong) == null)
        {
            Song checkedSong = new Song(titleOfSong,duration);
            this.songs.add(checkedSong);
            return true;
        }
        return false;
    }
    private Song findSong(String titleOfSong){
        for(Song chekedSong : this.songs) {
            if (titleOfSong.equals(chekedSong.getTitle()))
                return chekedSong;
        }
        return null;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int i = trackNumber - 1;
        if(i >= 0 && i<this.songs.size()) {
            playList.add(this.songs.get(i));
            return true;
        }
        System.out.println("no such entry");
        return false;
    }
    public boolean addToPlayList(String titleOfSong, LinkedList<Song> playList){
        for(Song checkedSong : this.songs) {
            if (titleOfSong.equals(checkedSong.getTitle())) {
                playList.add(checkedSong);
                return true;
            }
        }
        return false;
    }
}


