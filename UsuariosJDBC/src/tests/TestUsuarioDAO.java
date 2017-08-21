package tests;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import jdbc.dao.UsuarioNoBancoDAO;
import jdbc.model.Usuario;

public class TestUsuarioDAO {
	JdbcDatabaseTester jdt;
	UsuarioNoBancoDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new UsuarioNoBancoDAO();
		
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", 
				"jdbc:postgresql://localhost/coursera", "postgres", "12345");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void testInserir() throws Exception {
		
		Usuario u = new Usuario();
		u.setEmail("line@email.com");
		u.setLogin("lalalin");
		u.setSenha("123");
		u.setNome("Aline line");
		u.setPontos(55);
		
		dao.inserir(u);
		
		IDataSet currentDataSet = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("USUARIO");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataset.getTable("USUARIO");
		
		
		Assertion.assertEquals(expectedTable, currentTable);
		
		
	}
	
	@Test
	public void testRecuperar() {
		Usuario u = dao.recuperar("felipelogin");
		
		assertEquals(u.getLogin(), "felipelogin");
		assertEquals(u.getNome(), "Felipe nome");
		assertEquals(u.getEmail(), "felipe@email.com");
	}
	
	@Test
	public void testAdicionarPontos() {
		// valor inicial dos pontos em 20
		Usuario u = dao.recuperar("felipelogin");
		assertEquals( 20 , u.getPontos() );
		
		//Adiciono pontos
		dao.adicionarPontos("felipelogin", 50);
		
		//Recupero o usuário novamente atualizado
		Usuario urec = dao.recuperar("felipelogin");
		assertEquals( 70 , urec.getPontos() );
		
	}
	
	@Test
	public void testRanking() {
		List<Usuario> lista = dao.ranking();
		
		//Verificamos que o tamanho da lista está correto
		assertEquals(2, lista.size());
		
		assertEquals("marina", lista.get(0).getLogin());
		assertEquals("felipelogin", lista.get(1).getLogin());
	}

}
