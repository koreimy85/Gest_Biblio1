package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.ICatalogueMetier;
import metier.Livre;

public class ControleurServlet extends HttpServlet {
	private ICatalogueMetier metier;
	public void init()  throws ServletException{
		metier=new CatalogueMetierImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
			doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		LivreModel model =new LivreModel();
		request.setAttribute("model", model);
		String action=request.getParameter("action");
		if(action!=null){
			if(action.equals("chercher")){
				model.setMotcle(request.getParameter("motCle"));
				List<Livre> livres =metier.getLivresMc(model.getMotCle());
				model.setLivres(livres);
			}
			else if(action.equals("delete")){
				String ref=request.getParameter("ref");
				metier.SupLivre(ref);
				model.setLivres(metier.getTousLivres());
				
			}
			else if(action.equals("edite")){
				System.out.println("edite");
				String ref=request.getParameter("ref");
				Livre l=metier.getLivre(ref);
				model.setLivre(l);
				model.setMode("edit");
				model.setLivres(metier.getTousLivres());
				System.out.println("edite................");
				
			}
			else if(action.equals("save")){
				try{
					model.getLivre().setIdLivre(request.getParameter("idLivre"));
					model.getLivre().setTitre(request.getParameter("titre"));
					model.getLivre().setIsbn(request.getParameter("isbn"));
					model.getLivre().setDateEdit(request.getParameter("dateEdit"));
					model.getLivre().setNomAut(request.getParameter("nomAut"));
					model.setMode(request.getParameter("mode"));
						if(model.getMode().equals("ajout"))
							metier.AjoutLivre(model.getLivre());
						else if (model.getMode().equals("edit"))
							metier.MiseAjourLivre(model.getLivre());
					model.setLivres(metier.getTousLivres());
				}
				catch (Exception e) {
					model.setErrors(e.getMessage());
				}
			}
		}
		
		request.getRequestDispatcher("VueLivres.jsp").
		forward(request, response);
	}
	
}
