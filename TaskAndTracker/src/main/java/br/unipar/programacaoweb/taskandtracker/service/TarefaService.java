package br.unipar.programacaoweb.taskandtracker.service;
import br.unipar.programacaoweb.taskandtracker.model.Tarefa;
import br.unipar.programacaoweb.taskandtracker.model.Usuario;
import br.unipar.programacaoweb.taskandtracker.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public void excluirPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    public List<Tarefa> listarPorUsuario(Usuario usuario) {
        return tarefaRepository.findByUsuario(usuario);
    }
}

