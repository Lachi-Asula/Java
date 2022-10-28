package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.entity.ArtistMaster;
import com.ojas.entity.GenreMaster;
import com.ojas.entity.MusicMaster;

@Repository
public interface MusicRepo extends JpaRepository<MusicMaster, Integer> {

	@Query("from MusicMaster where artistid=:artistid")
	public MusicMaster findByArtistid(ArtistMaster artistid);
	
	@Query("from MusicMaster where genreid=:genreId")
	public MusicMaster fingByGenreid(GenreMaster genreId);
}
