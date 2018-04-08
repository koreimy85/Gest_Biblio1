package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CatalogueMetierImpl implements ICatalogueMetier {
	@Override
	public void AjoutLivre(Livre l) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("insert into livres(idlivre,titre,isbn,datedit,nomaut) values(?,?,?,?,?)");
			ps.setString(1, l.getIdLivre());
			ps.setString(2, l.getTitre());
			ps.setString(3, l.getIsbn());
			ps.setString(4, l.getDateEdit());
			ps.setString(5, l.getNomAut());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//livres.put(l.getIdLivre(), l);
		
	}

	@Override
	public void MiseAjourLivre(Livre l) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("update  livres set titre=?, isbn=?, datedit=?, nomaut=? where idlivre=?");
			
			
			ps.setString(1, l.getTitre());
			ps.setString(2, l.getIsbn());
			ps.setString(3, l.getDateEdit());
			ps.setString(4, l.getNomAut());
			ps.setString(5, l.getIdLivre());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		

	@Override
	public void SupLivre(String ref) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("delete  from livres  where idlivre=?");
			
			ps.setString(1, ref);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Livre> getTousLivres() {
		List<Livre> livs=new ArrayList<Livre>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("select * from livres");
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Livre l=new Livre();
				l.setIdLivre(rs.getString("idlivre"));
				l.setTitre(rs.getString("titre"));
				l.setIsbn(rs.getString("isbn"));
				l.setDateEdit(rs.getString("datedit"));
				l.setNomAut(rs.getString("nomaut"));
				livs.add(l);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livs;
	}

	@Override
	public List<Livre> getLivresMc(String mc) {
		List<Livre> livs=new ArrayList<Livre>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("select * from livres where titre like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Livre l=new Livre();
				l.setIdLivre(rs.getString("idlivre"));
				l.setTitre(rs.getString("titre"));
				l.setIsbn(rs.getString("isbn"));
				l.setDateEdit(rs.getString("datedit"));
				l.setNomAut(rs.getString("nomaut"));
				
				livs.add(l);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livs;
	}

	@Override
	public Livre getLivre(String ref) {
		Livre l=null;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("select * from livres where idlivre = ?");
			ps.setString(1, ref);
			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				l=new Livre();
				l.setIdLivre(rs.getString("idlivre"));
				l.setTitre(rs.getString("titre"));
				l.setIsbn(rs.getString("isbn"));
				l.setDateEdit(rs.getString("datedit"));
				l.setNomAut(rs.getString("nomaut"));
				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(l==null)throw new RuntimeException("livre"+" " +ref+" "+"introuvable");
		return l;
	}

		
	
}
