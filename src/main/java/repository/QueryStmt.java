package repository;

import java.sql.SQLException;
import java.sql.Statement;

import repository.util.ConnectionPrct3;

public class QueryStmt {

	public static void main(String[] args) {
		try {
			ConnectionPrct3.setURL("jdbc:mysql://localhost:3306/libros?user=lidiane&password=root1234");

			String codigo = "5";

			StringBuffer sb = new StringBuffer();

			/*sb.append("SELECT Autores.nombre, Libros.titulo FROM AutorLibro,Autores,Libros");
			sb.append(" WHERE ( (Autores.CodigoAutor = AutorLibro.CodAutor)");
			sb.append(" AND (Libros.CodigoLibro = AutorLibro.CodLibro)");
			sb.append(" AND (Autores.CodigoAutor = ");
			sb.append(codigo);
			sb.append("))");

			System.out.println(sb.toString());*/

			//ResultSet res = LibrosRepository.lanzarSelect(sb.toString());

			//LibrosRepository.mostrarSelect(res);

			int id = LibrosRepository.getNuevoID("Autores", "CodigoAutor");
			sb.append("Insert into Autores (CodigoAutor, Nombre, Direccion, Telefono) values (");
			sb.append(id);
			sb.append(", 'Test5', 'Sabadell', 22222222);");
			int retorno = LibrosRepository.grabarFila(sb.toString());

			LibrosRepository.grabarFila("Update Libros set Fecha = now() where CodigoLibro = 1;");
						
			
			
			
			ConnectionPrct3.desconecta();

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

	}



}
