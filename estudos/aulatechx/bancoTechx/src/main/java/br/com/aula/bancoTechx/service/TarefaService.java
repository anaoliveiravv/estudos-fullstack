package br.com.aula.bancoTechx.service;

import br.com.aula.bancoTechx.model.Tarefa;
import br.com.aula.bancoTechx.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TarefaService {

    @Autowired
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> getAll(){
        return tarefaRepository.findAll();
    }

    public Tarefa create(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public void delete(Long id){
        tarefaRepository.deleteById(id);
    }
}