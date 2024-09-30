package br.unipar.programacaoweb.taskandtracker.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habito_id", referencedColumnName = "id")
    private Habito habito;

}