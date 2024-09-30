package br.unipar.programacaoweb.taskandtracker.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataLimite;
    private boolean concluida;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
