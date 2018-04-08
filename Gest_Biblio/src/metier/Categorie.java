package metier;

public class Categorie {
	private long reference;
	private String désignation;
	
	
	public Categorie(long reference, String désignation) {
		super();
		this.reference = reference;
		this.désignation = désignation;
	}


	public long getReference() {
		return reference;
	}


	public void setReference(long reference) {
		this.reference = reference;
	}


	public String getDésignation() {
		return désignation;
	}


	public void setDésignation(String désignation) {
		this.désignation = désignation;
	}


	public Categorie() {
		super();
	}
	
	
}
