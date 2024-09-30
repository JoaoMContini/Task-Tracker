package br.unipar.programacaoweb.taskandtracker.controller;

import br.unipar.programacaoweb.taskandtracker.model.Habito;
import br.unipar.programacaoweb.taskandtracker.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/habitos")
public class HabitoController {

    @Autowired
    private HabitoService habitoService;

    @GetMapping("/form")
    public String exibirFormHabito(Model model) {
        model.addAttribute("habito", new Habito());
        return "habito-form";
    }


    @PostMapping("/salvar")
    public String salvarHabito(@ModelAttribute("habito") Habito habito) {
        habitoService.salvar(habito);
        return "redirect:/habitos/listar";
    }

    @GetMapping("/listar")
    public String listarHabitos(Model model) {
        List<Habito> habitos = habitoService.listarTodos();
        model.addAttribute("habitos", habitos);
        return "habito-lista";
    }


    @GetMapping("/editar/{id}")
    public String editarHabito(@PathVariable("id") Long id, Model model) {
        Optional<Habito> habito = habitoService.buscarPorId(id);
        model.addAttribute("habito", habito);
        return "habito-form";
    }


    @GetMapping("/deletar/{id}")
    public String deletarHabito(@PathVariable("id") Long id) {
        habitoService.excluirPorId(id);
        return "redirect:/habitos/listar";
    }
}
