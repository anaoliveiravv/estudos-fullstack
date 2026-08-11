package br.com.aula.bancoTechx.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.aula.bancoTechx.model.Tarefa;
import br.com.aula.bancoTechx.service.TarefaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/create")
    public Tarefa createTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.create(tarefa);
    }

    @GetMapping
    public List<Tarefa> listTarefa() {
        return tarefaService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tarefaService.delete(id);
    }
}
