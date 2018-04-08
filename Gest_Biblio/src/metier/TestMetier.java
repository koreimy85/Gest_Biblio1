package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		ICatalogueMetier metier= new CatalogueMetierImpl();
		//metier.AjoutLivre(new Livre("REF10","AAA","ISBN10","12/02/2014","Vin"));
		//metier.AjoutLivre(new Livre("REF11","CCC","ISBN11","12/02/1914","ERE"));
			//metier.getTousLivres();
		System.out.println("--------------------------------------");
		List<Livre> liv1 =metier.getTousLivres();
		for(Livre l:liv1){
			System.out.println(l.getTitre());
		}
		System.out.println("-------------MC-------------------------");
		List<Livre> liv =metier.getLivresMc("AA");
		for(Livre l:liv){
			System.out.println(l.getTitre());
		}
		
		System.out.println("--------------------------------------");
		try{
		Livre liv2 =metier.getLivre("REF01");
			System.out.println(liv2.getTitre());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("--------------------------------------");
		try{
		Livre l =metier.getLivre("REF01");
		l.setNomAut("X");
		l.setTitre("Maths");
		l.setIsbn("isb65");
		metier.MiseAjourLivre(l);
		Livre l2 =metier.getLivre("REF01");
			System.out.println(l2.getTitre());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("--------------------------------------");
		try{
			metier.SupLivre("N16");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
		
	}

}
