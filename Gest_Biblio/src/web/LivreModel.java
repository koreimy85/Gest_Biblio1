package web;
import metier.Livre;
import java.util.ArrayList;
import java.util.List;

public class LivreModel {
	private String motCle;
	private Livre livre=new Livre();
	private List<Livre> livres =new ArrayList<Livre>();
	private String errors;
	private String mode="ajout";
	
public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
public String getMotCle(){
	return motCle;
}
public Livre getLivre() {
	return livre;
}
public void setLivre(Livre livre) {
	this.livre = livre;
}
public void setMotCle(String motCle) {
	this.motCle = motCle;
}
public void setMotcle(String motcle) {
	this.motCle = motcle;
}
public void setLivres(List<Livre> livres) {
	this.livres = livres;
}
public String getMotcle() {
	return motCle;
}
public List<Livre> getLivres() {
	return livres;
}


}
