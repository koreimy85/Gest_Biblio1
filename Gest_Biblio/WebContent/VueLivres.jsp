<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion de la Bibliothèque</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">
function confirmer(url){
	var rep=confirm("Etes-vous sûre de vouloir supprimer?");
	if(rep==true){
		document.location=url;
	}
}
</script>
</head>
<body>
<div style="text-align: center">
<h1>GBibliothème XX</h1>
<h1>Gestion des livres</h1>
   <img src="http://Gest_Biblio/css/wiki-textbook.png" width="129" />
</div>

<div>
	<form action="controleur.php" method="post">
		<table>
			<tr>
				<td>Mot Clé</td>
				<td><input type="text" name="motCle" value="${model.motCle }"/></td>
				<td><input type="submit" value="chercher" name="action"/></td>
			</tr>
		</table>
	</form>
</div>
<div>
	<form action="controleur.php" method="post">
	<input type="hidden" value="${model.mode }" name="mode">
		<table>
		<c:if test="${model.mode=='ajout' }">
		<tr>
				<td>REF</td>
				<td><input type="text" name="idLivre" value="${model.livre.idLivre }"/></td>
				<td></td>
			</tr>
		</c:if>
			<c:if test="${model.mode=='edit' }">
		<tr>
				<td>REF</td>
				<td>${model.livre.idLivre}<input type="hidden" name="idLivre" value="${model.livre.idLivre }"/></td>
				<td></td>
			</tr>
		</c:if>
			<tr>
				<td>Titre</td>
				<td><input type="text" name="titre" value="${model.livre.titre }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>ISBN</td>
				<td><input type="text" name="isbn" value="${model.livre.isbn }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>Date édition</td>
				<td><input type="text" name="dateEdit" value="${model.livre.dateEdit }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>Nom de l'auteur</td>
				<td><input type="text" name="nomAut" value="${model.livre.nomAut }"/></td>
				<td></td>
			</tr>
			<td><input type="submit" name="action" value="save"></td>
		</table>
	</form>
</div>
<div>
	${model.errors}
</div>
<div>
	<table class="table1">
		<tr>
			<th>REFERENCE</th><th>TITRE</th><th>ISBN</th><th>DATE EDITION</th><th>NOM AUTEUR</th>
		</tr>
		<c:forEach items="${model.livres}" var="l">
			<tr>
				<td>${l.idLivre}</td>
				<td>${l.titre}</td>
				<td>${l.isbn}</td>
				<td>${l.dateEdit}</td>
				<td>${l.nomAut}</td>
				<td><a href="javascript:confirmer('controleur.php?action=delete&ref=${l.idLivre}')">Supprimer</a></td>
				<td><a href="controleur.php?action=edite&ref=${l.idLivre}">Modifier</a></td>
			</tr>
		</c:forEach>
		<tr>
	</table>
</div>
</body>
</html>