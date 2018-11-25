package fi.haagahelia.BandProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long aId;
    private String aArtist;
	private String aName;
	private String aYear;
    private int aTracks;
    private int aStars;
    
    public Album() {}
        
    public Album(String aArtist, String aName, String aYear, int aTracks, int aStars) {
		super();
		this.aArtist = aArtist;
		this.aName = aName;
		this.aYear = aYear;
		this.aTracks = aTracks;
		this.aStars = aStars;
	}

	public Long getaId() {
		return aId;
	}
	public void setaId(Long aId) {
		this.aId = aId;
	}
	public String getaArtist() {
		return aArtist;
	}
	public void setaArtist(String aArtist) {
		this.aArtist = aArtist;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaYear() {
		return aYear;
	}
	public void setaYear(String aYear) {
		this.aYear = aYear;
	}
	public int getaTracks() {
		return aTracks;
	}
	public void setaTracks(int aTracks) {
		this.aTracks = aTracks;
	}
	public int getaStars() {
		return aStars;
	}
	public void setaStars(int aStars) {
		this.aStars = aStars;
	}

}