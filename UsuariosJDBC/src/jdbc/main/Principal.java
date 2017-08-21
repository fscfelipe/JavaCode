package jdbc.main;

import java.util.List;

import jdbc.dao.UsuarioNoBancoDAO;
import jdbc.model.Usuario;

public class Principal {

	public static void main(String[] args) {

		UsuarioNoBancoDAO udao = new UsuarioNoBancoDAO();
		
		/*Usuario u = new Usuario();
		u.setLogin("marina");
		u.setEmail("marina@rmail.com");
		u.setNome("Marina rina");
		u.setSenha("rina");
		u.setPontos(30);*/
		
		List<Usuario> lista = udao.ranking();
		
		for(Usuario u:lista) {
			System.out.println("Nome : " + u.getNome() + " pontos: " + u.getPontos());
		}
		
		
	}

}
