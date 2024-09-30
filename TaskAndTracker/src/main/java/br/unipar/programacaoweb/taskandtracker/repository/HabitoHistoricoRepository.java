package br.unipar.programacaoweb.taskandtracker.repository;

import br.unipar.programacaoweb.taskandtracker.model.HabitoHistorico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HabitoHistoricoRepository extends JpaRepository<HabitoHistorico, Long> {
}