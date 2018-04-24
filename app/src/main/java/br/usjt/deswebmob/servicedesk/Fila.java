package br.usjt.deswebmob.servicedesk;

import java.io.Serializable;

/**
 * 

 *
 */
public class Fila implements Serializable{

	private int id;
	private String icone;
	private String nome;


	public Fila(int id, String nome, String icone) {
		this.id = id;
		this.nome = nome;
		this.icone = icone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIcone(){return icone;	}
	public void setIcone(String i){icone = i;}
	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + "]";
	}
	
}
