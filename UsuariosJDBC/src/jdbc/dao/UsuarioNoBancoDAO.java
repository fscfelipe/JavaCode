package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.model.Usuario;

public class UsuarioNoBancoDAO implements UsuarioDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inserir(Usuario u) {

		try (Connection conn = DriverManager.getConnection
				("jdbc:postgresql://localhost/coursera", "postgres","12345")) {

			String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) " + "	  VALUES(?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getNome());
			stmt.setString(4, u.getSenha());
			stmt.setInt(5, u.getPontos());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o acesso !", e);
		}

	}

	@Override
	public Usuario recuperar(String login) {

		try (Connection conn = DriverManager.getConnection
				("jdbc:postgresql://localhost/coursera", "postgres","12345")) {

			String sql = "SELECT * FROM usuario WHERE login=?; ";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login);

			ResultSet rs = stmt.executeQuery();

			Usuario retornado = new Usuario();
			while (rs.next()) {
				retornado.setEmail(rs.getString("email"));
				retornado.setLogin(rs.getString("login"));
				retornado.setNome(rs.getString("nome"));
				retornado.setSenha(rs.getString("senha"));
				retornado.setPontos(rs.getInt("pontos"));
			}
			
			return retornado;

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o acesso !", e);

		}

		
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> ranking() {
		// TODO Auto-generated method stub
		return null;
	}

}
