package br.unipar.programacaoweb.taskandtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TailwindController {

    @GetMapping("/tailwind")
    public String showTailwindPage() {
        return "tailwindPage";
    }
}
