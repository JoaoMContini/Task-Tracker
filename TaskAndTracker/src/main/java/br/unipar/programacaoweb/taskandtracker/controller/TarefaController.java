package br.unipar.programacaoweb.taskandtracker.controller;
import br.unipar.programacaoweb.taskandtracker.model.Tarefa;
import br.unipar.programacaoweb.taskandtracker.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.unipar.programacaoweb.taskandtracker.service.TarefaService;
import br.unipar.programacaoweb.taskandtracker.service.UsuarioService;

import java.util.Optional;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/{usuarioId}")
    public String listarTarefas(@PathVariable Long usuarioId, Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(usuarioId);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            model.addAttribute("tarefas", tarefaService.listarPorUsuario(usuario));
            model.addAttribute("usuario", usuario);
            return "tarefa-lista";
        } else {
            return "redirect:/usuarios";
        }
    }

    @GetMapping("/usuario/{usuarioId}/nova")
    public String novaTarefaForm(@PathVariable Long usuarioId, Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(usuarioId);
        if (usuarioOpt.isPresent()) {
            Tarefa tarefa = new Tarefa();
            tarefa.setUsuario(usuarioOpt.get());
            model.addAttribute("tarefa", tarefa);
            return "tarefa-form";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping
    public String salvarTarefa(@ModelAttribute("tarefa") Tarefa tarefa) {
        tarefaService.salvar(tarefa);
        return "redirect:/tarefas/usuario/" + tarefa.getUsuario().getId();
    }

    @GetMapping("/excluir/{id}")
    public String excluirTarefa(@PathVariable Long id) {
        Optional<Tarefa> tarefaOpt = tarefaService.buscarPorId(id);
        if (tarefaOpt.isPresent()) {
            Long usuarioId = tarefaOpt.get().getUsuario().getId();
            tarefaService.excluirPorId(id);
            return "redirect:/tarefas/usuario/" + usuarioId;
        } else {
            return "redirect:/usuarios";
        }
    }
}
