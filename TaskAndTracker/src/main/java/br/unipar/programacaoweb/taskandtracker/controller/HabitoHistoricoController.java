package br.unipar.programacaoweb.taskandtracker.controller;

import br.unipar.programacaoweb.taskandtracker.model.HabitoHistorico;
import br.unipar.programacaoweb.taskandtracker.service.HabitoHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habitos/historico")
public class HabitoHistoricoController {

    @Autowired
    private HabitoHistoricoService habitoHistoricoService;


    @GetMapping("/listar")
    public String listarHistoricoHabitos(Model model) {
        List<HabitoHistorico> historico = habitoHistoricoService.listarTodos();
        model.addAttribute("historico", historico);
        return "habito-historico-lista";  // Página para listar o histórico de hábitos
    }


    @GetMapping("/registrar/{id}")
    public String registrarHabitoHistorico(@PathVariable("id") HabitoHistorico habitoHistorico) {
        habitoHistoricoService.salvar(habitoHistorico);
        return "redirect:/habitos/historico/listar";
    }
}
