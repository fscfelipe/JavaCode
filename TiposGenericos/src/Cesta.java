import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cesta<E> {

	private List<E> lista = new ArrayList<>();
	
	public void adiciona(E elemento) {
		lista.add(elemento);
	}
	
	public E retira() {
		Random r = new Random(System.currentTimeMillis());
		return lista.remove(r.nextInt(lista.size()));
	}
	
	public boolean temItems() {
		return !lista.isEmpty();
	}
	
}
