package jdbc.dao;

import java.util.List;

import jdbc.model.Usuario;

public interface UsuarioDAO {
	
	//insere um novo usu�rio no banco de dados
	public void inserir(Usuario u);
	
	//recupera usu�rio pelo seu login
	public void recuperar(String login);
	
	//adiciona pontos para o usu�rio no banco
	public void adicionarPontos(String login, int pontos);

	//retorna a lista de usu�rios ordenada por pontos
	public List<Usuario> ranking();
}
