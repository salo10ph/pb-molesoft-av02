package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "resultados")
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jogador;
	private int acertos;
	private int erros;
	private LocalDate dataDaPartida = LocalDate.now();
	
	public Resultado() {
		
	}
	public Resultado(String jogador, int acertos, int erros) {
		this.jogador = jogador;
		this.acertos = acertos;
		this.erros = erros;
	}

	public String getJogador() {
		return jogador;
	}

	public int getAcertos() {
		return acertos;
	}

	public LocalDate getDataDaPartida() {
		return dataDaPartida;
	}
	
}
