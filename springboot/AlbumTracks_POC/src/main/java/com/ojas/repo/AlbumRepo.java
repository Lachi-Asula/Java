package com.ojas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.entity.AlbumTypeMaster;
import com.ojas.entity.MusicMaster;

@Repository
public interface AlbumRepo extends JpaRepository<AlbumTypeMaster, Integer> {

	public AlbumTypeMaster findByAlbumName(String albumname);
	
	@Query("select tracks from AlbumTypeMaster")
	public List<MusicMaster> getAllTracks();
	
	@Query("select albumName from AlbumTypeMaster")
	public List<String> getAlbums();
	
	@Query("from AlbumTypeMaster order by year")
	public List<AlbumTypeMaster> getAlbumsByYear();
	
	@Query("select albumId from AlbumTypeMaster where albumName=:name")
	public int getByalbumName(String name);
}
