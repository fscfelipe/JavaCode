package jdbc.dao;

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

	}

	@Override
	public void recuperar(String login) {
		// TODO Auto-generated method stub

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
