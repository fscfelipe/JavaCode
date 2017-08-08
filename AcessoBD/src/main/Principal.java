package main;

import java.util.List;

import model.Usuario;
import model.UsuarioDAO;

public class Principal {

	public static void main(String[] args) {
		List<Usuario> lista = UsuarioDAO.todosUsuarios();
		
		lista.forEach(System.out::println);
		
	}

}
