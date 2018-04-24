package br.usjt.deswebmob.servicedesk;

import java.io.Serializable;
import java.util.Date;

public class Chamado implements Serializable{
	private int numero;
	
	private Date dataAbertura;
	
	private Date dataFechamento;
	
	private String status;
	
	private String descricao;
	
	private Fila fila;
	
	
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";

	public Chamado(int numero, Date dataAbertura, Date dataFechamento, String status, String descricao, Fila fila) {
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.status = status;
		this.descricao = descricao;
		this.fila = fila;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getTempoDias(){
		//getTime e currentTimeMillis retornam o tempo em milisegundos
		//dividir por 1000 * 60 * 60 * 24 converte para dias
		int dias;
		if(dataFechamento == null){
			//considera o momento atual para calcular o tempo aberto
			dias =  (int)(System.currentTimeMillis() - dataAbertura.getTime())/(1000 * 60 * 60 * 24);
		} else {
			//considera a data de fechamento para calcular o tempo aberto
			dias = (int)(dataFechamento.getTime() - dataAbertura.getTime())/(1000 * 60 * 60 * 24);
		}
		return dias;
	}
	
	@Override
	public String toString() {
		return "Chamado [numero=" + numero + ", dataAbertura=" + dataAbertura
				+ ", dataFechamento=" + dataFechamento + ", status=" + status
				+ ", descricao=" + descricao + ", fila=" + fila + "]";
	}


	public String getFigura() {
		return ""+fila.getIcone();
	}
}
