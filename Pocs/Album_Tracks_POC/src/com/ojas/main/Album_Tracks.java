package com.ojas.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ojas.exception.AlbumNotFoundException;
import com.ojas.model.Album;
import com.ojas.model.AlbumTracks;

public class Album_Tracks implements Album_Track{

	static List<Album> albumList = new ArrayList<>();
	public void menu() {
		String str = "\n--------------Album_Tracks Menu Application------------\n";
		str += "1. Add Album with Tracks\n";
		str += "2. Show AlbumNames List\n";
		str += "3. Show Tracks in Album\n";
		str += "4. Delete Album\n";
		str += "5. Sorting Albums By AlbumName\n";
		str += "6. Sorting Tracks By Artist Name\n";
		str += "7. Sorting Tracks By TrackName\n";
		str += "8. SongsList\n";
		str += "9. exit\n";
		str += "Select any Option\n";
		
		System.out.println(str);
	}

	@Override
	public String addAlbum(Album album) {
		albumList.add(album);
		
		return "Album Added Successfully";
	}

	@Override
	public List<String> getAlbums() {
		if(albumList.size() == 0) {
			throw new AlbumNotFoundException("Album List is Empty");
		}
		return albumList.stream().map(x-> x.getMovieName()).collect(Collectors.toList());
	}

	@Override
	public List<AlbumTracks> getTracks(String albumName) {
		List<AlbumTracks> li = null;
		boolean b = true;
		
		for(Album al : albumList) {
			if(al.getMovieName().equalsIgnoreCase(albumName)) {
				li = al.getTracks();
				b = false;
			}
		}
		
		if(b) {
			throw new AlbumNotFoundException("Album Not Existed");
		}
		return li;
	}

	@Override
	public String deleteAlbum(String albumName) {
		for(int i = 0; i < albumList.size(); i++) {
			if(albumList.get(i).getMovieName().equalsIgnoreCase(albumName)) {
				albumList.remove(i);
			}
		}
		
		return "Album Deleted Successfully";
	}

	@Override
	public List<Album> sortAlbumsByName() {
		List<Album> li = albumList;
		try {
			li = li.stream().sorted(Comparator.comparing(Album::getMovieName)).collect(Collectors.toList());
		}
		catch(Exception e) {
			throw new AlbumNotFoundException("Album List is Empty");
		}
		
		return li;
	}

	@Override
	public List<AlbumTracks> sortByArtist(String albumName) {
		List<AlbumTracks> li = getTracks(albumName);
		
		try {
			li = li.stream().sorted(Comparator.comparing(AlbumTracks::getArtist)).collect(Collectors.toList());
		}
		catch(Exception e) {
			throw new AlbumNotFoundException("Album Not Existed");
		}
		
		return li;
	}

	@Override
	public List<AlbumTracks> sortByTrackName(String albumName) {
		List<AlbumTracks> li = getTracks(albumName);
		
		try {
			li = li.stream().sorted(Comparator.comparing(AlbumTracks::getTrackName)).collect(Collectors.toList());
		}
		catch(Exception e) {
			throw new AlbumNotFoundException("Album Not Existed");
		}
		
		return li;
	}

	@Override
	public void songsList() {
		List<Album> li = albumList;
		AlbumTracks at = new AlbumTracks();
		
		try {
			li.stream().forEach(x -> at.tracksList(x.getTracks()));
		}
		catch(Exception e) {
			throw new AlbumNotFoundException("Album List is Empty");
		}
	
	}
	
}
