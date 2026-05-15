package dev.ch.librivoxis.controller.Livro;

import dev.ch.librivoxis.model.Livro;
import dev.ch.librivoxis.service.Livro.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private final LivroService livroService;
    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    /* @GetMapping("/list")
    public ResponseEntity<List<Livro>> listarLivros(){
        List<Livro> livros = livroService.listarLivros();

        return ResponseEntity.ok(livros);
    } */



}
