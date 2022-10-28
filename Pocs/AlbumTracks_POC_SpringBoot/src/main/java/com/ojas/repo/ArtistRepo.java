package com.ojas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.entity.ArtistMaster;

@Repository
public interface ArtistRepo extends JpaRepository<ArtistMaster, Integer> {

	@Query("from ArtistMaster where artistName=:artistName")
	public List<ArtistMaster> getArtistIdsByName(String artistName);
}
