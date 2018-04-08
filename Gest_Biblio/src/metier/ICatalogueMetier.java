package metier;

import java.util.List;

public interface ICatalogueMetier {
	public void AjoutLivre (Livre l);
	public void MiseAjourLivre (Livre l);
	public void SupLivre (String ref);
	public List<Livre> getTousLivres ();
	public List<Livre> getLivresMc(String mc);
	public Livre getLivre(String ref);
}
