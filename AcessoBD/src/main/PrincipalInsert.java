package main;

import model.Usuario;
import model.UsuarioDAO;

public class PrincipalInsert {

	public static void main(String[] args) {

		Usuario u = new Usuario();
		u.setLogin("teste");
		u.setNome("Testador testando o teste");
		u.setEmail("testador@teste.com.br");
		
		UsuarioDAO.inserirUsuario(u);

	}

}
