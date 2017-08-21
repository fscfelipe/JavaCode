package jdbc.dao;

import java.util.List;

import jdbc.model.Usuario;

public interface UsuarioDAO {
	
	//insere um novo usuário no banco de dados
	public void inserir(Usuario u);
	
	//recupera usuário pelo seu login
	public void recuperar(String login);
	
	//adiciona pontos para o usuário no banco
	public void adicionarPontos(String login, int pontos);

	//retorna a lista de usuários ordenada por pontos
	public List<Usuario> ranking();
}
