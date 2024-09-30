package br.unipar.programacaoweb.taskandtracker.service;
import br.unipar.programacaoweb.taskandtracker.model.HabitoHistorico;
import br.unipar.programacaoweb.taskandtracker.repository.HabitoHistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HabitoHistoricoService {

    @Autowired
    private HabitoHistoricoRepository habitoHistoricoRepository;

    public List<HabitoHistorico> listarTodos() {
        return habitoHistoricoRepository.findAll();
    }

    public HabitoHistorico salvar(HabitoHistorico habitoHistorico) {
        return habitoHistoricoRepository.save(habitoHistorico);
    }

    public Optional<HabitoHistorico> buscarPorId(Long id) {
        return habitoHistoricoRepository.findById(id);
    }

    public void excluirPorId(Long id) {
        habitoHistoricoRepository.deleteById(id);
    }
}

