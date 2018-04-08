package metier;

import java.io.Serializable;

public class Livre implements Serializable {

	private String idLivre;
	private String titre;
	private String isbn;
	private String dateEdit;
	private String nomAut;
	public Livre(String idLivre, String titre, String isbn, String dateEdit, String nomAut) {
		super();
		this.idLivre = idLivre;
		this.titre = titre;
		this.isbn = isbn;
		this.dateEdit = dateEdit;
		this.nomAut = nomAut;
	}
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(String idLivre) {
		this.idLivre = idLivre;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDateEdit() {
		return dateEdit;
	}
	public void setDateEdit(String dateEdit) {
		this.dateEdit = dateEdit;
	}
	public String getNomAut() {
		return nomAut;
	}
	public void setNomAut(String nomAut) {
		this.nomAut = nomAut;
	}
	
	
}