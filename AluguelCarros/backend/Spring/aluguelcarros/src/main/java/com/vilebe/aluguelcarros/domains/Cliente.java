package com.vilebe.aluguelcarros.domains;

import java.util.Map;
import java.util.Objects;

public class Cliente {
	private int idCliente;
	private String nome;
	private String cnh;
	private String cpf;
	private String endereco;
	private int idade;
	private String cart;
	private String observacoes;
	private String email;
	private String telefone;

	public Cliente(int idCliente, String nome, String cnh, String cpf, String endereco, int idade, String cart,
			String observacoes, String email, String telefone) {

		this.idCliente = idCliente;
		this.nome = nome;
		this.cnh = cnh;
		this.cpf = cpf;
		this.endereco = endereco;
		this.idade = idade;
		this.cart = cart;
		this.observacoes = observacoes;
		this.email = email;
		this.telefone = telefone;
	}

	public Cliente(String nome, String cnh, String cpf, String endereco, String idade, String cart, String observacoes,
			String email, String telefone) {

		this.nome = nome;
		this.cnh = cnh;
		this.cpf = cpf;
		this.endereco = endereco;
		this.idade = Integer.parseInt(idade);
		this.cart = cart;
		this.observacoes = observacoes;
		this.email = email;
		this.telefone = telefone;
	}

	public Cliente(String nome, String cnh, String cpf, String endereco, int idade, String cart, String observacoes,
			String email, String telefone) {

		this.nome = nome;
		this.cnh = cnh;
		this.cpf = cpf;
		this.endereco = endereco;
		this.idade = idade;
		this.cart = cart;
		this.observacoes = observacoes;
		this.email = email;
		this.telefone = telefone;
	}

	public Cliente(String idCliente, String nome, String cnh, String cpf, String endereco, int idade, String cart,
			String observacoes, String email, String telefone) {

		this.idCliente = Integer.parseInt(idCliente);
		this.nome = nome;
		this.cnh = cnh;
		this.cpf = cpf;
		this.endereco = endereco;
		this.idade = idade;
		this.cart = cart;
		this.observacoes = observacoes;
		this.email = email;
		this.telefone = telefone;
	}

	public Cliente() {
	}

	public Cliente(String id) {
		this.idCliente = Integer.parseInt(id);
	}

	public Cliente(int id) {
		this.idCliente = id;
	}

	public Cliente(Map<String, String> args) {
		if (args.containsKey("nome")) {
			this.nome = args.get("nome");
		}
		if (args.containsKey("cnh")) {
			this.cnh = args.get("cnh");
		}
		if (args.containsKey("cpf")) {
			this.cpf = args.get("cpf");
		}
		if (args.containsKey("email")) {
			this.email = args.get("email");
		}
		if (args.containsKey("observacoes")) {
			this.observacoes = args.get("observacoes");
		}
		if (args.containsKey("cart")) {
			this.cart = args.get("cart");
		}
		if (args.containsKey("telefone")) {
			this.telefone = args.get("telefone");
		}

	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}

	@Override
	public String toString() {
		return idCliente + "\t" + nome + "\t" + cnh + "\t" + cpf + "\t" + endereco + "\t" + idade + "\t" + cart + "\t"
				+ observacoes + "\t" + email + "\t" + telefone + "\r\n";
	}

}
