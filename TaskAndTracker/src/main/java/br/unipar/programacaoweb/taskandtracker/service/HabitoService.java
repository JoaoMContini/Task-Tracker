package br.unipar.programacaoweb.taskandtracker.service;
import br.unipar.programacaoweb.taskandtracker.model.Habito;
import br.unipar.programacaoweb.taskandtracker.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HabitoService {

    @Autowired
    private HabitoRepository habitoRepository;

    public List<Habito> listarTodos() {
        return habitoRepository.findAll();
    }

    public Habito salvar(Habito habito) {
        return habitoRepository.save(habito);
    }

    public Optional<Habito> buscarPorId(Long id) {
        return habitoRepository.findById(id);
    }

    public void excluirPorId(Long id) {
        habitoRepository.deleteById(id);
    }
}
