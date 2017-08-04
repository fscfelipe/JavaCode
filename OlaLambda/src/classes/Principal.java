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
		System.out.println("-------------");
		
		//Aqui utilizamod um carrinho para armazenar a lista de produtos
		//veja que, existe uma interface funcional chamada Condicao
		//a partir dela, aplicamos o lambda na função darDesconto
		Carrinho c = new Carrinho(lista);
		c.darDesconto(10, p -> p.getValor() > 100);
		
		c.getLista().forEach(System.out::println);

		//Caso só precisemos chamar um método sem parâmetro
		//podemos fazer da seguinte maneira
		System.out.println("-------------");
		lista.forEach( System.out::println);
		
	}

}
