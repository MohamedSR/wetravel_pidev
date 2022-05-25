package Entities;

public class hotels {

	private int id;
	private String name;
	private int stars;
	private int capacity;
	private String adresse;
	private String ville;
	private String pays;
	
	public hotels() {
		super();
	}

	public hotels(String name, int stars, int capacity, String adresse, String ville, String pays) {
		super();
		this.name = name;
		this.stars = stars;
		this.capacity = capacity;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
	}

	public hotels(int id, String name, int stars, int capacity, String adresse, String ville, String pays) {
		super();
		this.id = id;
		this.name = name;
		this.stars = stars;
		this.capacity = capacity;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
}
