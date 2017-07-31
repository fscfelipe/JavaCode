import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		Cesta<Fruta> frutas = new Cesta<>();
		frutas.adiciona(new Fruta("Ma�a"));
		frutas.adiciona(new Fruta("Banana"));
		frutas.adiciona(new Fruta("Laranja"));
		frutas.adiciona(new Fruta("Uva"));
		
		//Propriedade Covariante
			frutas.adiciona(new FrutaVermelha("Morango"));
		
		List<FrutaVermelha> vermelhas = new ArrayList<>();
		vermelhas.add(new FrutaVermelha("Amora"));
		vermelhas.add(new FrutaVermelha("Cereja"));
		
		//Propriedade Invariante (antes de modificar a classe Cesta)
			// adicionaTodos(Collection<E> elementos)
			//Veja que, o m�todo abaixo esperava uma collection do tipo Fruta
			//mas, est� sendo passado uma collection do tipo FrutaVermelha.
			//frutas.adicionaTodos(vermelhas);
		
		//Ap�s modificar a classe Cesta, o m�todo seguinte funciona para o caso acima
			//adicionaTodos(Collection<? extends E> elementos)
			frutas.adicionaTodos(vermelhas);
		
		// Veja que a chamada abaixo apresenta um erro
			// 	frutas.adiciona("Tangerina");

		while(frutas.temItems()) {
			System.out.println(frutas.retira());
		}
		
	}

}
