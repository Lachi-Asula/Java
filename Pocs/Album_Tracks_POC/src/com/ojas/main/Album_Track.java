package com.ojas.main;

import java.util.List;

import com.ojas.model.Album;
import com.ojas.model.AlbumTracks;

public interface Album_Track {

	public String addAlbum(Album album);
	public List<String> getAlbums();
	public List<AlbumTracks> getTracks(String albumName);
	public String deleteAlbum(String albumName);
	public List<Album> sortAlbumsByName();
	public List<AlbumTracks> sortByArtist(String albumName);
	public List<AlbumTracks> sortByTrackName(String albumName);
	public void songsList();
}
