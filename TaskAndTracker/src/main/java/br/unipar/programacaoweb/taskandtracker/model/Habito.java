package br.unipar.programacaoweb.taskandtracker.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;


@Entity
@Getter
@Setter
public class Habito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @OneToOne(mappedBy = "habito", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "habito", cascade = CascadeType.ALL)
    private List<HabitoHistorico> historico = new ArrayList<>();
}
