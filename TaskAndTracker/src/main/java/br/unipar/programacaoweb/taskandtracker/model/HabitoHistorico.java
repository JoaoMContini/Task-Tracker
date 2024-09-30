package br.unipar.programacaoweb.taskandtracker.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Entity
@Getter
@Setter
public class HabitoHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "habito_id")
    private Habito habito;
}