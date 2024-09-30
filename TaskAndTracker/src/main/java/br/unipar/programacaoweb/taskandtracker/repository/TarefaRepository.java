package br.unipar.programacaoweb.taskandtracker.repository;

import br.unipar.programacaoweb.taskandtracker.model.Tarefa;
import br.unipar.programacaoweb.taskandtracker.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByUsuario(Usuario usuario);
}