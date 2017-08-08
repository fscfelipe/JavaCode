package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import model.Usuario;
import model.UsuarioDAO;

public class TesteUsuarioDAO {

	JdbcDatabaseTester jdt;
	
	
	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", 
				"jdbc:postgresql://localhost/usuarios", "postgres", "12345");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
	
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}

	@Test
	public void testRecuperaTodos() {
		List<Usuario> lista = UsuarioDAO.todosUsuarios();
		assertEquals(2, lista.size());
		assertEquals("joao", lista.get(0).getLogin());
	}
	
	@Test
	public void testInsereNovo() throws Exception {
		Usuario u = new Usuario();
		u.setLogin("duda");
		u.setNome("Maria Eduarda");
		u.setEmail("duda@email.com.br");
		
		UsuarioDAO.inserirUsuario(u);
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("USUARIO");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataset.getTable("USUARIO");
		
		Assertion.assertEquals(expectedTable, currentTable);

	}

}
