package br.unipar.programacaoweb.taskandtracker.repository;

import br.unipar.programacaoweb.taskandtracker.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}