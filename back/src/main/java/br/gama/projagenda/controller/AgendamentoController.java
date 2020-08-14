package br.gama.projagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gama.projagenda.dao.AgendamentoDAO;
import br.gama.projagenda.model.Agendamento;

@RestController
@CrossOrigin("*")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoDAO dao;

    @PostMapping("/agendamento/novo") /* verificar input da data */
    public ResponseEntity<Agendamento> inserirProduto(@RequestBody Agendamento agendamento) {
        dao.save(agendamento);
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/agendamento/listarTodos")
    public List<Agendamento> getAgendamentos(){
        List<Agendamento> lista = (List<Agendamento>)dao.findAll();
        return  lista;
    }

    @GetMapping("/agendamento/cliente/{nome}")
    public List<Agendamento> getNome(@PathVariable String nome){
        List<Agendamento> lista = (List<Agendamento>)dao.findByNome(nome);
        return  lista;
    }

    @GetMapping("/agendamento/agencia/{id}")
    public List<Agendamento> getAgenciaId(@PathVariable int id){
        List<Agendamento> lista = (List<Agendamento>) dao.findByAgenciaId(id);
        return  lista;
    }

    /*falta listar por data */
    @PostMapping("/agendamento/nomeAgencia") 
    public  List<Agendamento> procurarAgenciaNome(@RequestBody Agendamento inputAgenda) 
    {
       List<Agendamento> lista = dao.findbyAgenciaIdAndNome(inputAgenda.getNumSeq(), inputAgenda.getNome());   
        
      return lista;
    }
}