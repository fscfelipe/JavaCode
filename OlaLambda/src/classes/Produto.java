package classes;

public class Produto {
	
	private String nome;
	private double valor;
	
	public Produto(String nome, int valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double d) {
		this.valor = d;
	}
	
	public void darDesconto( double porcentagem ) {
		if(porcentagem > 0)
		  valor = valor * ( (100 - porcentagem) / 100 );
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", valor=" + valor + "]";
	}
	
	
	

}
