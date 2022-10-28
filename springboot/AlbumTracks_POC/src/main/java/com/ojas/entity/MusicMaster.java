package com.ojas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MUSICMASTER")
public class MusicMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MUSICID")
	private int musicId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="TITLEID")
	private TitleMaster titleid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ARTISTID")
	private ArtistMaster artistid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="GENREID")
	private GenreMaster genreid;
}
