package com.ojas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.AlbumTypeMaster;
import com.ojas.entity.ArtistMaster;
import com.ojas.entity.GenreMaster;
import com.ojas.entity.MusicMaster;
import com.ojas.exception.AlbumNotFoundException;
import com.ojas.repo.AlbumRepo;
import com.ojas.repo.ArtistRepo;
import com.ojas.repo.GenreRepo;
import com.ojas.repo.MusicRepo;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepo albumRepo;
	
	@Autowired
	private ArtistRepo artistRepo;
	
	@Autowired
	private MusicRepo musicRepo;
	
	@Autowired
	private GenreRepo genreRepo;
	
	public String saveAlbum(AlbumTypeMaster album) {
		albumRepo.save(album);
		
		return "Album Added Successfully";
	}
	
	public List<String> getAlbums(){
		
		return albumRepo.getAlbums();
	}
	
	public List<AlbumTypeMaster> getAlbumsList(){
		
		return albumRepo.findAll();
	}
	
	public List<MusicMaster> getAllTracks(){
		
		return albumRepo.getAllTracks();
	}
	
	public AlbumTypeMaster getAlbumTracks(String albumName) {
		
		AlbumTypeMaster album =  albumRepo.findByAlbumName(albumName);
		
		if(album == null) {
			throw new AlbumNotFoundException("Album Not Existed");
		}
		
		return album;
	}
	
	public List<MusicMaster> getTracksByArtistName(String name){
		List<ArtistMaster> artistId = artistRepo.getArtistIdsByName(name);
		
		if(artistId.size() == 0) {
			throw new AlbumNotFoundException("Artist Name Not Existed");
		}
		
		List<MusicMaster> tracks = new ArrayList<>();
		
		for(ArtistMaster i : artistId) {
			tracks.add(musicRepo.findByArtistid(i));
		}
		
		return tracks;
	}
	
	public List<AlbumTypeMaster> getAlbumsByYear(){
		
		return albumRepo.getAlbumsByYear();
	}
	
	public List<MusicMaster> getTracksByGenre(String name){
		
		List<GenreMaster> li = genreRepo.getGenreByName(name);
		
		if(li.size() == 0) {
			throw new AlbumNotFoundException("Genre Not Existed");
		}
		
		List<MusicMaster> tracks = new ArrayList<>();
		
		for(GenreMaster gm : li) {
			tracks.add(musicRepo.fingByGenreid(gm));
		}
		
		return tracks;
	}
	
	public String deleteAlbum(String albumName) {
		try {
			int id = albumRepo.getByalbumName(albumName);
			albumRepo.deleteById(id);
		}
		catch(Exception e) {
			throw new AlbumNotFoundException("Album Not Found");
		}
		
		return "Album Deleted Successfullly";
	}
	
	public String updateAlbum(String albumName, List<MusicMaster> tracks) {
		AlbumTypeMaster album = albumRepo.findByAlbumName(albumName);
		
		if(album == null) {
			throw new AlbumNotFoundException("Album Not Existed");
		}
		
		for(MusicMaster mm : tracks) {
			album.getTracks().add(mm);
		}
		
		albumRepo.save(album);
		
		return "Album Updated Successfully";
		
	}
}
