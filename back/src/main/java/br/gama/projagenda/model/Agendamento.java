package br.gama.projagenda.model;

import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn032_agendamento")
public class Agendamento {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_seq")
    private int numSeq;
    
    @Column(name="nome_cli", length=100, nullable=false)
    private String nome;
    
    @Column(name="email_cli", length=100)
    private String email;
    
    @Column(name="celular_cli", length=20)
    private String celular;
    
	@Column(name="data_agendamento")
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAgendamento;
    
    @Column(name="hora_agendamento")
    private LocalTime horaAgendamento;
    
    @Column(name="observacao", length=255)
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "id_agencia")
    @JsonIgnoreProperties("agendamentos")
    private Agencia agencia;

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalTime getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(LocalTime horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	
    
}