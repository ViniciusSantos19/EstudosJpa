package br.com.estudosJpa.entidades.muitosParaUm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_produto", length = 200, nullable = false)
	private String nome;
	
	@Column(name = "nome_preco", scale = 2, nullable = false, precision = 11)
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto() {
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	
	
}
