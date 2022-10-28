package com.ojas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ALBUMTYPEMASTER")
public class AlbumTypeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ALBUMID")
	private int albumId;
	
	@Column(name="ALBUMNAME")
	private String albumName;
	
	@Column(name="YEAR")
	private int year;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ALBUMID", referencedColumnName = "ALBUMID")
	private List<MusicMaster> tracks;
}
