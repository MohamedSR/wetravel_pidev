package Entities;
/**
*
* @author T.adel
*/
public class Hotel {

	private int id;
	private String name;
	private int stars;

	@Override
	public String toString() {
		return "vous etes les bienvenue à notre Hotel Numero "+ id +
				"dans le monde, c'est l'hotel stars " + capacity +" le " + name +
				", on a une capacity de " + stars +"personnes"+
				",visité nous à l'adresse " + adresse +
				",à " + ville +
				",dans notre cher pays " + pays;

	}

	private int capacity;
	private String adresse;
	private String ville;
	private String pays;
	private String image;

	public Hotel() {}

	public Hotel(String name, int stars, int capacity, String adresse, String ville, String pays,String image) {
		this.name = name;
		this.stars = stars;
		this.capacity = capacity;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.image = image;
	}
	public Hotel(String name, int stars, int capacity, String adresse, String ville, String pays) {
		this.name = name;
		this.stars = stars;
		this.capacity = capacity;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
	}
	public Hotel(int id,String name, int stars, int capacity, String adresse, String ville, String pays,String image) {
		this.id = id;
		this.name = name;
		this.stars = stars;
		this.capacity = capacity;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.image = image;
	}
	public Hotel(int id, String name, int stars, int capacity, String adresse, String ville, String pays) {
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
