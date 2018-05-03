package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import repository.util.ConnectionPrct3;

public class LibrosRepository {

	public static ResultSet lanzarSelect(String select) throws SQLException {
		Statement smt = ConnectionPrct3.getConexion().createStatement();
		return smt.executeQuery(select);
	}

	public static void mostrarSelect(ResultSet res) throws SQLException {
		String nombre;
		String titulo;
		res.beforeFirst();

		while (res.next()) {
			System.out.print("\n\nAUTOR:  ");
			nombre = res.getString("Nombre").toString();
			System.out.println(nombre);
			System.out.print("TITULO:  ");
			titulo = res.getString("Titulo").toString();
			System.out.println(titulo);
			System.out.println("-----------------------");
		}
	}

	public static int getNuevoID(String tabla, String ID) throws SQLException {
		Statement smt = ConnectionPrct3.getConexion().createStatement();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT MAX(");
		sb.append(ID);
		sb.append(")");
		sb.append(" from ");
		sb.append(tabla);

		ResultSet res = smt.executeQuery(sb.toString());
		int id = 1;

		while (res.next()) {
			id += res.getInt(1);
		}

		return id;

	}

	public static int grabarFila(String orden) throws SQLException {
		Statement smt = ConnectionPrct3.getConexion().createStatement();

		return smt.executeUpdate(orden);
	}


}
