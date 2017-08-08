package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<Usuario> todosUsuarios() {
		List<Usuario> lista = new ArrayList<>();

		// A conexão é criada dentro do try, por que ela é fechada
		// pelo mesmo.

		try (Connection c = DriverManager.getConnection
				("jdbc:postgresql://localhost/usuario", "postgres", "12345")) {

			
			
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o acesso!", e);
		}

		return lista;
	}

}
