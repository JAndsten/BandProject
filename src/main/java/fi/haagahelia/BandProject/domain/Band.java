package fi.haagahelia.BandProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Band {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
    private String genre;
    private String year;
    private int stars;
    
    public Band() {}

	public Band(String name, String genre, String year, int stars) {
		super();
		this.name = name;
		this.genre = genre;
		this.year = year;
		this.stars = stars;
	}
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
}