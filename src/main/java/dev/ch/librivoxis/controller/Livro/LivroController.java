package dev.ch.librivoxis.controller.Livro;

import dev.ch.librivoxis.model.Livro;
import dev.ch.librivoxis.service.Livro.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private final LivroService livroService;
    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros(){
        List<Livro> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarPorId(id);

        return ResponseEntity.ok(livro);
    }

    @PostMapping("/add")
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro){
        Livro livrocadastrado = livroService.cadastrarLivro(livro);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(livrocadastrado);
    }





}
