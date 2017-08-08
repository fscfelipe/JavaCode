package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				("jdbc:postgresql://localhost/usuarios", "postgres", "12345")) {

			String sql = "SELECT login, nome, email FROM usuario";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setLogin(rs.getString("login"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				
				lista.add(u);
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o acesso!", e);
		}

		return lista;
	}

}
