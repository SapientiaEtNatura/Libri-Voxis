package dev.ch.librivoxis.controller;

import dev.ch.librivoxis.model.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BibliotecaController {

    @GetMapping("/home")
    public String boasVindas(){
        return "Bem-Vindo a primeira Rota da Biblioteca";
    }

    @GetMapping("/home/contato")
    public String contateNos(){
        return "Esta tela é para ser o nosso contato";
    }

}
