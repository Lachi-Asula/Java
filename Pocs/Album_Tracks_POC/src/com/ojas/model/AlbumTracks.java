package com.ojas.model;

import java.util.List;

public class AlbumTracks {

	private int trackId;
	private String trackName;
	private String artist;
	private String duration;
	
	public AlbumTracks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlbumTracks(int trackId, String trackName, String artist, String duration) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
		this.artist = artist;
		this.duration = duration;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "AlbumTracks [trackId=" + trackId + ", trackName=" + trackName + ", artist=" + artist + ", duration="
				+ duration + "]\n";
	}
	
	public void tracksList(List<AlbumTracks> list) {
	
		for(int i = 0; i < list.size(); i++) {
			String str = "";
			str += "   -> ";
			str += "  Track ID: " + list.get(i).getTrackId();
			str += ", Track Name: " + list.get(i).getTrackName();
			str += ", Artist Name: " + list.get(i).getArtist();
			str += ", Track Duration: " + list.get(i).getDuration();
			
			System.out.println(str);
		}
	}
	
}
