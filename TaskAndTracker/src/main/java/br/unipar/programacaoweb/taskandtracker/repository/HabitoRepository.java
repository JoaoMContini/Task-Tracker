package br.unipar.programacaoweb.taskandtracker.repository;

import br.unipar.programacaoweb.taskandtracker.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitoRepository extends JpaRepository<Habito, Long> {
}