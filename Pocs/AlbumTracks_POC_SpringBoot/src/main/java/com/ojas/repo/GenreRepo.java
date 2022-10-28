package com.ojas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.entity.GenreMaster;

@Repository
public interface GenreRepo extends JpaRepository<GenreMaster, Integer> {

	@Query("from GenreMaster where genreName=:name")
	public List<GenreMaster> getGenreByName(String name);
}
