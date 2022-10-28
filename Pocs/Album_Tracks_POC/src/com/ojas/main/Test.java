package com.ojas.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ojas.model.Album;
import com.ojas.model.AlbumTracks;

public class Test {
	static Scanner sc = new Scanner(System.in);
	
	public Album addAlbum() {
		
		System.out.println("Enter Album Id");
		int id = sc.nextInt();
		System.out.println("Enter Movie Name");
		String mName = sc.next();
		System.out.println("Enter Musician Name");
		String musicName = sc.next();
		System.out.println("Enter Year Of Album");
		int year = sc.nextInt();
		System.out.println("Enter Number Of Tracks");
		int tracks = sc.nextInt();
		
		List<AlbumTracks> li = new ArrayList<>();
		
		for(int i = 1; i <= tracks; i++) {
			System.out.println("Enter " + i + " Track Detailes");
			System.out.println("Track Id");
			int tid = sc.nextInt();
			System.out.println("Track Name");
			String tname = sc.next();
			System.out.println("Artist Name");
			String artist = sc.next();
			System.out.println("Track Duration");
			String duration = sc.next();
			
			AlbumTracks track = new AlbumTracks(tid, tname, artist, duration);
			li.add(track);
		}
		
		Album album = new Album(id, mName, musicName, year, tracks, li);
		
		return album;
	}

	public static void main(String[] args) {
		
		Test t = new Test();
		Album_Tracks album = new Album_Tracks();
		AlbumTracks at = new AlbumTracks();
		Album alb = new Album();
		
		while(true) {
			album.menu();
			int option = sc.nextInt();
			
			switch(option) {
				
				case 1: 
					alb = t.addAlbum();
					System.out.println(album.addAlbum(alb));
					break;
				
				case 2:
					List<String> li = album.getAlbums();
					System.out.println("AlbumNames List is\n");
					
					li.forEach(System.out::println);
					break;
				
				case 3:
					System.out.println("Enter Album Name");
					List<AlbumTracks> tli = album.getTracks(sc.next());
					at.tracksList(tli);
					
					break;
				
				case 4:
					System.out.println("Enter Album Name");
					System.out.println(album.deleteAlbum(sc.next()));
					break;
				
				case 5:
					List<Album> sortedLi = album.sortAlbumsByName();
					if(sortedLi.size() == 0) {
						System.out.println("Sorry, Album Not Found");
					}
					else {
						System.out.println("Albums List Sorted based on Album Name");
						alb.displayAlbum(sortedLi);
					}
					break;
				
				case 6:
					System.out.println("Enter Album Name");
					List<AlbumTracks> sortTracks = album.sortByArtist(sc.next());
					System.out.println("Track List Sorted based on Artist Name");
					at.tracksList(sortTracks);
					
					break;
				
				case 7:
					System.out.println("Enter Album Name");
					List<AlbumTracks> sortTrack = album.sortByTrackName(sc.next());
					System.out.println("Track List Sorted based on Track Name");
					at.tracksList(sortTrack);
					
					break;
				
				case 8:
					System.exit(0);
					break;
				
				default:
					System.out.println("Invalid Option");
			}
		}
	}
}
