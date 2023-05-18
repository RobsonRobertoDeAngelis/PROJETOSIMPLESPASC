package ListaDeProdutos;

import java.io.Serializable;

public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Double valor;
	private Integer quantidade;
	
	public Produtos() {
	}

	public Produtos(String nome, Double valor, Integer quantidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Produtos [nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + "]";
	}
}