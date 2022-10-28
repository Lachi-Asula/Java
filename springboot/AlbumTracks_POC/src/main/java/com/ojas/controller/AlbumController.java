package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.AlbumTypeMaster;
import com.ojas.entity.MusicMaster;
import com.ojas.service.AlbumService;

@RestController
public class AlbumController {

	@Autowired
	private AlbumService albumServ;
	
	@PostMapping("/saveAlbum")
	public String saveAlbum(@RequestBody AlbumTypeMaster album) {
		
		return albumServ.saveAlbum(album);
	}
	
	@GetMapping("/albumWithSongsList")
	public List<AlbumTypeMaster> getAlbumsList(){
		
		return albumServ.getAlbumsList();
	}
	
	@GetMapping("/getAlbums")
	public List<String> getAlbumNames(){
		
		return albumServ.getAlbums();
	}

	@GetMapping("/getAllTracks")
	public List<MusicMaster> getAllTracks(){
		
		return albumServ.getAllTracks();
	}
	
	@GetMapping("/getTracks/{albumName}")
	public AlbumTypeMaster getTracksByAlbumName(@PathVariable String albumName){
		
		return albumServ.getAlbumTracks(albumName);
	}
	
	@GetMapping("/getSongs/{artistName}")
	public List<MusicMaster> getTracksByArtist(@PathVariable String artistName){
		return albumServ.getTracksByArtistName(artistName);
	}
	
	@GetMapping("/getAlbumsByYear")
	public List<AlbumTypeMaster> getAlbumsByYear(){
		
		return albumServ.getAlbumsByYear();
	}
	
	@GetMapping("/getTracksByGenre/{genreName}")
	public List<MusicMaster> getTracksByGenre(@PathVariable String genreName){
		
		return albumServ.getTracksByGenre(genreName);
	}
	
	@DeleteMapping("/deleteAlbum/{albumName}")
	public String deleteAlbumByName(@PathVariable String albumName) {
		
		return albumServ.deleteAlbum(albumName);
	}
	
	@PutMapping("/updateAlbum/{albumName}")
	public String updateAlbum(@PathVariable String albumName, @RequestBody List<MusicMaster> tracks) {
		
		return albumServ.updateAlbum(albumName, tracks);
	}
}
