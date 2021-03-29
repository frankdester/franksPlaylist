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
//
//package com.company;
//
//        import com.array.*;
//        import com.bank.Bank;
//        import com.bank.Customer;
//        import com.bills_Burger.DeluxeBurger;
//        import com.bills_Burger.Hamburger;
//        import com.bills_Burger.HealthyBurger;
//        import com.polymorphism.Car;
//        import com.polymorphism.Mitsubishi;
//
//        import java.util.*;
//
//public class Main {
//    private static Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
////
////        ArrayList<Integer> integers = new ArrayList<>();
////        integers.add(33);
////        integers.add(39);
////        integers.add(32);
////        integers.add(33);
////        integers.add(33);
////        integers.add(2,22);
////        integers.remove(5);
////        System.out.println(integers);
////        //search(integers,"zamry");
////        System.out.println(integers);
//
//
//        ArrayList<Album> albums = new ArrayList<>();
//
//        Album album = new Album("Stormbringer", "Deep Purple");
//        album.add("Stormbringer", 4.6);
//        album.add("Love don't mean a thing", 4.22);
//        album.add("Holy man", 4.3);
//        album.add("Hold on", 5.6);
//        album.add("Lady double dealer", 3.21);
//        album.add("You can't do it right", 6.23);
//        album.add("High ball shooter", 4.27);
//        album.add("The gypsy", 4.2);
//        album.add("Soldier of fortune", 3.13);
//        albums.add(album);
//
//        album = new Album("For those about to rock", "AC/DC");
//        album.add("For those about to rock", 5.44);
//        album.add("I put the finger on you", 3.25);
//        album.add("Lets go", 3.45);
//        album.add("Inject the venom", 3.33);
//        album.add("Snowballed", 4.51);
//        album.add("Evil walks", 3.45);
//        album.add("C.O.D.", 5.25);
//        album.add("Breaking the rules", 5.32);
//        album.add("Night of the long knives", 5.12);
//        albums.add(album);
//
//        LinkedList<Song> playList = new LinkedList<Song>();
//        albums.get(0).addToPlayList("You can't do it right", playList);
//        albums.get(0).addToPlayList(9, playList);
//        albums.get(1).addToPlayList(3, playList);
//        albums.get(1).addToPlayList(24, playList);
//        albums.get(0).addToPlayList("Holy man", playList);
//        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
//        albums.get(0).addToPlayList(9, playList);
//        albums.get(1).addToPlayList(3, playList);
//        albums.get(1).addToPlayList(2, playList);
//
//        options(playList);
//
//    }
//    public static void menu() {
//        System.out.println("""
//                options :\s
//                0 - quit\s
//                1 - skip to the next song\s
//                2 - skip to the previous song\s
//                3 - replay\s
//                4 - delete song from playlist\s
//                5 - print playlist\s
//                6 - show menu""");
//
//    }
//    public static void options(LinkedList<Song> songList){
//        menu();
//        ListIterator<Song> list = songList.listIterator();
//        boolean quit = false, forward = true;
//        while(!quit){
//            int option = scanner.nextInt();
//            scanner.nextLine();
//            switch(option){
//                case 0:
//                    quit = true;
//                    break;
//                case 1:
//                    if(!forward){
//                        list.next();
//                        forward = true;
//                    }if(list.hasNext()){
//                    System.out.println("now listening to "+list.next());
//                    break;
//                }else if(songList.size() == 0){
//                    System.out.println("sorry!! There is no song");
//                    break;
//                }else{
//                    System.out.println("this was the last song playing return to previous song");
//                    break;
//                }
//                case 2:
//                    if(forward){
//                        list.previous();
//                        forward = false;
//                    }if(list.hasPrevious()){
//                    System.out.println("now listening to "+list.previous());
//                    break;
//                }else if(songList.isEmpty()){
//                    System.out.println("sorry!! There is no song");
//                    break;
//                }else{
//                    System.out.println("this is the first song");
//                    break;
//                }
//                case 3:
//                    if(!forward){
//                        if(list.hasNext()){
//                            System.out.println("now listening to "+list.next());
//                            forward = true;
//                            break;
//                        }else if(songList.isEmpty()){
//                            System.out.println("sorry!! There is no song");
//                            break;
//                        }else{
//                            System.out.println("this was the last song playing return to previous song");
//                            break;
//                        }
//                    }else{
//                        if(list.hasPrevious()){
//                            System.out.println("now listening to "+list.previous());
//                            forward = false;
//                            break;
//                        }else if(songList.size() == 0){
//                            System.out.println("sorry!! There is no song");
//                            break;
//                        }else{
//                            System.out.println("this is the first song");
//                        }
//                        break;
//                    }
//                case 4:
//                    if(songList.isEmpty()){
//                        System.out.println("sorry!! There is no song");
//                        break;
//                    }if(list.hasNext()){
//
//                    if(list.hasNext()){
//                        System.out.println("now listening to next "+list.next());
//                        list.previous();
//                        list.remove();
//
//                        forward = true;
//                        break;
//                    }else if(songList.isEmpty()){
//                        System.out.println("sorry!! There is no song");
//                        break;
//                    }
//                }if(list.hasPrevious()){
//                    list.next();
//                    list.previous();
//                    if(forward)
//                        if(list.hasPrevious()){
//                            System.out.println("now listening to previous "+list.previous());
//                            list.remove();
//                            forward = false;
//                            break;
//                        }else if(songList.size() == 0){
//                            System.out.println("sorry!! There is no song");
//                            break;
//                        }
//                }
//                    break;
//                case 5:
//                    System.out.println(songList);
////                    another method could be
////                    System.out.println("**************************************");
////                    while (list.hasNext()){
////                        System.out.println(list.next());
////                    }System.out.println("**************************************");
//                    break;
//                case 6:
//                    menu();
//                    break;
//
//            }
//            System.out.println("To show menu press 6");
//        }
//    }
//
////    public static boolean search (LinkedList<String> list, String val){
////        ListIterator<String> i = list.listIterator();
////
////        while (i.hasNext()){
////            int comparing = i.next().compareTo(val);
////            if(comparing == 0){
////                System.out.println("something is equal " + val);
////                return false;
////
////            }
////            else if(comparing > 0){
////                i.previous();
////                i.add(val);
////                System.out.println("something is greater than " + val);
////                return true;
////
////            }
////            else {
////                System.out.println("something is lower than " + val);
////            }
////        }
////        i.add(val);
////        return true;
////    }
//}
//

