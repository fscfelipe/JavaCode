
public class Principal {

	public static void main(String[] args) {
		Cesta<Fruta> frutas = new Cesta<>();
		frutas.adiciona(new Fruta("Maça"));
		frutas.adiciona(new Fruta("Banana"));
		frutas.adiciona(new Fruta("Laranja"));
		frutas.adiciona(new Fruta("Uva"));
		
		// Veja que a chamada abaixo apresenta um erro
		// 	frutas.adiciona("Tangerina");

		while(frutas.temItems()) {
			System.out.println(frutas.retira());
		}
		
	}

}
