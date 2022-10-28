package com.ojas.model;

import java.util.List;

public class Album{

	private int albumid;
	private String movieName;
	private String musician;
	private int year;
	private int numberOfTracks;
	private List<AlbumTracks> tracks;
	
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(int albumid, String movieName, String musician, int year, int numberOfTracks,
			List<AlbumTracks> tracks) {
		super();
		this.albumid = albumid;
		this.movieName = movieName;
		this.musician = musician;
		this.year = year;
		this.numberOfTracks = numberOfTracks;
		this.tracks = tracks;
	}

	public int getAlbumid() {
		return albumid;
	}

	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMusician() {
		return musician;
	}

	public void setMusician(String musician) {
		this.musician = musician;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}

	public List<AlbumTracks> getTracks() {
		return tracks;
	}

	public void setTracks(List<AlbumTracks> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Album [albumid=" + albumid + ", movieName=" + movieName + ", musician=" + musician + ", year=" + year
				+ ", numberOfTracks=" + numberOfTracks + ",\n tracks=" + tracks + "]";
	}
	
	public void displayAlbum(List<Album> album) {
		if(album.size() == 0) {
			System.out.println("No Albums are available");
		}
		else {
		for(int i = 0; i < album.size(); i++) {
			String str = "";
			System.out.println("Album " + (i + 1) + " info is");
			str += "Album Id: " + album.get(i).getAlbumid() +"\n";
			str += "Album Name: " + album.get(i).getMovieName() +"\n";
			str += "Musician Name: " + album.get(i).getMusician() +"\n";
			str += "Year: " + album.get(i).getYear() +"\n";
			str += "Number Of Tracks: " + album.get(i).getNumberOfTracks() +"\n";
			
			System.out.print(str);
			AlbumTracks at = new AlbumTracks();
			at.tracksList(album.get(i).getTracks());
		}
	}
		}
	
}
