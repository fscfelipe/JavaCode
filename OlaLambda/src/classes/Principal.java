package classes;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		List<Produto> lista = new ArrayList<>();
		
		lista.add(new Produto("Tenis", 200)); 
		lista.add(new Produto("Camisa", 80));
		lista.add(new Produto("Short", 120));
		
		lista.forEach( p -> p.darDesconto(10));
		
		lista.forEach( p -> System.out.println(p) );

	}

}
