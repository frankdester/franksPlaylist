package com.franksPlaylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.addSong(33);
//        integers.addSong(39);
//        integers.addSong(32);
//        integers.addSong(33);
//        integers.addSong(33);
//        integers.addSong(2,22);
//        integers.remove(5);
//        System.out.println(integers);
//        //search(integers,"zamry");
//        System.out.println(integers);


        ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("Stormbringer", "Deep Purple");
        
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(24, playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);

        options(playList);

    }
    public static void menu() {
        System.out.println("options :\n" +
                " 0 - quit\n" +
                " 1 - skip to the next song\n" +
                " 2 - skip to the previous song\n" +
                " 3 - replay\n" +
                " 4 - delete song from playlist\n" +
                " 5 - print playlist 6 - show menu");

    }
    public static void options(LinkedList<Song> songList){
        menu();
        ListIterator<Song> list = songList.listIterator();
        boolean quit = false, forward = true;
        while(!quit){
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 0:
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        list.next();
                        forward = true;
                    }if(list.hasNext()){
                    System.out.println("now listening to "+list.next());
                    break;
                }else if(songList.size() == 0){
                    System.out.println("sorry!! There is no song");
                    break;
                }else{
                    System.out.println("this was the last song playing return to previous song");
                    break;
                }
                case 2:
                    if(forward){
                        list.previous();
                        forward = false;
                    }if(list.hasPrevious()){
                    System.out.println("now listening to "+list.previous());
                    break;
                }else if(songList.isEmpty()){
                    System.out.println("sorry!! There is no song");
                    break;
                }else{
                    System.out.println("this is the first song");
                    break;
                }
                case 3:
                    if(!forward){
                        if(list.hasNext()){
                            System.out.println("now listening to "+list.next());
                            forward = true;
                            break;
                        }else if(songList.isEmpty()){
                            System.out.println("sorry!! There is no song");
                            break;
                        }else{
                            System.out.println("this was the last song playing return to previous song");
                            break;
                        }
                    }else{
                        if(list.hasPrevious()){
                            System.out.println("now listening to "+list.previous());
                            forward = false;
                            break;
                        }else if(songList.size() == 0){
                            System.out.println("sorry!! There is no song");
                            break;
                        }else{
                            System.out.println("this is the first song");
                        }
                        break;
                    }
                case 4:
                    if(songList.isEmpty()){
                        System.out.println("sorry!! There is no song");
                        break;
                    }if(list.hasNext()){

                    if(list.hasNext()){
                        System.out.println("now listening to next "+list.next());
                        list.previous();
                        list.remove();

                        forward = true;
                        break;
                    }else if(songList.isEmpty()){
                        System.out.println("sorry!! There is no song");
                        break;
                    }
                }if(list.hasPrevious()){
                    list.next();
                    list.previous();
                    if(forward)
                        if(list.hasPrevious()){
                            System.out.println("now listening to previous "+list.previous());
                            list.remove();
                            forward = false;
                            break;
                        }else if(songList.size() == 0){
                            System.out.println("sorry!! There is no song");
                            break;
                        }
                }
                    break;
                case 5:
                    System.out.println(songList);
//                    another method could be
//                    System.out.println("**************************************");
//                    while (list.hasNext()){
//                        System.out.println(list.next());
//                    }System.out.println("**************************************");
                    break;
                case 6:
                    menu();
                    break;

            }
            System.out.println("To show menu press 6");
        }
    }

    public static boolean search (LinkedList<String> list, String val){
        ListIterator<String> i = list.listIterator();

        while (i.hasNext()){
            int comparing = i.next().compareTo(val);
            if(comparing == 0){
                System.out.println("something is equal " + val);
                return false;

            }
            else if(comparing > 0){
                i.previous();
                i.add(val);
                System.out.println("something is greater than " + val);
                return true;

            }
            else {
                System.out.println("something is lower than " + val);
            }
        }
        i.add(val);
        return true;
    }
}


