package br.gama.projagenda.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gama.projagenda.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {
    public List<Agendamento> findByAgenciaId(int id); 
    public List<Agendamento> findByDataAgendamento(LocalDate data);
    public List<Agendamento> findByNome(String nome);

   public List<Agendamento> findbyAgenciaIdAndNome(int id, String nome);

}